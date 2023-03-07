package com.App1.App1.service.Imple;

import com.App1.App1.model.dto.FresherDTO;
import com.App1.App1.model.dto.mapper.FresherMapper;
import com.App1.App1.model.entity.Fresher;
import com.App1.App1.model.response.Transcript;
import com.App1.App1.repositories.FresherRepository;
import com.App1.App1.service.FresherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FreServiceIMP implements FresherService {
    @Autowired
    FresherRepository fresherRepository;

    @Override
    public List<Fresher> getFresher() {
        List<Fresher> fresherList = fresherRepository.findAll();
        if (!fresherList.isEmpty()) {
            return fresherList;
        }
        return Collections.emptyList(); // add throw
    }
    @Override
    public List<Transcript> getTranscript() {
        List<Transcript> transcriptList = fresherRepository.getTranscript();
        if(!transcriptList.isEmpty()) {
            return transcriptList;
        }
        return Collections.emptyList(); // add throw
    }
    @Override
    public Fresher addFresher(FresherDTO fresherDTO) {
        FresherMapper fresherMapper = new FresherMapper();
        Fresher fresher = fresherMapper.toFresher(fresherDTO);
        List<Fresher> fresherList = fresherRepository.findByFresherId(fresher.getFresherId());
        if(fresherList.isEmpty()){
            return fresherRepository.save(fresher);
        }
        return null; // add throw
    }
    @Override
    public Fresher editFresher(FresherDTO fresherDTO) {
        FresherMapper fresherMapper = new FresherMapper();
        return fresherRepository.findById(fresherDTO.getFresherId())
                .map(fresher -> {
                    fresher.setFresherName(fresherDTO.getFresherName());
                    fresher.setFresherAddress(fresherDTO.getFresherAddress());
                    fresher.setFresherPhone(fresherDTO.getFresherPhone());
                    fresher.setFresherEmail(fresherDTO.getFresherEmail());
                    return fresherRepository.save(fresher);
                }).orElseGet(()->{
                    Fresher fresher = fresherMapper.toFresher(fresherDTO);
                    return fresherRepository.save(fresher);
                });
    }
    @Override
    public void deleteFresher(String id) {
        boolean exists = fresherRepository.existsById(id);
        if(exists) {
            fresherRepository.deleteById(id);
        }
    }

}