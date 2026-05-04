package com.bank.accounts.controller;

import com.bank.accounts.constants.AccountConstants;
import com.bank.accounts.dto.AccountContactInfoDto;
import com.bank.accounts.dto.CustomerDto;
import com.bank.accounts.dto.ErrorResponseDto;
import com.bank.accounts.dto.ResponseDto;
import com.bank.accounts.service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
//@AllArgsConstructor
@Validated
@Tag(
        name = "CRUD operations for accounts microservice",
        description = "Create, fetch, update and delete operation for an account microservice"
)
public class AccountController {

    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    public Environment environment;

    @Autowired
    public AccountContactInfoDto accountContactInfoDto;

    @Operation(
            summary = "Create API for accounts REST API",
            description = "This is create API to create customer and account"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }



    @Operation(
            summary = "Fetch API for accounts REST API",
            description = "This is fetch API to fetch customer and account"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200"
    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetch(
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
            String mobileNumber
    ) {
        CustomerDto customerDto = accountService.fetch(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }


    @Operation(
            summary = "Update API for accounts REST API",
            description = "This is update API to update customer and account"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status 200"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status 500",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> update(@Valid @RequestBody CustomerDto customerDto) {
        Boolean isUpdated = accountService.update(customerDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_MODIFIED)
                    .body(new ResponseDto(AccountConstants.MESSAGE_417_UPDATE, AccountConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary = "Delete API for accounts REST API",
            description = "This is delete API to delete customer and account"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status 200"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status 500"
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> delete(
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digit")
            String mobileNumber
    ) {
        boolean isDeleted = accountService.delete(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountConstants.MESSAGE_417_DELETE, AccountConstants.MESSAGE_417_DELETE));
        }
    }

    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
    }

    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("MAVEN_HOME"));
    }

    @GetMapping("/contact-info")
    public ResponseEntity<AccountContactInfoDto> getAccountContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountContactInfoDto);
    }
}
