package com.miu.swe.service.impl;

import com.miu.swe.entity.Car;
import com.miu.swe.entity.Station;
import com.miu.swe.repository.ICarRepository;
import com.miu.swe.repository.IRentalRepository;
import com.miu.swe.service.ICarService;
import com.miu.swe.service.IStationService;
import com.miu.swe.bean.MessagesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CarService implements ICarService {

    @Autowired
    private MessagesBean messages;
    @Autowired
    private ICarRepository carRepository;
    @Autowired
    private IStationService stationService;
    @Autowired
    private IRentalRepository IRentalRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public List<Car> findByStation(Station station) {
        return carRepository.findByStation(station);
    }

    public List<Car> findByMileageGreaterThan(Integer mileage) {
        return carRepository.findByMileageGreaterThan(mileage);
    }

    public Car create(Car car) {
        if (car.getStation() == null)
            throw new IllegalArgumentException(messages.get("carStationNotNull"));

        if (car.getStation().getId() == null || !stationService.existsById(car.getStation().getId()))
            throw new EntityNotFoundException(messages.get("stationNotFound"));

        if (carRepository.existsById(car.getRegistrationNr()))
            throw new EntityExistsException(messages.get("carAlreadyExists"));

        return carRepository.save(car);
    }

    public void deleteById(String registrationNr) throws Exception{
        Car car = carRepository.findById(registrationNr)
                .orElseThrow(() -> new EntityNotFoundException(messages.get("carNotFound")));
        if (!canDelete(car))
            throw new IllegalArgumentException(messages.get("carDeleteError"));

        carRepository.delete(car);
    }

    public boolean canDelete(Car car) {
        return IRentalRepository.findByCar(car).isEmpty();
    }

}
