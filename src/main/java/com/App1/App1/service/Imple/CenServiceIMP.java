package com.App1.App1.service.Imple;

import com.App1.App1.model.dto.CenterDTO;
import com.App1.App1.model.dto.mapper.CenterMapper;
import com.App1.App1.model.entity.Center;
import com.App1.App1.model.entity.Fresher;
import com.App1.App1.model.entity.FreCen;
import com.App1.App1.repositories.CenterRepository;
import com.App1.App1.repositories.FreCenRepository;
import com.App1.App1.repositories.FresherRepository;
import com.App1.App1.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CenServiceIMP implements CenterService {
    @Autowired
    CenterRepository centerRepository;
    @Autowired
    FreCenRepository freCenRepository;
    @Autowired
    FresherRepository fresherRepository;

    @Override
    public List<Center> getAllCenter(){
        List<Center> centerList = centerRepository.findAll();
        if(!centerList.isEmpty()) {
            return centerList;
        }
        return Collections.emptyList();
    }
    @Override
    public Center addCenter(CenterDTO centerDTO) {
        CenterMapper centerMapper = new CenterMapper();
        Center center = centerMapper.toCenter(centerDTO);
        List<Center> centerList = centerRepository.findByCenterId(center.getCenterId());
        if(!centerList.isEmpty()) {
            return centerRepository.save(center);
        }
        return null;
    }
    @Override
    public void deleteCenter(String id) {
        boolean exists = centerRepository.existsById(id);
        if(exists) {
            centerRepository.deleteById(id);
        }

    }
    @Override
    public Center editCenter(CenterDTO centerDTO) {
        return centerRepository.findById(centerDTO.getCenterId())
                .map(center -> {
                    center.setCenterId(centerDTO.getCenterName());
                    center.setCenterAddress(centerDTO.getCenterAddress());
                    center.setCenterPhone(centerDTO.getCenterPhone());
                    return centerRepository.save(center);
                }).orElseGet(()->{
                    CenterMapper centerMapper = new CenterMapper();
                    Center center = centerMapper.toCenter(centerDTO);
                    return centerRepository.save(center);
                });
    }
    @Override
    public FreCen addFresherToCenter(String centerId, String fresherId) {
        FreCen freCen = new FreCen();
        fresherRepository.findById(fresherId).ifPresent(freCen::setFresher);
        centerRepository.findById(centerId).ifPresent(freCen::setCenter);
        return freCenRepository.save(freCen);
    }
    @Override
    public List<Fresher> getListFresherOfCenter(String string) {
        List<Fresher> fresherList = centerRepository.getFresherOfCenter(string);
        if(fresherList.isEmpty()) {
            return fresherList;
        }
        return Collections.emptyList();
    }
}