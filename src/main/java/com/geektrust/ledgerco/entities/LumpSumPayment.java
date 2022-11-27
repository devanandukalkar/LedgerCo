package com.geektrust.ledgerco.entities;

public class LumpSumPayment {
    private final Double paymentAmount;
    private final Integer emiPaidTillPayment;

    public LumpSumPayment(Double paymentAmount, Integer emiPaidTillPayment) {
        this.paymentAmount = paymentAmount;
        this.emiPaidTillPayment = emiPaidTillPayment;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public Integer getEmiPaidTillPayment() {
        return emiPaidTillPayment;
    }

    public int getNumberOfEmiReducedForLumpSumPayment(int emiPerMonth) {
//        System.out.println(paymentAmount);
//        System.out.println(emiPerMonth);
//        System.out.println(Math.round(paymentAmount/emiPerMonth));
        return (int) Math.round(paymentAmount/emiPerMonth);
    }
}
