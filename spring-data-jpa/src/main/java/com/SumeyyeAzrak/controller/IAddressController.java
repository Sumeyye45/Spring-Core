package com.SumeyyeAzrak.controller;

import com.SumeyyeAzrak.dto.DtoAddress;

public interface IAddressController {

    public DtoAddress findAddressById(Long id);
}
