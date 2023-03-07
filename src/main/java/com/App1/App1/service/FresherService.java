package com.App1.App1.service;

import com.App1.App1.model.dto.FresherDTO;
import com.App1.App1.model.entity.Fresher;
import com.App1.App1.model.response.Transcript;

import java.util.List;

public interface FresherService {
    List<Fresher> getFresher();

    List<Transcript> getTranscript();

    Fresher addFresher(FresherDTO fresherDTO);

    Fresher editFresher(FresherDTO fresherDTO);

    void deleteFresher(String id);
}