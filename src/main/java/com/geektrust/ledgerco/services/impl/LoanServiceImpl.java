package com.geektrust.ledgerco.services.impl;

import com.geektrust.ledgerco.entities.Loan;
import com.geektrust.ledgerco.repositories.ILoanRepository;
import com.geektrust.ledgerco.services.ILoanService;


public class LoanServiceImpl implements ILoanService {

    private final ILoanRepository loanRepository;

    public LoanServiceImpl(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan saveLoan(String bankName, Double principal, Integer years, Double interestRate) {
        Loan loan = new Loan(bankName, principal, years, interestRate);
        return loanRepository.save(loan);
    }

    @Override
    public Loan getLoanById(Integer loanId) {
        return loanRepository.findById(loanId);
    }
}
