package com.sgalaktionov.homework5;

import java.util.Scanner;

public class CommandLineUI {
    private Scanner userInput = new Scanner(System.in);

    public String readInput() {
        return userInput.nextLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
