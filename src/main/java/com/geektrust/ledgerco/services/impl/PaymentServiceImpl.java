package com.geektrust.ledgerco.services.impl;

import com.geektrust.ledgerco.entities.Borrower;
import com.geektrust.ledgerco.entities.LumpSumPayment;
import com.geektrust.ledgerco.services.IBorrowerService;
import com.geektrust.ledgerco.services.IPaymentService;

public class PaymentServiceImpl implements IPaymentService {

    private final IBorrowerService borrowerService;

    public PaymentServiceImpl(IBorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @Override
    public void savePaymentToBorrowerAccount(String bankName, String borrowerName, Integer payment, Integer emiPaidTillPayment) {
        Borrower borrower = borrowerService.findBorrowerByName(borrowerName);
        LumpSumPayment lumpSumPayment = new LumpSumPayment(payment, emiPaidTillPayment);
        borrower.setLumpSumPayment(lumpSumPayment);
    }
}
