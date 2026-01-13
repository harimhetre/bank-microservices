package com.bank.loans.mapper;

import com.bank.loans.dto.LoansDto;
import com.bank.loans.entity.Loans;

import java.time.LocalDateTime;

public class LoansMapper {

    public static LoansDto mapToLoansDto(Loans loans, LoansDto loansDto) {
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setMobileNumber(loans.getMobileNumber());
        return loansDto;
    }

    public static Loans mapToLoans(LoansDto loansDto, Loans loans) {
        loans.setMobileNumber(loansDto.getMobileNumber());
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        loans.setLoanType(loansDto.getLoanType());
        loans.setTotalLoan(loansDto.getTotalLoan());
        return loans;
    }
}
