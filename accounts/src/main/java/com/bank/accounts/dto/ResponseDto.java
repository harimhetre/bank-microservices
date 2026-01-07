package com.bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Schema(
        name = "Response",
        description = "Schema definition to hold schema for response"
)
@Data
@AllArgsConstructor
public class ResponseDto {

    @Schema(description = "Status Code")
    private String statusCode;

    @Schema(description = "Status Message")
    private String statusMsg;
}
