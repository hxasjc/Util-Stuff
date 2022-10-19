package hxasjc.utilstuff.util;

import java.time.LocalTime;

/**
 * Provides some util methods for working with Date and Time objects
 */
public class DateTimeUtils {
    /**
     * Convert the given LocalTime into a more readable format
     * @param clockType 12 or 24-hour format
     * @param time Time to convert
     * @param showSeconds Whether to show seconds in the output
     * @return The time formatted in a more readable format
     */
    public static String getReadableTime(ClockType clockType, LocalTime time, boolean showSeconds) {
        return switch (clockType) {
            case TWELVE_HOUR -> getReadable12HourTime(time, showSeconds);
            case TWENTY_FOUR_HOUR -> getReadable24HourTime(time, showSeconds);
        };
    }

    /**
     * Converts the given time into a 12-hour format
     * @param time Time to convert
     * @param showSeconds Whether to show seconds in the output
     * @return The time formatted in a more readable format
     */
    private static String getReadable12HourTime(LocalTime time, boolean showSeconds) {
        boolean isPM = false;
        StringBuilder stringBuilder = new StringBuilder();

        if (time.getHour() > 12) {
            stringBuilder.append(StringUtils.padNumber(2, NumberUtils.intWrap(time.getHour(), 0, 12)));
            isPM = true;
        } else {
            stringBuilder.append(StringUtils.padNumber(2, time.getHour()));
        }
        stringBuilder.append(":");
        stringBuilder.append(StringUtils.padNumber(2, time.getMinute()));
        if (showSeconds) {
            stringBuilder.append(":");
            stringBuilder.append(StringUtils.padNumber(2, time.getSecond()));
        }
        if (isPM) {
            stringBuilder.append("pm");
        } else {
            stringBuilder.append("am");
        }
        return stringBuilder.toString();
    }

    /**
     * Converts the given time into a 12-hour format
     * @param time Time to convert
     * @param showSeconds Whether to show seconds in the output
     * @return The time formatted in a more readable format
     */
    private static String getReadable24HourTime(LocalTime time, boolean showSeconds) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringUtils.padNumber(2, time.getHour()));
        stringBuilder.append(":");
        stringBuilder.append(StringUtils.padNumber(2, time.getMinute()));
        if (showSeconds) {
            stringBuilder.append(":");
            stringBuilder.append(StringUtils.padNumber(2, time.getSecond()));
        }
        return stringBuilder.toString();
    }

    /**
     * Specifies whether to display times in a 12 or 24-hour format
     */
    public enum ClockType {
        /**
         * 12 hour
         */
        TWELVE_HOUR,
        /**
         * 24 hour
         */
        TWENTY_FOUR_HOUR
    }
}
