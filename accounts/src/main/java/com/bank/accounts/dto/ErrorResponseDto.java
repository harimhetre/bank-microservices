package com.bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponse",
        description = "Schema definition to hold schema for Error Response"
)
@Data
@AllArgsConstructor
public class ErrorResponseDto {

    @Schema(description = "API Path")
    private String apiPath;

    @Schema(description = "HTTP Status")
    private HttpStatus status;

    @Schema(description = "Error Message")
    private String errorMessage;

    @Schema(description = "Error Time")
    private LocalDateTime errorTime;
}
