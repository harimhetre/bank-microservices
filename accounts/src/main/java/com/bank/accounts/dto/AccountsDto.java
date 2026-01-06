package com.bank.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {

    @Pattern(regexp = "^\\\\d{10}$", message = "Account number should be 10 digit")
    private Long accountNumber;

    @NotEmpty(message = "Account type should not be empty or null")
    private String accountType;

    @NotEmpty(message = "Branch Address should not be empty or null")
    private String branchAddress;
}
