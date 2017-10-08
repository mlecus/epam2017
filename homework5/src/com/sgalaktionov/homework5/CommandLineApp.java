package com.sgalaktionov.homework5;

import com.sgalaktionov.homework5.Exceptions.FSFileAlreadyExistException;
import com.sgalaktionov.homework5.Exceptions.FSInvalidSymbolException;

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
                ui.printMessage(fs.print());
            } else {
                try {
                    fs.fileSystemAddInstance(userInput);
                } catch (FSFileAlreadyExistException e) {
                    ui.printMessage(e.getMessage());
                } catch (FSInvalidSymbolException e) {
                    ui.printMessage(e.getMessage());
                }
            }
        } while (true);
    }
}
