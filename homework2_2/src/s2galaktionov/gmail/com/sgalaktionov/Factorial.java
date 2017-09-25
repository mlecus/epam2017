package s2galaktionov.gmail.com.sgalaktionov;

import s2galaktionov.gmail.com.sgalaktionov.Exceptions.CalculatorInvalidParametersValue;

/**
 * Created by mlecus on 25.09.2017.
 */
public class Factorial {
    int n;
    int result=1;
    //public Factorial(int loopType, int n){
    public Factorial() {

    }

    private int factorialInWhileCalc() throws CalculatorInvalidParametersValue {
        System.out.println("factorial in while");
        //if (n == 0) return 0;
        //if (n < 0) throw new CalculatorInvalidParametersValue("n");
        while (n>0) {
            result*=n;
            n--;
        }
        return result;
    }

    private int factorialInDoWhileCalc() {
        System.out.println("factorial in do-while");
        do{
            result *=n;
            n--;
        }while (n>0);
        return result;
    }

    //private int factorialInForCalc() {
    private int factorialInForCalc() {
        System.out.println("factorial in for");
        for (int i=n;i>1;i--) {
            result*=i;
        }
        return result;
    }

    public int calc(int loopType, int n) throws CalculatorInvalidParametersValue {
        if (n == 0) return 1;
        if (n < 0) throw new CalculatorInvalidParametersValue("n");
        this.n=n;
        result=1;
        switch (loopType) {
            case 1:
                return factorialInWhileCalc();
            //break;
            case 2:
                return factorialInDoWhileCalc();
            //break;
            case 3:
                return factorialInForCalc();
            //break;
            default:
                throw new CalculatorInvalidParametersValue("loopType");
        }
    }
}
