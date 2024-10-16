package com.miu.swe.service.impl;


import com.miu.swe.entity.Customer;
import com.miu.swe.repository.ICustomerRepository;
import com.miu.swe.repository.IRentalRepository;
import com.miu.swe.service.ICustomerService;
import com.miu.swe.bean.MessagesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private MessagesBean messages;
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IRentalRepository IRentalRepository;
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer create(Customer customer) {
        if (customerRepository.existsById(customer.getCustomerNumber()))
            throw new EntityExistsException(messages.get("customerAlreadyExists"));

        return customerRepository.save(customer);
    }

    public boolean existsById(Integer id) {
        return customerRepository.existsById(id);
    }

    public void deleteById(Integer id) throws Exception{
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(messages.get("customerNotFound")));
        if (!canDelete(customer))
            throw new IllegalArgumentException(messages.get("customerDeleteError"));

        customerRepository.delete(customer);
    }

    public boolean canDelete(Customer customer) {
        return IRentalRepository.findByDriver(customer).isEmpty();
    }
}
