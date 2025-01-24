package com.SumeyyeAzrak.services.impl;

import com.SumeyyeAzrak.dto.DtoAddress;
import com.SumeyyeAzrak.dto.DtoCustomer;
import com.SumeyyeAzrak.entites.Address;
import com.SumeyyeAzrak.entites.Customer;
import com.SumeyyeAzrak.repository.CustomerRepository;
import com.SumeyyeAzrak.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;



    @Override
    public DtoCustomer findCustomerById(Long id) {

        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();

        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isEmpty()) {

            return null;
        }

        Customer customer = optional.get();
        Address address = optional.get().getAddress();

        BeanUtils.copyProperties(customer, dtoCustomer);
        BeanUtils.copyProperties(address,dtoAddress);

        dtoCustomer.setAddress(dtoAddress);

        return dtoCustomer;
    }

}
