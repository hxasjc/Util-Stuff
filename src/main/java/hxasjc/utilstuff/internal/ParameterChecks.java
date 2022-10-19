package hxasjc.utilstuff.internal;

/**
 * Utility class for checking the validity of passed arguments in methods
 */
public class ParameterChecks {
    /**
     * Checks if the given value is null
     * @param value Value to check
     * @throws NullPointerException Thrown if the passed value is null
     */
    public static void checkForNull(Object value) throws NullPointerException {
        if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
    }

    /**
     * Checks if the given value is in the given range
     * @param value Value to check
     * @param min Minimum of range (inclusive)
     * @param max Maximum of range (inclusive)
     * @throws IllegalArgumentException Thrown if value is outside the range
     */
    public static void checkForIntRange(int value, int min, int max) throws IllegalArgumentException {
        if (!(value >= min && value <= max)) {
            throw new IllegalArgumentException("Value must be between the range of " + min + " and " + max + " (got " + value + ")");
        }
    }
}
