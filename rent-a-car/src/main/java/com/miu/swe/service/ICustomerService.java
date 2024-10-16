package com.miu.swe.service;

import com.miu.swe.entity.Customer;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface ICustomerService {
    public List<Customer> findAll();

    public Customer create(Customer customer);

    public boolean existsById(Integer id);

    public void deleteById(Integer id) throws Exception;

    public boolean canDelete(Customer customer);
}
