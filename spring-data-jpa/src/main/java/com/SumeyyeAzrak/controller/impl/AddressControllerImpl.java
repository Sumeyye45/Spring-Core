package com.SumeyyeAzrak.controller.impl;


import com.SumeyyeAzrak.controller.IAddressController;
import com.SumeyyeAzrak.dto.DtoAddress;
import com.SumeyyeAzrak.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/address")
public class AddressControllerImpl implements IAddressController {

    @Autowired
    private IAddressService addressService;

    @GetMapping(path = "/list/{id}")
    public DtoAddress findAddressById(@PathVariable(name = "id") Long id) {
        return addressService.findAddressById(id);
    }



}
