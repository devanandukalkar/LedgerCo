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
        Loan loan = borrower.getBorrowerLoanByBank(bankName);
        /*
            Display Balance Logic
            1. If balance is requested for the month before Lump-sum Payment, do not include calculation for
               payment and its reduced emi.
        */
        double amountPaid;
        int emiRemaining;
        int emiPerMonth = loan.getEMIPerMonth();
        int totalLoanEmi = loan.getTotalEMIs();
        LumpSumPayment lumpSumPayment = loan.getLumpSumPayment();

        if (lumpSumPayment == null || emiNumber < lumpSumPayment.getEmiPaidTillPayment()) {
            amountPaid = emiPerMonth * (double) emiNumber;
            emiRemaining = totalLoanEmi - emiNumber;
        } else {
//            System.out.println("emiPerMonth:" + emiPerMonth);
//            System.out.println("emiNumber:" + emiNumber);
//            System.out.println("withoutpayment:" +(emiPerMonth * emiNumber));
            amountPaid = (emiPerMonth * emiNumber) + lumpSumPayment.getPaymentAmount();
            emiRemaining = totalLoanEmi - (lumpSumPayment.getNumberOfEmiReducedForLumpSumPayment(emiPerMonth) + emiNumber);
            // Override amountPaid with TotalLoanAmount if emiRemaining is zero
            int zeroEmiPending = 0;
            if (emiRemaining == zeroEmiPending)
                amountPaid = loan.getTotalLoanAmount();
        }

        return loan.getLoanBank() + " " +
                borrower.getBorrowerName() + " " +
                (int) amountPaid + " " +
                emiRemaining;
    }
}
