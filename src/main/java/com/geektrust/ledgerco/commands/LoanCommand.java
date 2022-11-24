package com.geektrust.ledgerco.commands;

import com.geektrust.ledgerco.entities.Loan;
import com.geektrust.ledgerco.services.IBorrowerService;
import com.geektrust.ledgerco.services.ILoanService;

import java.util.List;

public class LoanCommand implements ICommand {

    private final IBorrowerService borrowerService;
    private final ILoanService loanService;

    public LoanCommand(IBorrowerService borrowerService, ILoanService loanService) {
        this.borrowerService = borrowerService;
        this.loanService = loanService;
    }

    @Override
    public void execute(List<String> tokens) {
        String bankName = tokens.get(1);
        String borrowerName = tokens.get(2);
        Double loanPrincipal = Double.valueOf(tokens.get(3));
        Integer loanTenureInYears = Integer.valueOf(tokens.get(4));
        Double loanInterestRate = Double.valueOf(tokens.get(5));

        Loan loan = loanService.saveLoan(bankName, loanPrincipal, loanTenureInYears, loanInterestRate);
        borrowerService.saveBorrower(borrowerName, loan);
    }
}
