package com.miu.swe.repository;

import com.miu.swe.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStationRepository extends JpaRepository<Station, Integer> {
}
