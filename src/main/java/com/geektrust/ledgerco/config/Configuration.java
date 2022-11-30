package com.geektrust.ledgerco.config;

import com.geektrust.ledgerco.commands.*;
import com.geektrust.ledgerco.repositories.IBorrowerRepository;
import com.geektrust.ledgerco.repositories.ILoanRepository;
import com.geektrust.ledgerco.repositories.impl.BorrowerRepositoryImpl;
import com.geektrust.ledgerco.repositories.impl.LoanRepositoryImpl;
import com.geektrust.ledgerco.services.IBalanceService;
import com.geektrust.ledgerco.services.IBorrowerService;
import com.geektrust.ledgerco.services.ILoanService;
import com.geektrust.ledgerco.services.IPaymentService;
import com.geektrust.ledgerco.services.impl.BalanceServiceImpl;
import com.geektrust.ledgerco.services.impl.BorrowerServiceImpl;
import com.geektrust.ledgerco.services.impl.LoanServiceImpl;
import com.geektrust.ledgerco.services.impl.PaymentServiceImpl;

public class Configuration {

    // Singleton instance
    private static final Configuration instance = new Configuration();
    // Initialize all repositories
    private final ILoanRepository loanRepository = new LoanRepositoryImpl();
    private final IBorrowerRepository borrowerRepository = new BorrowerRepositoryImpl();
    // Initialize all services
    private final ILoanService loanService = new LoanServiceImpl(loanRepository);
    private final IBorrowerService borrowerService = new BorrowerServiceImpl(borrowerRepository);
    private final IBalanceService balanceService = new BalanceServiceImpl(borrowerService);
    private final BalanceCommand balanceCommand = new BalanceCommand(balanceService);
    private final IPaymentService paymentService = new PaymentServiceImpl(borrowerService);
    private final PaymentCommand paymentCommand = new PaymentCommand(paymentService);
    // Initialize all commands
    private final LoanCommand loanCommand = new LoanCommand(borrowerService, loanService);
    // Initialize command Invoker
    private final CommandInvoker commandInvoker = new CommandInvoker();


    private Configuration() {
    }

    public static Configuration getInstance() {
        return instance;
    }

    private void registerCommands() {
        commandInvoker.registerCommand(CommandKeyword.LOAN_COMMAND.getName(), loanCommand);
        commandInvoker.registerCommand(CommandKeyword.BALANCE_COMMAND.getName(), balanceCommand);
        commandInvoker.registerCommand(CommandKeyword.PAYMENT_COMMAND.getName(), paymentCommand);
    }

    public CommandInvoker getCommandInvoker() {
        registerCommands();
        return commandInvoker;
    }
}
