package com.geektrust.ledgerco.services.impl;

import com.geektrust.ledgerco.entities.Borrower;
import com.geektrust.ledgerco.entities.Loan;
import com.geektrust.ledgerco.entities.LumpSumPayment;
import com.geektrust.ledgerco.services.IBorrowerService;
import com.geektrust.ledgerco.services.IPaymentService;

public class PaymentServiceImpl implements IPaymentService {

    private final IBorrowerService borrowerService;

    public PaymentServiceImpl(IBorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @Override
    public void savePaymentToBorrowerLoanAccount(String bankName, String borrowerName, Double payment, Integer emiPaidTillPayment) {
        Borrower borrower = borrowerService.findBorrowerByName(borrowerName);
        Loan loan = borrower.getBorrowerLoanByBank(bankName);

        LumpSumPayment lumpSumPayment = new LumpSumPayment(payment, emiPaidTillPayment);
        loan.setLumpSumPayment(lumpSumPayment);
    }
}
