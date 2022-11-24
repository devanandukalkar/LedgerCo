package com.geektrust.ledgerco.services.impl;

import com.geektrust.ledgerco.entities.Borrower;
import com.geektrust.ledgerco.entities.Loan;
import com.geektrust.ledgerco.services.IBalanceService;
import com.geektrust.ledgerco.services.IBorrowerService;

public class BalanceServiceImpl implements IBalanceService {

    private final IBorrowerService borrowerService;

    public BalanceServiceImpl(IBorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @Override
    public String getBalanceForBorrower(String borrowerName, String bankName, Integer emiNumber) {
        Borrower borrower = borrowerService.findBorrowerByName(borrowerName);
        Loan borrowerLoan = borrower.getBorrowerLoan();
        int amountPaid = borrowerLoan.getEMIPerMonth() * emiNumber;
        int emiRemaining = borrowerLoan.getTotalEMIs() - emiNumber;

        return borrowerLoan.getLoanBank() + " " +
                borrower.getBorrowerName() + " " +
                amountPaid + " " +
                emiRemaining;
    }
}
