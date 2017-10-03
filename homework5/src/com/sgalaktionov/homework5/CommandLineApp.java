package com.sgalaktionov.homework5;

import com.sgalaktionov.homework5.CommandLineUI;
import com.sgalaktionov.homework5.Exceptions.FSFileAllreadyExistException;
import com.sgalaktionov.homework5.FileSystem;

public class CommandLineApp {
    public  void launch(){
        CommandLineUI ui = new CommandLineUI();
        FileSystem fs = new FileSystem("//");
        do{
            System.out.print("$>");
            String userInput = ui.readInput();
            if (userInput.compareToIgnoreCase("exit") == 0){
                return;
            }else if (userInput.compareToIgnoreCase("print") == 0){
                ui.printMessage(fs.toString());
            }else {
                try {
                    fs.fileSystemAddInstance(userInput);
                }catch (FSFileAllreadyExistException e){
                    ui.printMessage(e.getMessage());
                }
            }
        } while(true);
    }
}
