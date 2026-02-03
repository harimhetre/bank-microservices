package com.bank.loans.controller;

import com.bank.loans.constants.LoansConstants;
import com.bank.loans.dto.LoansContactInfoDto;
import com.bank.loans.dto.LoansDto;
import com.bank.loans.dto.ResponseDto;
import com.bank.loans.service.ILoansService;
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
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
//@AllArgsConstructor
@Validated
@Tag(
        name = "CRUD operation for loans microservices",
        description = "This CRUD operation for loans microservices to create, update, fetch and delete loan"
)
public class LoansController {

    private final ILoansService iLoansService;

    public LoansController(ILoansService iLoansService) {
        this.iLoansService = iLoansService;
    }

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private Environment environment;

    @Autowired
    private LoansContactInfoDto loansContactInfoDto;

    @Operation(
            description = "Create loan a loan by mobile number"
    )
    @ApiResponse(
            responseCode = LoansConstants.STATUS_201,
            description = LoansConstants.MESSAGE_201
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(@RequestParam
                                                  @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
                                                  String mobileNumber
    ) {
        iLoansService.create(mobileNumber);
        return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
    }

    @Operation(
            description = "get details of laon by mobile number"
    )
    @ApiResponse(
            responseCode = "200",
            description = LoansConstants.MESSAGE_200
    )
    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetch(@RequestParam
                                              @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
                                              String mobileNumber
    ) {
        LoansDto loansDto = iLoansService.fetchLoanDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loansDto);
    }

    @Operation(
            description = "get details of laon by mobile number"
    )
    @ApiResponse(
            responseCode = "200",
            description = LoansConstants.MESSAGE_200
    )


    @PutMapping("/update")
    public ResponseEntity<ResponseDto>  update(@RequestParam
                                                   @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
                                                   String mobileNumber,
                                               @Valid @RequestBody LoansDto loansDto
    ) {
        iLoansService.updateLoan(mobileNumber, loansDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
    }

    @Operation(
            description = "get details of laon by mobile number"
    )
    @ApiResponse(
            responseCode = "200",
            description = LoansConstants.MESSAGE_200
    )


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> delete(@RequestParam
                                                  @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
                                                  String mobileNumber
    ) {
        iLoansService.deleteLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
    }

    @GetMapping("/build-info")
    public ResponseEntity<String>  getBuildInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
    }

    @GetMapping("/java-version")
    public ResponseEntity<String>  getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("java.version"));
    }

    @GetMapping("/contact-info")
    public ResponseEntity<LoansContactInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loansContactInfoDto);
    }

}
