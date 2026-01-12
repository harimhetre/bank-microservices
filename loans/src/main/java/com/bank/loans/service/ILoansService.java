package com.bank.loans.service;

import com.bank.loans.dto.LoansDto;

import java.util.Optional;

public interface ILoansService {
    boolean create(String mobileNumber);

    LoansDto fetchLoanDetails(String mobileNumber);
}
