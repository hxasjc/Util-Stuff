package hxasjc.utilstuff.util;

import hxasjc.utilstuff.data.Concat;

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

    /**
     * Aligns test to the right along the given width, allowing for pre-existing text
     * @param preExistingText String to ignore, this is not aligned
     * @param textToAlign String to align
     * @param totalWidth Total width to align across, must include the lengths of both strings passed in
     * @return Aligned text
     */
    public static String rightAlignText(String preExistingText, String textToAlign, int totalWidth) {
        /*int spacing = totalWidth - preExistingText.length() - textToAlign.length();
        if (spacing < 0) {
            throw new RuntimeException("Not enough space to align: " + spacing);
        }*/
        int i = totalWidth - preExistingText.length();
        //GeneralUtility.println(i);
        int spacing = i - textToAlign.length();
        if (spacing < 0) {
            //GeneralUtility.println(totalWidth, preExistingText, preExistingText.length(), textToAlign, textToAlign.length());
            //throw new RuntimeException("Not enough space to align: " + spacing);
            throw new RuntimeException(new Concat.ConcatBuilder().separator(", ").replaceNullsWith("null").build().concat(
                    "Not enough space to align:",
                    i,
                    spacing,
                    totalWidth,
                    preExistingText,
                    preExistingText.length(),
                    //"hi",
                    textToAlign,
                    textToAlign.length()
            ));
        }
        return Concat.NO_SEPARATOR.concat(preExistingText, " ".repeat(spacing), textToAlign);
    }

    /**
     * Center text along th given width
     * @param text Text to center
     * @param width Width to center text in
     * @return Centered text
     */
    public static String centerText(String text, int width) {
        if (text.length() > width) {
            throw new RuntimeException("Not enough space to align");
        }
        int spacing = (width - text.length()) / 2;
        return Concat.NO_SEPARATOR.concat(" ".repeat(spacing), text);
    }

    /**
     * Turns a string to title case
     * @param str String to transform
     * @return Transformed string
     */
    public static String toTitleCase(String str) {
        boolean isCapitalLetter = true;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isCapitalLetter) {
                chars[i] = Character.toUpperCase(chars[i]);
                isCapitalLetter = false;
            } else if (Character.isWhitespace(chars[i])) {
                isCapitalLetter = true;
            } else {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        return new String(chars);
    }

    /**
     * Pad a number with the given number of 0s
     * @param padding Number to pad
     * @param number Minimum number of digits to have, will pad to get to this number
     * @return Padded number
     */
    public static String padNumber(int padding, int number) {
        return String.format("%0" + padding + "d", number);
    }
}
