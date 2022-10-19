package hxasjc.utilstuff.util;

import java.text.DecimalFormat;

/**
 * Provides a number of helper methods for working with numbers. Most of the methods in this class will accept any class that extends the {@link Number} class.
 * <br/>
 * The following primitives can be used in these methods: int, double, float, short, long, byte
 * @see Number
 */
public class NumberUtils {
    /**
     * Format for formatting prices
     */
    public static final DecimalFormat MONEY_FORMAT = new DecimalFormat("$#0.00");

    /**
     * Wraps the given number around the given range. This method uses integers to calculate the result.
     * @param numObj The number that you want to wrap
     * @param minRange The lower end of the range to wrap around
     * @param maxRange The upper end of the range to wrap around
     * @return The wrapped integer
     * @param <T> Any class that extends {@link Number}
     * @see NumberUtils#doubleWrap(Number, double, double)
     * @throws NumberUtilsException if the minRange is larger than the maxRange
     */
    public static <T extends Number> int intWrap(T numObj, int minRange, int maxRange) {
        if (minRange > maxRange) {
            throw new NumberUtilsException("minRange (got: " + minRange + ") must be smaller than maxRange (got: " + maxRange + ")");
        }

        int numValue = numObj.intValue();

        int rangeSize = maxRange - minRange;

        while (numValue < rangeSize) {
            numValue += rangeSize;
        }

        return (numValue % rangeSize) + minRange;
    }

    /**
     * Wraps the given number around the given range. This method uses doubles to calculate the result.
     * @param numObj The number that you want to wrap
     * @param minRange The lower end of the range to wrap around
     * @param maxRange The upper end of the range to wrap around
     * @return The wrapped double
     * @param <T> Any class that extends {@link Number}
     * @see NumberUtils#intWrap(Number, int, int)
     * @throws NumberUtilsException if the minRange is larger than the maxRange
     */
    public static <T extends Number> double doubleWrap(T numObj, double minRange, double maxRange) {
        if (minRange > maxRange) {
            throw new NumberUtilsException("minRange (got: " + minRange + ") must be smaller than maxRange (got: " + maxRange + ")");
        }

        double numValue = numObj.doubleValue();

        double rangeSize = maxRange - minRange;

        while (numValue < rangeSize) {
            numValue += rangeSize;
        }

        return (numValue % rangeSize) + minRange;
    }

    /**
     * RuntimeException thrown by various methods in {@link NumberUtils}
     */
    public static class NumberUtilsException extends RuntimeException {
        /**
         * Creates a new NumberUtilsException with the given message
         * @param str Message
         */
        public NumberUtilsException(String str) {
            super(str);
        }
    }
}
