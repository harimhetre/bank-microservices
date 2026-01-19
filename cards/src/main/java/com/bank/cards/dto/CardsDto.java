package com.bank.cards.dto;

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
public class CardsDto {

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
    private String mobileNumber;

    @Pattern(regexp = "(^$|[0-9]{12})", message = "Card number should be 12 digit")
    private String cardNumber;

    @NotEmpty(message = "Card type should not be empty")
    private String cardType;

    @Positive(message = "Total limit should be more than 0")
    private int totalLimit;

    @PositiveOrZero(message = "Amount used should be zero or more than zero")
    private int amountUsed;

    @PositiveOrZero(message = "Available amount should be zero or more than zero")
    private int availableAmount;
}
