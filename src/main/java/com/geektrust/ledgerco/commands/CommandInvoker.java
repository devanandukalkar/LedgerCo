package com.geektrust.ledgerco.commands;

import com.geektrust.ledgerco.exceptions.CommandNotFoundException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CommandInvoker.java is used to register a command coming from Configuration.java
 * and encapsulate incoming command request.
 */
public class CommandInvoker {

    private static final Map<String, ICommand> commandMap = new HashMap<>();

    public void registerCommand(String commandKeyword, ICommand command) {
        commandMap.put(commandKeyword, command);
    }

    private ICommand get(String commandName) {
        return commandMap.get(commandName);
    }

    public List<String> parse(String input) {
        return Arrays.asList(input.split(" "));
    }

    public void invokeCommand(String input) {
        List<String> tokens = parse(input);
        ICommand command = get(tokens.get(0));
        if (command == null) {
            throw new CommandNotFoundException("Invalid command!");
        }
        command.execute(tokens);
    }
}
