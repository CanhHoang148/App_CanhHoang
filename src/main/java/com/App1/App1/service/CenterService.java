package com.App1.App1.service;

import com.App1.App1.model.dto.CenterDTO;
import com.App1.App1.model.entity.Center;
import com.App1.App1.model.entity.Fresher;
import com.App1.App1.model.entity.FreCen;

import java.util.List;

public interface CenterService {
    List<Center> getAllCenter();

    Center addCenter(CenterDTO centerDTO);

    void deleteCenter(String id);

    Center editCenter(CenterDTO centerDTO);

    FreCen addFresherToCenter(String centerId, String fresherId);

    List<Fresher> getListFresherOfCenter(String string);
}
