package com.bank.loans.service.Impl;

import com.bank.loans.constants.LoansConstants;
import com.bank.loans.dto.LoansDto;
import com.bank.loans.entity.Loans;
import com.bank.loans.exception.LoanAlreadyExistException;
import com.bank.loans.exception.ResourceNotFoundException;
import com.bank.loans.repository.LoansRepository;
import com.bank.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private LoansRepository loansRepository;

    @Override
    public boolean create(String mobileNumber) {


      Optional<Loans> loans  = loansRepository.findByMobileNumber(mobileNumber);

      if (loans.isPresent()) {
          throw new LoanAlreadyExistException("Loan", "Mobile Number", mobileNumber);
      }

      loansRepository.save(createLoan(mobileNumber));

      return true;
    }

    private Loans createLoan(String mobileNumber) {
        Loans loans = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        loans.setMobileNumber(mobileNumber);
        loans.setLoanNumber(String.valueOf(randomLoanNumber));
        loans.setLoanType(LoansConstants.HOME_LOAN);
        loans.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        loans.setAmountPaid(0);
        loans.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        loans.setCreatedAt(LocalDateTime.now());
        loans.setCreatedBy("Loan Department");
        return loans;
    }

    @Override
    public LoansDto fetchLoanDetails(String mobileNumber) {
        Optional<Loans> fetchedLoan = loansRepository.findByMobileNumber(mobileNumber);

        if (fetchedLoan.isPresent()) {
            Loans loans = fetchedLoan.get();
            return mapToLoansDto(loans, new LoansDto());
        } else {
            throw new ResourceNotFoundException("Loan", "Mobile Number", mobileNumber);
        }
    }

    private LoansDto mapToLoansDto(Loans loans, LoansDto loansDto) {
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        loansDto.setLoanType(loans.getLoanType());
        loans.setMobileNumber(loans.getMobileNumber());
        return loansDto;
    }
}
