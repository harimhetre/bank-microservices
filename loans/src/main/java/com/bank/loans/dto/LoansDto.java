package com.bank.loans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class LoansDto {

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
    private String mobileNumber;

    @Pattern(regexp = "(^$|[0-9]{12})", message = "Loan number should be 12 digit")
    private String loanNumber;

    @NotEmpty(message = "Loan type should not be the null or empty")
    private String loanType;

    @Positive(message = "Total loan amount should be greater than zero")
    private int totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    private int amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    private int outstandingAmount;
}
