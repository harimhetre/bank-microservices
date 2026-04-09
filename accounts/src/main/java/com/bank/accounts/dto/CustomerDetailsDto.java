package com.bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
        name = "Customer Details",
        description = "Schema definition to hold schema for customer details"
)
@Data
public class CustomerDetailsDto {


    @Schema(description = "Customer name", example = "Hari Mhetre")
    @NotEmpty(message = "Customer name should not be empty or null")
    @Size(min = 5, max = 30, message = "Customer name should be between 5 to 30")
    private String name;

    @Schema(description = "Customer email address", example = "hari.mhetre22@gmail.com")
    @NotEmpty(message = "Email should not be empty or null")
    @Email(message = "Email is not valid")
    private String email;

    @Schema(description = "Customer mobile number", example = "1234567890")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
    private String mobileNumber;

    @Schema(description = "Customer account details")
    private AccountsDto account;

    @Schema(description = "Customer loans details")
    private LoansDto loansDto;

    @Schema(description = "Customer cards details")
    private CardsDto cardsDto;

}
