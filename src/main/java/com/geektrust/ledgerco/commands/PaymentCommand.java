package com.geektrust.ledgerco.commands;

import com.geektrust.ledgerco.services.IPaymentService;

import java.util.List;

public class PaymentCommand implements ICommand {

    private final IPaymentService paymentService;

    public PaymentCommand(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void execute(List<String> tokens) {
        String bankName = tokens.get(1);
        String borrowerName = tokens.get(2);
        Integer payment = Integer.valueOf(tokens.get(3));
        Integer emiPaidTillPayment = Integer.valueOf(tokens.get(4));

        paymentService.savePaymentToBorrowerAccount(bankName, borrowerName, payment, emiPaidTillPayment);
    }
}
