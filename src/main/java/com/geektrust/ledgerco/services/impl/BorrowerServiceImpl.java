package com.geektrust.ledgerco.services.impl;

import com.geektrust.ledgerco.entities.Borrower;
import com.geektrust.ledgerco.entities.Loan;
import com.geektrust.ledgerco.repositories.IBorrowerRepository;
import com.geektrust.ledgerco.services.IBorrowerService;

public class BorrowerServiceImpl implements IBorrowerService {

    private final IBorrowerRepository borrowerRepository;

    public BorrowerServiceImpl(IBorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    @Override
    public Borrower saveBorrower(String borrowerName, Loan borrowerLoan) {
        // Check if borrower is already present in the repository
        Borrower borrower = findBorrowerByName(borrowerName);
        if (borrower.getBorrowerName() == null)
            borrower = new Borrower(borrowerName);

        borrower.addBorrowerLoan(borrowerLoan);
        return borrowerRepository.save(borrower);
    }

    @Override
    public Borrower findBorrowerByName(String borrowerName) {
        return borrowerRepository.findByName(borrowerName);
    }
}
