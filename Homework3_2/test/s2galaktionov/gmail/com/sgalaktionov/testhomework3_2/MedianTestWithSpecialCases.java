package s2galaktionov.gmail.com.sgalaktionov.testhomework3_2;

import org.junit.Assert;
import org.junit.Test;
import s2galaktionov.gmail.com.sgalaktionov.homework3_2.Median;

/**
 * Created by mlecus on 28.09.2017.
 */
public class MedianTestWithSpecialCases {

    @Test(expected = IllegalArgumentException.class)
    public void testIntMedianWithNullInputSequence() {
        Median.median((int[]) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntMedianWithEmptyInputSequence() {
        int[] inputSequence = {};
        Median.median(inputSequence);
    }

    @Test
    public void testIntMedianWithOnlyOneSequenceMember() {
        float result = Median.median(new int[]{5});
        Assert.assertEquals(5, result, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoubleMedianWithNullInputSequence() {
        Median.median((double[]) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoubleMedianWithEmptyInputSequence() {
        double[] inputSequence = {};
        Median.median(inputSequence);
    }

    @Test
    public void testDoubleMedianWithOnlyOneSequenceMember() {
        double result = Median.median(new double[]{5F});
        Assert.assertEquals(5D, result, 0);
    }

    @Test
    public void testDoubleMedianEvenWithInfSequenceMember() {
        double result = Median.median(new double[]{4, -1. / 0, 5, 1. / 0});
        Assert.assertEquals(4.5D, result, 0);
    }

    @Test
    public void testDoubleMedianOddWithInfSequenceMember() {
        double result = Median.median(new double[]{4, -1. / 0, 5, 7, 1. / 0});
        Assert.assertEquals(5D, result, 0);
    }
}
