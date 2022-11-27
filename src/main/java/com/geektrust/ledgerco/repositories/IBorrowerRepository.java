package com.geektrust.ledgerco.repositories;

import com.geektrust.ledgerco.entities.Borrower;

import java.util.Optional;

public interface IBorrowerRepository {
    Borrower save(Borrower borrower);
    Borrower findByName(String name);
}
