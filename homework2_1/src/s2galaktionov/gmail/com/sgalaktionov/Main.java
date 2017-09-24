package s2galaktionov.gmail.com.sgalaktionov;

import s2galaktionov.gmail.com.sgalaktionov.Exceptions.GCalculatorNotAlowedParameterZeroValue;

public class Main {

    public static void main(String[] args) {

        if (args.length != 4) {
            System.out.println("incorrect parameters amount.\n" +
                    "you should to give 4 space divided parameters int a int p double m1 double m2");
            //return;
            System.exit(-1);
        }
        //if (Integer.parseInt())
        int a = 0;
        int p = 0;
        double m1 = 0;
        double m2 = 0;
        String incorrectPrameterName = "";
        try {
            incorrectPrameterName = "a";
            a = Integer.parseInt(args[0]);
            incorrectPrameterName = "p";
            p = Integer.parseInt(args[1]);
            incorrectPrameterName = "m1";
            m1 = Double.parseDouble(args[2]);
            incorrectPrameterName = "m2";
            m2 = Double.parseDouble(args[3]);

            try {
                System.out.println(new GCalculator().calculeteG(a, p, m1, m2));
            } catch (GCalculatorNotAlowedParameterZeroValue exc) {
                System.out.println(exc.getMessage() + " must not be equal zero");
            }

        } catch (NumberFormatException exc) {
            System.out.println("parameter " + incorrectPrameterName + " contains illegal symbols");
        }


    }
}
