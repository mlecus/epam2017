package s2galaktionov.gmail.com.sgalaktionov;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.*;

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
        assertEquals(-8.851663139990455, gCalculator.calculeteG(5, 5, 10.2, -32.5),1e-12);
    }
    @Test
    public void testCalcWithZeroInDiveder() throws Exception{

    }
}