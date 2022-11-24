package com.geektrust.ledgerco.commands;

import com.geektrust.ledgerco.services.IBalanceService;

import java.util.List;

public class BalanceCommand implements ICommand {

    private final IBalanceService balanceService;

    public BalanceCommand(IBalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @Override
    public void execute(List<String> tokens) {
        String bankName = tokens.get(1);
        String borrowerName = tokens.get(2);
        Integer emiPaid = Integer.valueOf(tokens.get(3));

        String output = balanceService.getBalanceForBorrower(borrowerName, bankName, emiPaid);
        System.out.println(output);
    }
}
