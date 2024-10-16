package com.miu.swe.repository;

import com.miu.swe.entity.Car;
import com.miu.swe.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<Car, String> {
    List<Car> findByStation(Station station);
    List<Car> findByMileageGreaterThan(Integer mileage);
}
