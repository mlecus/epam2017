package s2galaktionov.gmail.com.sgalaktionov;

import org.junit.Test;
import s2galaktionov.gmail.com.sgalaktionov.Exceptions.CalculatorInvalidParametersValue;

import static org.junit.Assert.assertEquals;

/**
 * Created by mlecus on 26.09.2017.
 */
public class FactorialTest {
    @Test(expected = CalculatorInvalidParametersValue.class)
    public void testCalcWithNegativeNValue() throws Exception {
        new Factorial().calc(1, -5);
    }

    @Test
    public void testCalcWithNEqual0() throws Exception {
        assertEquals(1, new Factorial().calc(1, 0));
    }

    @Test
    public void testCalcWithNEqual1() throws Exception {
        assertEquals(1, new Factorial().calc(1, 1));
    }

    @Test
    public void testCalcWithNEqual10() throws Exception {
        assertEquals(3628800, new Factorial().calc(1, 10));
    }
}