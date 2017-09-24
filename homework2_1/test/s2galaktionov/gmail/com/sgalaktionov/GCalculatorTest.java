package s2galaktionov.gmail.com.sgalaktionov;

import org.junit.Before;
import org.junit.Test;
import s2galaktionov.gmail.com.sgalaktionov.Exceptions.GCalculatorNotAlowedParameterZeroValue;

import static org.junit.Assert.assertEquals;

//import junit.framework.TestCase;

/**
 * Created by mlecus on 24.09.2017.
 */
public class GCalculatorTest {
    GCalculator gCalculator;

    @Before
    public void setupTestCalcG() {
        gCalculator = new GCalculator();
    }

    @Test
    public void testCalcGWithCorrectParams() throws Exception {
        assertEquals(-8.851663139990455, gCalculator.calculeteG(5, 5, 10.2, -32.5), 1e-12);
    }

    @Test(expected = GCalculatorNotAlowedParameterZeroValue.class)
    public void testCalcWithZeroInP() throws Exception {
        gCalculator.calculeteG(5, 0, 10.2, -32.5);
    }

    @Test(expected = GCalculatorNotAlowedParameterZeroValue.class)
    public void testCalcWithZeroInSummM1M2() throws Exception {
        gCalculator.calculeteG(5, 10, 32.5, -32.5);
    }
}