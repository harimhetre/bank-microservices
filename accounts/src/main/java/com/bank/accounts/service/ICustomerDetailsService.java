package com.bank.accounts.service;

import com.bank.accounts.dto.CustomerDetailsDto;

public interface ICustomerDetailsService {
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
