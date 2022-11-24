package com.geektrust.ledgerco;

import com.geektrust.ledgerco.commands.CommandInvoker;
import com.geektrust.ledgerco.config.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String fileName = args[0];
        run(fileName);
    }

    static void run(String fileName) {
        Configuration configuration = Configuration.getInstance();
        CommandInvoker commandInvoker = configuration.getCommandInvoker();

        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(fileName);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            String line;
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                line = sc.nextLine();
                commandInvoker.invokeCommand(line);
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
