package com.bank.cards.controllers;

import com.bank.cards.constants.CardsConstants;
import com.bank.cards.dto.CardsDto;
import com.bank.cards.dto.ResponseDto;
import com.bank.cards.services.ICardsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
@Validated
public class CardsController {

    private ICardsService iCardsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create (

            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
            String mobileNumber
    ) {
        iCardsService.createCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CardsDto> fetch (

            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
            String mobileNumber
    ) {
        CardsDto cardsDto =  iCardsService.fetchCardDetails(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cardsDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto>  update (

            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
            String mobileNumber,

            @RequestBody
            @Valid
            CardsDto cardsDto
    ) {
        iCardsService.updateCard(mobileNumber, cardsDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> delete (
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
            String mobileNumber
    ) {
        iCardsService.deleteCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
    }
}
