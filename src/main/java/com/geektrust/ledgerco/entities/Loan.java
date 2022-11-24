package com.geektrust.ledgerco.entities;

public class Loan {
    private final Integer loanId;
    private final String loanBank;
    private final Double loanPrincipal;
    private final Integer loanTenureInYears;
    private final Double loanInterestRate;

    public Loan(Integer loanId, String loanBank, Double loanPrincipal, Integer loanTenureInYears, Double loanInterestRate) {
        this.loanId = loanId;
        this.loanBank = loanBank;
        this.loanPrincipal = loanPrincipal;
        this.loanTenureInYears = loanTenureInYears;
        this.loanInterestRate = loanInterestRate;
    }

    public Loan(String loanBank, Double loanPrincipal, Integer loanTenureInYears, Double loanInterestRate) {
        this(null, loanBank, loanPrincipal, loanTenureInYears, loanInterestRate);
    }

    public Integer getLoanId() {
        return loanId;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public Double getLoanPrincipal() {
        return loanPrincipal;
    }

    public Integer getLoanTenureInYears() {
        return loanTenureInYears;
    }

    public Double getLoanInterestRate() {
        return loanInterestRate;
    }

    private Double getTotalLoanAmount() {
        Double interestOnLoan = this.loanPrincipal * this.loanTenureInYears * (this.loanInterestRate / 100);
        return this.loanPrincipal + interestOnLoan;
    }

    public int getTotalEMIs() {
        return this.getLoanTenureInYears() * 12;
    }

    public int getEMIPerMonth() {
        return (int) Math.ceil(getTotalLoanAmount() / getTotalEMIs());
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanBank='" + loanBank + '\'' +
                ", loanPrincipal=" + loanPrincipal +
                ", loanTenureInYears=" + loanTenureInYears +
                ", loanInterestRate=" + loanInterestRate +
                '}';
    }
}
