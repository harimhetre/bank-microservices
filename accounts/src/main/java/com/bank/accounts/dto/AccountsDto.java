package com.bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
        name = "Account",
        description = "Schema definition to hold schema for account"
)
@Data
public class AccountsDto {

    @Schema(description = "Account number", example = "98637482648")
    @Pattern(regexp = "^\\\\d{10}$", message = "Account number should be 10 digit")
    private Long accountNumber;

    @Schema(description = "Account Type", example = "saving")
    @NotEmpty(message = "Account type should not be empty or null")
    private String accountType;

    @Schema(description = "Branch Address", example = "Hadapsar, Pune")
    @NotEmpty(message = "Branch Address should not be empty or null")
    private String branchAddress;
}
