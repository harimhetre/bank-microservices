package com.bank.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(description = "Schema definition for Error Response")
public class ErrorResponseDto {

    @Schema(name = "API Path")
    private String apiPath;

    @Schema(name = "Status")
    private HttpStatus status;

    @Schema(name = "Error Message")
    private String errorMessage;

    @Schema(name = "Timestamp")
    private LocalDateTime timestamp;
}
