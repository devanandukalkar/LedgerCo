package com.geektrust.ledgerco.services;

public interface IBalanceService {
    String getBalanceForBorrower(String borrowerName, String bankName, Integer emiNumber);
}
