package com.bank.accounts.controller;

import com.bank.accounts.dto.CustomerDetailsDto;
import com.bank.accounts.service.ICustomerDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Tag(
        name = "APIs for customer details",
        description = "This is APIs for customer details"
)
public class CustomerDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDetailsController.class);

    private final ICustomerDetailsService customerDetailsService;

    public CustomerDetailsController(ICustomerDetailsService customerDetailsService) {
        this.customerDetailsService = customerDetailsService;
    }

    @Operation(
            summary = "Fetch API for customer details REST API",
            description = "This is fetch API to fetch customer details"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200"
    )

   @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails (
            @RequestHeader("X-Correlation-Id")  String correlationId,
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
            String mobileNumber
    ) {
       CustomerDetailsDto customerDetailsDto =  customerDetailsService.fetchCustomerDetails(correlationId, mobileNumber);
       LOGGER.debug("X-Correlation-Id found inbound: {}", correlationId);
       return ResponseEntity.status(HttpStatus.OK).body(customerDetailsDto);
   }
}
