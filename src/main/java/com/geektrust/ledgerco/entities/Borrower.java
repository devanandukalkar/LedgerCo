package com.geektrust.ledgerco.entities;

public class Borrower {
    private final String borrowerName;
    private final Loan borrowerLoan;
    private LumpSumPayment lumpSumPayment;

    public Borrower(String borrowerName, Loan borrowerLoan) {
        this.borrowerName = borrowerName;
        this.borrowerLoan = borrowerLoan;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public Loan getBorrowerLoan() {
        return borrowerLoan;
    }

    public LumpSumPayment getLumpSumPayment() {
        return lumpSumPayment;
    }

    public void setLumpSumPayment(LumpSumPayment lumpSumPayment) {
        this.lumpSumPayment = lumpSumPayment;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "borrowerName='" + borrowerName + '\'' +
                ", borrowerLoan=" + borrowerLoan +
                '}';
    }
}
