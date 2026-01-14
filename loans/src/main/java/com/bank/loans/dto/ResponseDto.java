package com.bank.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Schema definition for Response")
public class ResponseDto {

    @Schema(name = "Status Code")
    private String statusCode;

    @Schema(name = "Status Message")
    private String statusMessage;
}
