package com.bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Schema(name = "Schema definition for Cards Schema")
public class CardsDto {

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
    @Schema( name = "mobileNumber", example = "1234567890")
    private String mobileNumber;

    @Pattern(regexp = "(^$|[0-9]{12})", message = "Card number should be 12 digit")
    @Schema(name = "cardNumber", example = "123456789012")
    private String cardNumber;

    @NotEmpty(message = "Card type should not be empty")
    @Schema(name = "cardType", example = "Credit")
    private String cardType;

    @Positive(message = "Total limit should be more than 0")
    @Schema(name = "totalLimit", example = "100000")
    private int totalLimit;

    @PositiveOrZero(message = "Amount used should be zero or more than zero")
    @Schema(name = "amountUsed", example = "20000")
    private int amountUsed;

    @PositiveOrZero(message = "Available amount should be zero or more than zero")
    @Schema(name = "availableAmount", example = "80000")
    private int availableAmount;
}
