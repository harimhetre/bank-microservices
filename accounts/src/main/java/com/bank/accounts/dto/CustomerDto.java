package com.bank.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "Customer name should not be empty or null")
    @Size(min = 5, max = 30, message = "Customer name should be between 5 to 30")
    private String name;

    @NotEmpty(message = "Email should not be empty or null")
    @Email(message = "Email is not valid")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
    private String mobileNumber;

    private AccountsDto account;
}
