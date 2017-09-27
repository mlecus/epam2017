package s2galaktionov.gmail.com.sgalaktionov;

import org.junit.Test;
import s2galaktionov.gmail.com.sgalaktionov.Exceptions.CalculatorInvalidParametersValue;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by mlecus on 25.09.2017.
 */
public class FibonacciTest {
    ArrayList<Integer> expected;
    ArrayList<Integer> actual;

    @Test(expected = CalculatorInvalidParametersValue.class)
    public void testCalcWithNegativeNValue() throws Exception {
        new Fibonacci().calc(1, -5);
    }

    @Test(expected = CalculatorInvalidParametersValue.class)
    public void testCalcWithNEqual0() throws Exception {
        new Fibonacci().calc(1, 0);
    }

    @Test
    public void testCalcWithNEqual1() throws Exception {
        expected = new ArrayList<Integer>(1);
        expected.add(1);
        actual = new Fibonacci().calc(1, 1);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testCalcWithNEqual2() throws Exception {
        expected = new ArrayList<Integer>(1);
        expected.add(1);
        expected.add(1);
        actual = new Fibonacci().calc(1, 2);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testCalcWithNEqual3() throws Exception {
        expected = new ArrayList<Integer>(1);
        expected.add(1);
        expected.add(1);
        expected.add(2);
        actual = new Fibonacci().calc(1, 3);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testCalcWithNEqual10() throws Exception {
        int n = 10;
        expected = new ArrayList<Integer>(n);
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(5);
        expected.add(8);
        expected.add(13);
        expected.add(21);
        expected.add(34);
        expected.add(55);
        actual = new Fibonacci().calc(1, n);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(i, expected.get(i), actual.get(i));
        }
    }
}