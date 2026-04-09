package com.bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(
        name = "Schema definition for loans"
)
public class LoansDto {

    @Schema(name = "mobileNumber", example = "1234567890")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
    private String mobileNumber;

    @Schema(name = "loanNumber", example = "123456789012")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Loan number should be 12 digit")
    private String loanNumber;

    @Schema(name = "loanType", example = "Savings")
    @NotEmpty(message = "Loan type should not be the null or empty")
    private String loanType;

    @Schema(name = "totalLoan", example = "100000")
    @Positive(message = "Total loan amount should be greater than zero")
    private int totalLoan;

    @Schema(name = "amountPaid", example = "10000")
    @PositiveOrZero(message = "Amount paid should be equal or greater than zero")
    private int amountPaid;

    @Schema(name = "outstandingAmount", example = "90000")
    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    private int outstandingAmount;
}
