package com.sgalaktionov.homework5;

import java.io.BufferedReader;
import java.io.Console;
import java.io.Reader;
import java.util.Scanner;

public class CommandLineUI {
    Scanner userInput = new Scanner(System.in);

    public String readInput(){
        return userInput.nextLine();
    }

    public void printMessage (String message){
        System.out.println(message);
    }
}
