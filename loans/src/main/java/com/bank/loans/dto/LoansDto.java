package com.bank.loans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class LoansDto {

    private String MobileNumber;
    private String LoanNumber;
    private String LoanType;
    private int totalLoan;
    private int AmountPaid;
    private int outstandingAmount;
}
