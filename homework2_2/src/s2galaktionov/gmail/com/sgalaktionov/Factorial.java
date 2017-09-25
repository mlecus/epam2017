package s2galaktionov.gmail.com.sgalaktionov;

import s2galaktionov.gmail.com.sgalaktionov.Exceptions.CalculatorInvalidParametersValue;

/**
 * Created by mlecus on 25.09.2017.
 */
public class Factorial {
    int n;
    int result = 1;

    //public Factorial(int loopType, int n){
    public Factorial() {

    }

    private long factorialInWhileCalc() throws CalculatorInvalidParametersValue {
        //System.out.println("factorial in while");
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }

    private long factorialInDoWhileCalc() {
        //System.out.println("factorial in do-while");
        do {
            result *= n;
            n--;
        } while (n > 0);
        return result;
    }

    private long factorialInForCalc() {
        //System.out.println("factorial in for");
        for (int i = n; i > 1; i--) {
            result *= i;
        }
        return result;
    }

    public long calc(int loopType, int n) throws CalculatorInvalidParametersValue {
        if (n == 0) return 1;
        if (n < 0) throw new CalculatorInvalidParametersValue("n");
        this.n = n;
        result = 1;
        switch (loopType) {
            case 1:
                return factorialInWhileCalc();

            case 2:
                return factorialInDoWhileCalc();

            case 3:
                return factorialInForCalc();

            default:
                throw new CalculatorInvalidParametersValue("loopType");
        }
    }
}
