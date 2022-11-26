package com.geektrust.ledgerco.services.impl;

import com.geektrust.ledgerco.entities.Borrower;
import com.geektrust.ledgerco.entities.Loan;
import com.geektrust.ledgerco.entities.LumpSumPayment;
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

        /*
            Display Balance Logic
            1. If balance is requested for the month before Lump-sum Payment, do not include calculation for
               payment and its reduced emi.
        */
        int amountPaid;
        int emiRemaining;
        int emiPerMonth = borrowerLoan.getEMIPerMonth();
        int totalLoanEmi = borrowerLoan.getTotalEMIs();
        LumpSumPayment lumpSumPayment = borrower.getLumpSumPayment();

        if (lumpSumPayment == null || emiNumber < lumpSumPayment.getEmiPaidTillPayment()) {
            amountPaid = emiPerMonth * emiNumber;
            emiRemaining = totalLoanEmi - emiNumber;
        } else {
            amountPaid = (emiPerMonth * emiNumber) + lumpSumPayment.getPaymentAmount();
            emiRemaining = totalLoanEmi - (lumpSumPayment.getNumberOfEmiReducedForLumpSumPayment(emiPerMonth) + emiNumber);
        }


        return borrowerLoan.getLoanBank() + " " +
                borrower.getBorrowerName() + " " +
                amountPaid + " " +
                emiRemaining;
    }
}
