package com.geektrust.ledgerco.commands;

import java.util.List;

public interface ICommand {
    void execute(List<String> tokens);
}
