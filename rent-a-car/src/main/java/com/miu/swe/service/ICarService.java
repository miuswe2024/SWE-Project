package com.miu.swe.service;

import com.miu.swe.entity.Car;
import com.miu.swe.entity.Station;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ICarService {


    public List<Car> findAll();

    public List<Car> findByStation(Station station);

    public List<Car> findByMileageGreaterThan(Integer mileage);

    public Car create(Car car);

    public void deleteById(String registrationNr)throws Exception;

    public boolean canDelete(Car car) ;

}
