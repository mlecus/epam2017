package s2galaktionov.gmail.com.sgalaktionov;

import s2galaktionov.gmail.com.sgalaktionov.Exceptions.CalculatorInvalidParametersValue;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int algorithmID = 1;
        int loopType = 1;
        int n = 1;
        if (args.length != 3) {
            System.out.println("incorrect parameters amount.\n" +
                    "you should give 3 space divided parameters int algorithmID int loopType int n");
            System.exit(-1);
        }
        String incorrectPrameterName = "";
        try {
            incorrectPrameterName = "\'algorithmID\'";
            algorithmID = Integer.parseInt(args[0]);
            incorrectPrameterName = "\'loopType\'";
            loopType = Integer.parseInt(args[1]);
            incorrectPrameterName = "\'n\'";
            n = Integer.parseInt(args[2]);

            try {
                switch (algorithmID) {
                    case 1:
                        ArrayList<Integer> fibonacci = new Fibonacci().calc(loopType, n);
                        int i = 1;
                        for (Integer item : fibonacci) {
                            System.out.print(item + " ");
                        }
                        System.out.println("");
                        break;
                    case 2:
                        long factorial = new Factorial().calc(loopType, n);
                        System.out.println(factorial);
                        break;
                    default:
                        System.out.println("invalid value in parameter \'algorithmID\'");
                        System.exit(-1);
                }
            } catch (CalculatorInvalidParametersValue exc) {
                System.out.println("invalid value in parameter \'" + exc.getMessage() + "\'");
            }
        } catch (NumberFormatException exc) {
            System.out.println("parameter " + incorrectPrameterName + " contains illegal symbols");
        }
    }
}
