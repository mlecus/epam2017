package s2galaktionov.gmail.com.sgalaktionov;

import s2galaktionov.gmail.com.sgalaktionov.Exceptions.CalculatorInvalidParametersValue;

import java.util.ArrayList;

/**
 * Created by mlecus on 25.09.2017.
 */
public class Fibonacci {
    private int n;
    private ArrayList<Integer> result;

    private void fibonacciInWhileCalc() {
        //System.out.println("fibonacci in while");
        int n = this.n;
        while (n > 2) {
            result.add(result.get(result.size() - 1) + result.get(result.size() - 2));
            n--;
        }
    }

    private void fibonacciInDoWhileCalc() {
        //System.out.println("fibonacci in do-while");
        int n = this.n;
        do {
            result.add(result.get(result.size() - 1) + result.get(result.size() - 2));
            n--;
        } while (n > 2);
    }

    private void fibonacciInForCalc() {
        //System.out.println("fibonacci in for");
        int n = this.n;
        for (int i = 2; i < n; i++) {
            result.add(result.get(result.size() - 1) + result.get(result.size() - 2));
        }
    }

    public ArrayList<Integer> calc(int loopType, int n)
            throws CalculatorInvalidParametersValue {
        if (n <= 0) {
            throw new CalculatorInvalidParametersValue("n");
        }
        result=new ArrayList<Integer>();
        switch (n) {
            case 2:
                result.add(1);
            case 1:
                result.add(1);
                break;
            default:
                this.n=n;
                result.add(1);
                result.add(1);
                switch (loopType) {
                    case 1:
                        fibonacciInWhileCalc();
                        break;
                    case 2:
                        fibonacciInDoWhileCalc();
                        break;
                    case 3:
                        fibonacciInForCalc();
                        break;
                    default:
                        throw new CalculatorInvalidParametersValue("loopType");
                }
        }
        return result;
    }
}
