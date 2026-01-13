package com.bank.loans.controller;

import com.bank.loans.constants.LoansConstants;
import com.bank.loans.dto.LoansDto;
import com.bank.loans.dto.ResponseDto;
import com.bank.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LoansController {

    private ILoansService iLoansService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> create(@RequestParam String mobileNumber) {
        iLoansService.create(mobileNumber);
        return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetch(@RequestParam String mobileNumber) {
        LoansDto loansDto = iLoansService.fetchLoanDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loansDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto>  update(@RequestParam String mobileNumber, @RequestBody LoansDto loansDto) {
        iLoansService.updateLoan(mobileNumber, loansDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> delete(@RequestParam String mobileNumber) {
        iLoansService.deleteLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
    }

}
