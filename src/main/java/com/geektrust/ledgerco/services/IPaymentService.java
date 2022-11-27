package com.geektrust.ledgerco.services;

public interface IPaymentService {
    void savePaymentToBorrowerLoanAccount(String bankName, String borrowerName, Double payment, Integer emiPaidTillPayment);
}
