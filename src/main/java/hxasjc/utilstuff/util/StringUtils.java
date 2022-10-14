package hxasjc.utilstuff.util;

import java.util.Random;

/**
 * Contains a variety of String utility methods
 */
public class StringUtils {
    /**
     * Removes all whitespace from the given string
     * @param str String to remove whitespace from
     * @return String, without any whitespace
     */
    public static String removeWhitespace(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Generate a random string according to the given pattern.
     * <br/>
     * Pattern construction:
     * <ul>
     *     <li>Any upper case letter -> A random upper case letter</li>
     *     <li>Any lower case letter -> A random lower case letter</li>
     *     <li>Any digit -> A random digit</li>
     *     <li>"?" -> A random character from the above options</li>
     *     <li>Anything else -> No change</li>
     * </ul>
     * @param pattern Pattern to use according to the above standard
     * @return The generated String
     */
    public static String generateKey(String pattern) {
        StringBuilder sb = new StringBuilder();

        for (char c : pattern.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append(CharacterMatcher.LOWER_CASE_LETTERS.getRandomCharacter());
            } else if (Character.isUpperCase(c)) {
                sb.append(CharacterMatcher.UPPER_CASE_LETTERS.getRandomCharacter());
            } else if (Character.isDigit(c)) {
                sb.append(CharacterMatcher.DIGITS.getRandomCharacter());
            } else if (c == '?') {
                switch (new Random().nextInt(3)) {
                    case 0 -> sb.append(CharacterMatcher.LOWER_CASE_LETTERS.getRandomCharacter());
                    case 1 -> sb.append(CharacterMatcher.UPPER_CASE_LETTERS.getRandomCharacter());
                    case 2 -> sb.append(CharacterMatcher.DIGITS.getRandomCharacter());
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
