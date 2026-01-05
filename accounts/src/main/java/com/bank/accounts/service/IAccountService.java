package com.bank.accounts.service;

import com.bank.accounts.dto.CustomerDto;

public interface IAccountService {

    void createAccount(CustomerDto customerDto);

    CustomerDto fetch(String mobileNumber);

    Boolean update(CustomerDto customerDto);

    boolean delete(String mobileNumber);
}
