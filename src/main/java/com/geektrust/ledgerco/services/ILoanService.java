package com.geektrust.ledgerco.services;

import com.geektrust.ledgerco.entities.Loan;

public interface ILoanService {
    Loan saveLoan(String bankName, Double principal, Integer years, Double interestRate);
}
