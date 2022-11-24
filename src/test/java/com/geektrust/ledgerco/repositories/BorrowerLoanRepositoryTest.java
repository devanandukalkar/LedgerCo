package com.geektrust.ledgerco.repositories;

import com.geektrust.ledgerco.entities.Borrower;
import com.geektrust.ledgerco.entities.Loan;
import com.geektrust.ledgerco.repositories.impl.BorrowerRepositoryImpl;
import com.geektrust.ledgerco.repositories.impl.LoanRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class BorrowerLoanRepositoryTest {

    private IBorrowerRepository borrowerRepository;
    private ILoanRepository loanRepository;

    @BeforeEach
    void setup() {
        Loan loan = new Loan(1, "IDIDI", 10000.00, 5, 4.0);
        String borrowerName = "John";
        Borrower borrower = new Borrower(borrowerName, loan);
        Map<String, Borrower> testBorrowerMap = new HashMap<String, Borrower>() {
            {
                put(borrowerName, borrower);
            }
        };

        Map<Integer, Loan> testLoanMap = new HashMap<Integer, Loan>() {
            {
                put(1, loan);
            }
        };

        borrowerRepository = new BorrowerRepositoryImpl(testBorrowerMap);
        loanRepository = new LoanRepositoryImpl(testLoanMap);
    }

    @Test
    @DisplayName("Save Borrower & Loan method should create Loan & Borrower and return borrower object")
    void saveBorrowerLoanRepositoryTest() {
        // Arrange
        Loan loan = new Loan(2, "MBI", 20000.00, 5, 4.0);
        Borrower expectedOutput = new Borrower("Jane", loan);

        // Act
        loanRepository.save(new Loan("MBI", 20000.00, 5, 4.0));
        borrowerRepository.save(new Borrower("Jane", loan));
        Borrower actualOutput = borrowerRepository.findByName("Jane");

        // Assert
        Assertions.assertTrue((expectedOutput.getBorrowerName().equals(actualOutput.getBorrowerName()))
                && (expectedOutput.getBorrowerLoan().getLoanId().equals(actualOutput.getBorrowerLoan().getLoanId())));
    }
}
