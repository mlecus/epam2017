package s2galaktionov.gmail.com.sgalaktionov.homework3_2;

import java.util.Arrays;

/**
 * Created by mlecus on 28.09.2017.
 */
public class Median {

    public static float median(int[] inputSequence) throws IllegalArgumentException {

        if (inputSequence == null) {
            throw new IllegalArgumentException("inputSequence is null");
        }

        if (inputSequence.length == 0) {
            throw new IllegalArgumentException("inputSequence is empty");
        }

        Arrays.sort(inputSequence);

        if ((inputSequence.length % 2) == 1) {
            return inputSequence[inputSequence.length / 2];
        } else {
            return (inputSequence[inputSequence.length / 2 - 1] + inputSequence[inputSequence.length / 2]) / 2F;
        }
    }

    public static double median(double[] inputSequence) throws IllegalArgumentException {

        if (inputSequence == null) {
            throw new IllegalArgumentException("inputSequence is null");
        }

        if (inputSequence.length == 0) {
            throw new IllegalArgumentException("inputSequence is empty");
        }

        Arrays.sort(inputSequence);

        if ((inputSequence.length % 2) == 1) {
            return inputSequence[inputSequence.length / 2];
        } else {
            return ((inputSequence[inputSequence.length / 2 - 1] + inputSequence[inputSequence.length / 2]) / 2F);
        }
    }
}