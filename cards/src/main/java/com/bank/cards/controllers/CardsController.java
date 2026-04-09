package com.bank.cards.controllers;

import com.bank.cards.constants.CardsConstants;
import com.bank.cards.dto.CardsContactInfoDto;
import com.bank.cards.dto.CardsDto;
import com.bank.cards.dto.ResponseDto;
import com.bank.cards.services.ICardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
//@AllArgsConstructor
@Validated
@Tag(name = "CRUD operation for cards service", description = "This is Create, Fetch, Update, Delete operation for cards service")
public class CardsController {


    private final ICardsService iCardsService;

    public CardsController(ICardsService iCardsService) {
        this.iCardsService = iCardsService;
    }

    @Autowired
    private CardsContactInfoDto cardsContactInfoDto;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private Environment environment;



    @PostMapping("/create")
    @Operation(description = "Create operation to create card")
    @ApiResponse(responseCode = CardsConstants.STATUS_201, description = CardsConstants.MESSAGE_201)
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
    @ApiResponse(responseCode = CardsConstants.STATUS_200, description = CardsConstants.MESSAGE_200)
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
    @ApiResponse(responseCode = CardsConstants.STATUS_200, description = CardsConstants.MESSAGE_200)
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
    @ApiResponse(responseCode = CardsConstants.STATUS_200, description = CardsConstants.MESSAGE_200)
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



    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildNumber() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
    }



    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("java.version"));
    }



    @GetMapping("/contact-info")
    public ResponseEntity<CardsContactInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cardsContactInfoDto);
    }
}
