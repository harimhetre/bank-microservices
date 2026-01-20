package com.bank.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "Schema definition for response schema")
public class ResponseDto {

    @Schema(name = "statusCode")
    private String statusCode;

    @Schema(name = "statusMessage")
    private String statusMessage;
}
