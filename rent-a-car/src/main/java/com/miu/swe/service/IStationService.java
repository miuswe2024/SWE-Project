package com.miu.swe.service;

import com.miu.swe.entity.Station;

import java.util.List;

public interface IStationService {
    public List<Station> findAll();
    public boolean existsById(Integer id);
}
