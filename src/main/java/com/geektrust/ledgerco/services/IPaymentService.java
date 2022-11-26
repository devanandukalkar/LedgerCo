package com.geektrust.ledgerco.services;

public interface IPaymentService {
    void savePaymentToBorrowerAccount(String bankName, String borrowerName, Integer payment, Integer emiPaidTillPayment);
}
