package com.SumeyyeAzrak.services;

import com.SumeyyeAzrak.dto.DtoCustomer;

public interface ICustomerService {
    public DtoCustomer findCustomerById(Long id);
}
