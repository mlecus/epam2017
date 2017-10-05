package com.sgalaktionov.homework5;

import com.sgalaktionov.homework5.Exceptions.FSFileAllreadyExistException;
import com.sgalaktionov.homework5.Exceptions.FSInvalidSymbolExtension;

public class CommandLineApp {
    final private String helpMessage = "type \"help\" or \"?\" to help\n"
            + "type \"print\" to print file structure\n"
            + "type \"exit\" to exit\n";


    public void launch() {
        CommandLineUI ui = new CommandLineUI();
        FileSystem fs = new FileSystem("root/");
        do {
            System.out.print("$>");
            String userInput = ui.readInput();
            if (userInput.equals("")
                    || (userInput.compareToIgnoreCase("?") == 0)
                    || (userInput.compareToIgnoreCase("help") == 0)) {
                ui.printMessage(helpMessage);
            } else if (userInput.compareToIgnoreCase("exit") == 0) {
                return;
            } else if (userInput.compareToIgnoreCase("print") == 0) {
                ui.printMessage(fs.toString());
            } else {
                try {
                    fs.fileSystemAddInstance(userInput);
                } catch (FSFileAllreadyExistException e) {
                    ui.printMessage(e.getMessage());
                } catch (FSInvalidSymbolExtension e) {
                    ui.printMessage(e.getMessage());
                }
            }
        } while (true);
    }
}
