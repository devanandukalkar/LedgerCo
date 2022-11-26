package com.geektrust.ledgerco.entities;

public class LumpSumPayment {
    private final Integer paymentAmount;
    private final Integer emiPaidTillPayment;

    public LumpSumPayment(Integer paymentAmount, Integer emiPaidTillPayment) {
        this.paymentAmount = paymentAmount;
        this.emiPaidTillPayment = emiPaidTillPayment;
    }

    public Integer getPaymentAmount() {
        return paymentAmount;
    }

    public Integer getEmiPaidTillPayment() {
        return emiPaidTillPayment;
    }

    public int getNumberOfEmiReducedForLumpSumPayment(int emiPerMonth) {
        return paymentAmount/emiPerMonth;
    }
}
