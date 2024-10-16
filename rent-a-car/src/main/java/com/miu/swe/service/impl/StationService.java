package com.miu.swe.service.impl;

import com.miu.swe.entity.Station;
import com.miu.swe.repository.IStationRepository;
import com.miu.swe.service.IStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService implements IStationService {
    @Autowired
    private IStationRepository IStationRepository;
    public List<Station> findAll() {
        return IStationRepository.findAll();
    }
    public boolean existsById(Integer id) {
        return IStationRepository.existsById(id);
    }


}
