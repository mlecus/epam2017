package s2galaktionov.gmail.com.sgalaktionov.testhomework3_1;

import org.junit.Test;
import s2galaktionov.gmail.com.sgalaktionov.homework3_1.Card;

import static org.junit.Assert.assertEquals;

/**
 * Created by mlecus on 29.09.2017.
 */
public class CardTestICardImplementatoinMethods {
    final static double PRECISION = 1e-12;
    final String correctName = "CorrectName";
    final double correctDoubleBalance = 0.5D;
    final float correctFloatBalance = 0.8F;
    final double correctDoubleAmount = 15.5D;
    final float correctFloatAmount = 20.8F;
    final double negativeDoubleAmount = -15.D;
    final float negativeFloatAmount = -15.F;
    final double correctDoubleRank = 0.5D;
    final float correctFloatRank = 2.55F;

    @Test
    public void testGetName() throws Exception {

        Card card = new Card(correctName);
        assertEquals(correctName, card.getName());
    }

    @Test
    public void tetsGetBalance() throws Exception {

        Card card = new Card(correctName, correctDoubleBalance);
        assertEquals(correctDoubleBalance, card.getBalance(), PRECISION);

        card = new Card(correctName, correctFloatBalance);
        assertEquals(correctFloatBalance, card.getBalance(), PRECISION);
    }

    @Test
    public void testIncreaseBalanceWithCorrectParameterValue() throws Exception {

        Card card = new Card(correctName, correctDoubleBalance);
        card.increaseBalance(correctDoubleAmount);
        assertEquals(correctDoubleBalance + correctDoubleAmount, card.getBalance(), PRECISION);
        card.increaseBalance(correctFloatAmount);
        assertEquals(correctDoubleBalance + correctDoubleAmount + correctFloatAmount, card.getBalance(), PRECISION);

        card = new Card(correctName, correctFloatBalance);
        card.increaseBalance(correctDoubleAmount);
        assertEquals(correctFloatBalance + correctDoubleAmount, card.getBalance(), PRECISION);
        card.increaseBalance(correctFloatAmount);
        assertEquals(correctFloatBalance + correctDoubleAmount + correctFloatAmount, card.getBalance(), PRECISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncreaseBalanceWithDoubleNegativeInfinity() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.increaseBalance(Double.NEGATIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncreaseBalanceWithDoublePositiveInfinity() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.increaseBalance(Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncreaseBalanceWithDoubleNaN() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.increaseBalance(Double.NaN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncreaseBalanceWithFloatNegativeParameterValue() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.increaseBalance(negativeFloatAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncreaseBalanceWithDoubleNegativeParameterValue() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.increaseBalance(negativeDoubleAmount);
    }

    @Test
    public void testIncreaseBalanceWithZeroParameterValue() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.increaseBalance(0);
        assertEquals(correctDoubleBalance, card.getBalance(), PRECISION);

        card = new Card(correctName, correctFloatBalance);
        card.increaseBalance(0);
        assertEquals(correctFloatBalance, card.getBalance(), PRECISION);
    }


    @Test
    public void testDecreaseBalanceWithCorrectParameterValue() throws Exception {

        Card card = new Card(correctName, correctDoubleBalance);
        card.decreaseBalance(correctDoubleAmount);
        assertEquals(correctDoubleBalance - correctDoubleAmount, card.getBalance(), PRECISION);
        card.decreaseBalance(correctFloatAmount);
        assertEquals(correctDoubleBalance - correctDoubleAmount - correctFloatAmount, card.getBalance(), PRECISION);

        card = new Card(correctName, correctFloatBalance);
        card.decreaseBalance(correctDoubleAmount);
        assertEquals(correctFloatBalance - correctDoubleAmount, card.getBalance(), PRECISION);
        card.decreaseBalance(correctFloatAmount);
        assertEquals(correctFloatBalance - correctDoubleAmount - correctFloatAmount, card.getBalance(), PRECISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseBalanceWithDoubleNegativeInfinity() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.decreaseBalance(Double.NEGATIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseBalanceWithDoublePositiveInfinity() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.decreaseBalance(Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseBalanceWithDoubleNaN() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.decreaseBalance(Double.NaN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseBalanceWithNegativeFloatParameterValue() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.decreaseBalance(negativeFloatAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseBalanceWithNegativeDoubleParameterValue() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.decreaseBalance(negativeDoubleAmount);
    }

    @Test
    public void testDecreaseBalanceWithZeroParameterValue() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.decreaseBalance(0);
        assertEquals(correctDoubleBalance, card.getBalance(), PRECISION);

        card = new Card(correctName, correctFloatBalance);
        card.decreaseBalance(0);
        assertEquals(correctFloatBalance, card.getBalance(), PRECISION);
    }

    @Test
    public void testConvertBalanceWithCorrectParameterValue() throws Exception {

        Card card = new Card(correctName, correctDoubleBalance);
        assertEquals(correctDoubleBalance * correctDoubleRank,
                card.convertBalance(correctDoubleRank), PRECISION);
        assertEquals(correctDoubleBalance * correctFloatRank,
                card.convertBalance(correctFloatRank), PRECISION);

        card = new Card(correctName, correctFloatBalance);
        assertEquals(correctFloatBalance * correctDoubleRank,
                card.convertBalance(correctDoubleRank), PRECISION);
        //XXX
        assertEquals(((double) correctFloatBalance) * correctFloatRank,
                card.convertBalance(correctFloatRank), PRECISION);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertBalanceWithDoubleNegativeInfinity() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.convertBalance(Double.NEGATIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertBalanceWithDoublePositiveInfinity() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.convertBalance(Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertBalanceWithDoubleNaN() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.convertBalance(Double.NaN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertBalanceWithNegativeFloatParameterValue() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.convertBalance(negativeFloatAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertBalanceWithNegativeDoubleParameterValue() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.convertBalance(negativeDoubleAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertBalanceWithZeroParameterValue() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        card.convertBalance(0);
    }

    @Test
    public void testToString() throws Exception {
        Card card = new Card(correctName, correctDoubleBalance);
        assertEquals("Name:\t" + correctName + "\n" + "Balance:\t" + correctDoubleBalance,
                card.toSring());
    }
}