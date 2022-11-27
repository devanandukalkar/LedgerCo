package com.geektrust.ledgerco.repositories.impl;

import com.geektrust.ledgerco.entities.Borrower;
import com.geektrust.ledgerco.repositories.IBorrowerRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BorrowerRepositoryImpl implements IBorrowerRepository {

    private final Map<String, Borrower> borrowerMap;

    public BorrowerRepositoryImpl() {
        borrowerMap = new HashMap<>();
    }

    // For Unit test
    public BorrowerRepositoryImpl(Map<String, Borrower> borrowerMap) {
        this.borrowerMap = borrowerMap;
    }

    @Override
    public Borrower save(Borrower borrower) {
        borrowerMap.put(borrower.getBorrowerName(), borrower);
        return borrower;
    }

    @Override
    public Borrower findByName(String name) {
        Optional<Borrower> optionalBorrower = borrowerMap.values().stream().filter(borrower -> borrower.getBorrowerName().equals(name)).findAny();
        return optionalBorrower.orElseGet(Borrower::new);
    }
}
