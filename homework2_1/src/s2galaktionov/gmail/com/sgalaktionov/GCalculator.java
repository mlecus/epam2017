package s2galaktionov.gmail.com.sgalaktionov;


import s2galaktionov.gmail.com.sgalaktionov.Exceptions.GCalculatorNotAlowedParameterZeroValue;

/**
 * Created by mlecus on 24.09.2017.
 */
public class GCalculator {
    public GCalculator() {
    }

    public double calculeteG(int a, int p, double m1, double m2) throws GCalculatorNotAlowedParameterZeroValue {
        if (p == 0) {
            throw new GCalculatorNotAlowedParameterZeroValue("\'p\'");
        }
        if (Math.abs(m1 + m2) < 1e-12) {
            throw new GCalculatorNotAlowedParameterZeroValue("\'m1\'+\'m2\'");
        }
        double G = 4 * Math.pow(Math.PI, 2) * Math.pow(a, 3)
                / (Math.pow(p, 2) * (m1 + m2));
        return G;
    }
}
