package com.miu.swe.service;

import com.miu.swe.bean.FinishRentalBean;
import com.miu.swe.entity.Car;
import com.miu.swe.entity.Rental;
import java.util.List;
import java.util.Optional;

public interface IRentalService {
    public void create(Rental rental);

    public void finish(Rental rental, FinishRentalBean finishRentalBean);

    public List<Rental> findRunningRentals();

    public List<Rental> findAllRentals();

    public List<Rental> findByCar(Car car);

    public Optional<Rental> existsAndCanFinish(Integer id);

    public boolean canFinish(Rental rental);

    public boolean canCreate(Rental rental);

    public boolean cleanDates(Rental rental, FinishRentalBean finishRentalBean);

    public void deleteById(Integer id) throws Exception;
}
