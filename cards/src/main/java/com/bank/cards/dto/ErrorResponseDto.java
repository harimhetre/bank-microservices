package com.bank.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(name = "Schema definition for error response")
public class ErrorResponseDto {

    @Schema(name = "apiPath")
    private String apiPath;

    @Schema(name = "status")
    private HttpStatus status;

    @Schema(name = "errorMessage")
    private String errorMessage;

    @Schema(name = "timestamp")
    private LocalDateTime timestamp;
}
