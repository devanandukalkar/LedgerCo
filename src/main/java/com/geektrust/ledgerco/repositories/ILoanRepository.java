package com.geektrust.ledgerco.repositories;

import com.geektrust.ledgerco.entities.Loan;

public interface ILoanRepository {
    Loan save(Loan loan);
    Loan findById(Integer id);
}
