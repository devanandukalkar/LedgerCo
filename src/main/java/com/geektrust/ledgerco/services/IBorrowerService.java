package com.geektrust.ledgerco.services;

import com.geektrust.ledgerco.entities.Borrower;
import com.geektrust.ledgerco.entities.Loan;

public interface IBorrowerService {
    Borrower saveBorrower(String borrowerName, Loan borrowerLoan);

    Borrower findBorrowerByName(String borrowerName);
}
