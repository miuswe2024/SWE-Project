package com.miu.swe.service.impl;

import com.miu.swe.bean.FinishRentalBean;
import com.miu.swe.entity.Car;
import com.miu.swe.entity.Rental;
import com.miu.swe.repository.IRentalRepository;
import com.miu.swe.service.ICarService;
import com.miu.swe.service.IRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService implements IRentalService {

    @Autowired
    private IRentalRepository IRentalRepository;
    @Autowired
    private ICarService carService;
    public void create(Rental rental) {
        rental.setId(null);
        rental.setKm(null);
        rental.setReturnDate(null);
        rental.setReturnStation(null);
        rental.getCar().setStation(null);

        IRentalRepository.save(rental);
    }

    public void finish(Rental rental, FinishRentalBean finishRentalBean) {
        rental.setReturnStation(finishRentalBean.getReturnStation());
        rental.setKm(finishRentalBean.getKm());
        rental.getCar().setStation(rental.getReturnStation());
        rental.getCar().setMileage(rental.getCar().getMileage() + rental.getKm());

        IRentalRepository.save(rental);
    }

    public List<Rental> findRunningRentals() {
        return IRentalRepository.findRunningRentals();
    }

    public List<Rental> findAllRentals() {
        return IRentalRepository.findAll();
    }

    public List<Rental> findByCar(Car car) {
        return IRentalRepository.findByCar(car);
    }

    public Optional<Rental> existsAndCanFinish(Integer id) {
        if (id == null) return Optional.empty();

        Optional<Rental> opt = IRentalRepository.findById(id);
        Rental rental;
        if (opt.isPresent() && canFinish((rental = opt.get()))) return Optional.of(rental);
        else return Optional.empty();
    }

    public boolean canFinish(Rental rental) {
        return rental.getReturnDate() == null &&
                rental.getKm() == null && rental.getReturnStation() == null;
    }

    public boolean canCreate(Rental rental) {
        return carService.findByStation(rental.getRentalStation()).contains(rental.getCar());
    }

    public boolean cleanDates(Rental rental, FinishRentalBean finishRentalBean) {
        if (rental.getRentalDate().isAfter(finishRentalBean.getReturnDate())) {
            return false;
        } else {
            rental.setReturnDate(finishRentalBean.getReturnDate());
            return true;
        }
    }

    public void deleteById(Integer id) throws Exception{
        Rental rental = IRentalRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        IRentalRepository.delete(rental);
    }

}
