package com.miu.swe.repository;

import com.miu.swe.entity.Car;
import com.miu.swe.entity.Customer;
import com.miu.swe.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRentalRepository extends JpaRepository<Rental, Integer> {

    @Query("SELECT r FROM Rental r WHERE r.km IS NULL AND r.returnDate IS NULL AND r.returnStation IS NULL")
    List<Rental> findRunningRentals();
    List<Rental> findByCar(Car car);
    List<Rental> findByDriver(Customer driver);

}
