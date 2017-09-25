package s2galaktionov.gmail.com.sgalaktionov;

import s2galaktionov.gmail.com.sgalaktionov.Exceptions.CalculatorInvalidParametersValue;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int algorithmID = 1;
        int loopType = 1;
        int n = 1;
        try {
            switch (algorithmID) {
                case 1:
                    ArrayList<Integer> fibonacci = new Fibonacci().calc(1, 1);
                    int i = 1;
                    for (Integer item : fibonacci) {
                        System.out.println("#" + i + "\t" + item);
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("");
                    System.exit(-1);
            }
        } catch (CalculatorInvalidParametersValue exc) {
            System.out.println("invalid value in parameter \'" + exc.getMessage() + "\'");
        }
    }
}
