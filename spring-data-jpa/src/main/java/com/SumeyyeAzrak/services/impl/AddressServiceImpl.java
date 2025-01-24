package com.SumeyyeAzrak.services.impl;

import com.SumeyyeAzrak.dto.DtoAddress;
import com.SumeyyeAzrak.dto.DtoCustomer;
import com.SumeyyeAzrak.entites.Address;
import com.SumeyyeAzrak.repository.AddressRepository;
import com.SumeyyeAzrak.services.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public DtoAddress findAddressById(Long id) {

        DtoAddress dtoAddress = new DtoAddress();


        Optional<Address> optional = addressRepository.findById(id);

        if (optional.isEmpty()){
            return null;
        }
        Address address = optional.get();
        BeanUtils.copyProperties(address, dtoAddress);

        DtoCustomer dtoCustomer = new DtoCustomer();
        dtoCustomer.setId(address.getCustomer().getId());
        dtoCustomer.setName(address.getCustomer().getName());

     //   dtoCustomer.setAddress(dtoAddress);
        dtoAddress.setCustomer(dtoCustomer);

        return dtoAddress;
    }
}
