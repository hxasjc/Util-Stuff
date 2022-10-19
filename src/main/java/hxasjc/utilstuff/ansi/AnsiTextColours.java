package hxasjc.utilstuff.ansi;

import hxasjc.utilstuff.data.Concat;
import hxasjc.utilstuff.internal.ParameterChecks;

/**
 * Contains the escape sequences and methods for ANSI text colours
 */
public class AnsiTextColours implements ANSI {
    /**
     * Black text/foreground
     */
    public static final String BLACK_TEXT = getBasicColour(BaseColour.BLACK, ColourMode.FOREGROUND, false);
    /**
     * Red text/foreground
     */
    public static final String RED_TEXT = getBasicColour(BaseColour.RED, ColourMode.FOREGROUND, false);
    /**
     * Green text/foreground
     */
    public static final String GREEN_TEXT = getBasicColour(BaseColour.GREEN, ColourMode.FOREGROUND, false);
    /**
     * Yellow text/foreground
     */
    public static final String YELLOW_TEXT = getBasicColour(BaseColour.YELLOW, ColourMode.FOREGROUND, false);
    /**
     * Blue text/foreground
     */
    public static final String BLUE_TEXT = getBasicColour(BaseColour.BLUE, ColourMode.FOREGROUND, false);
    /**
     * Purple text/foreground
     */
    public static final String PURPLE_TEXT = getBasicColour(BaseColour.PURPLE, ColourMode.FOREGROUND, false);
    /**
     * Cyan text/foreground
     */
    public static final String CYAN_TEXT = getBasicColour(BaseColour.CYAN, ColourMode.FOREGROUND, false);
    /**
     * White text/foreground
     */
    public static final String WHITE_TEXT = getBasicColour(BaseColour.WHITE, ColourMode.FOREGROUND, false);

    /**
     * Bright black text/foreground
     */
    public static final String BRIGHT_BLACK_TEXT = getBasicColour(BaseColour.BLACK, ColourMode.FOREGROUND, true);
    /**
     * Bright red text/foreground
     */
    public static final String BRIGHT_RED_TEXT = getBasicColour(BaseColour.RED, ColourMode.FOREGROUND, true);
    /**
     * Bright green text/foreground
     */
    public static final String BRIGHT_GREEN_TEXT = getBasicColour(BaseColour.GREEN, ColourMode.FOREGROUND, true);
    /**
     * Bright yellow text/foreground
     */
    public static final String BRIGHT_YELLOW_TEXT = getBasicColour(BaseColour.YELLOW, ColourMode.FOREGROUND, true);
    /**
     * Bright blue text/foreground
     */
    public static final String BRIGHT_BLUE_TEXT = getBasicColour(BaseColour.BLUE, ColourMode.FOREGROUND, true);
    /**
     * Bright purple text/foreground
     */
    public static final String BRIGHT_PURPLE_TEXT = getBasicColour(BaseColour.PURPLE, ColourMode.FOREGROUND, true);
    /**
     * Bright cyan text/foreground
     */
    public static final String BRIGHT_CYAN_TEXT = getBasicColour(BaseColour.CYAN, ColourMode.FOREGROUND, true);
    /**
     * Bright white text/foreground
     */
    public static final String BRIGHT_WHITE_TEXT = getBasicColour(BaseColour.WHITE, ColourMode.FOREGROUND, true);

    /**
     * Default text/foreground colour
     */
    public static final String DEFAULT_TEXT = getBasicColour(BaseColour.DEFAULT, ColourMode.FOREGROUND, false);

    /**
     * Black background/highlight
     */
    public static final String BLACK_BACKGROUND = getBasicColour(BaseColour.BLACK, ColourMode.BACKGROUND, false);
    /**
     * Red background/highlight
     */
    public static final String RED_BACKGROUND = getBasicColour(BaseColour.RED, ColourMode.BACKGROUND, false);
    /**
     * Green background/highlight
     */
    public static final String GREEN_BACKGROUND = getBasicColour(BaseColour.GREEN, ColourMode.BACKGROUND, false);
    /**
     * Yellow background/highlight
     */
    public static final String YELLOW_BACKGROUND = getBasicColour(BaseColour.YELLOW, ColourMode.BACKGROUND, false);
    /**
     * Blue background/highlight
     */
    public static final String BLUE_BACKGROUND = getBasicColour(BaseColour.BLUE, ColourMode.BACKGROUND, false);
    /**
     * Purple background/highlight
     */
    public static final String PURPLE_BACKGROUND = getBasicColour(BaseColour.PURPLE, ColourMode.BACKGROUND, false);
    /**
     * Cyan background/highlight
     */
    public static final String CYAN_BACKGROUND = getBasicColour(BaseColour.CYAN, ColourMode.BACKGROUND, false);
    /**
     * White background/highlight
     */
    public static final String WHITE_BACKGROUND = getBasicColour(BaseColour.WHITE, ColourMode.BACKGROUND, false);

    /**
     * Bright black background/highlight
     */
    public static final String BRIGHT_BLACK_BACKGROUND = getBasicColour(BaseColour.BLACK, ColourMode.BACKGROUND, true);
    /**
     * Bright red background/highlight
     */
    public static final String BRIGHT_RED_BACKGROUND = getBasicColour(BaseColour.RED, ColourMode.BACKGROUND, true);
    /**
     * Bright green background/highlight
     */
    public static final String BRIGHT_GREEN_BACKGROUND = getBasicColour(BaseColour.GREEN, ColourMode.BACKGROUND, true);
    /**
     * Bright yellow background/highlight
     */
    public static final String BRIGHT_YELLOW_BACKGROUND = getBasicColour(BaseColour.YELLOW, ColourMode.BACKGROUND, true);
    /**
     * Bright blue background/highlight
     */
    public static final String BRIGHT_BLUE_BACKGROUND = getBasicColour(BaseColour.BLUE, ColourMode.BACKGROUND, true);
    /**
     * Bright purple background/highlight
     */
    public static final String BRIGHT_PURPLE_BACKGROUND = getBasicColour(BaseColour.PURPLE, ColourMode.BACKGROUND, true);
    /**
     * Bright cyan background/highlight
     */
    public static final String BRIGHT_CYAN_BACKGROUND = getBasicColour(BaseColour.CYAN, ColourMode.BACKGROUND, true);
    /**
     * Bright white background/highlight
     */
    public static final String BRIGHT_WHITE_BACKGROUND = getBasicColour(BaseColour.WHITE, ColourMode.BACKGROUND, true);

    /**
     * Default background/highlight colour
     */
    public static final String DEFAULT_BACKGROUND = getBasicColour(BaseColour.DEFAULT, ColourMode.BACKGROUND, false);

    /**
     * Get a colour from the set of 256. {@link AnsiTextColours#print256ColourTable()} prints out a table of these colours
     * @param id The colour id
     * @param mode Foreground/text or background/highlight
     * @return An ANSI escape sequence representing the colour
     */
    public static String get256Colour(int id, ColourMode mode) {
        ParameterChecks.checkForIntRange(id, 0, 255);
        ParameterChecks.checkForNull(mode);
        int modeNum = switch (mode) {
            case FOREGROUND -> 38;
            case BACKGROUND -> 48;
        };
        return Concat.NO_SEPARATOR.concat("\u001B[", modeNum, ";5;", id, "m");
    }

    /**
     * Get an RGB colour
     * @param r The red amount
     * @param g The green amount
     * @param b The blue amount
     * @param mode Foreground/text or background/highlight
     * @return An ANSI escape sequence representing the colour
     */
    public static String getRgbColour(int r, int g, int b, ColourMode mode) {
        ParameterChecks.checkForIntRange(r, 0, 255);
        ParameterChecks.checkForIntRange(g, 0, 255);
        ParameterChecks.checkForIntRange(b, 0, 255);
        ParameterChecks.checkForNull(mode);

        int modeNum = switch (mode) {
            case FOREGROUND -> 38;
            case BACKGROUND -> 48;
        };
        return Concat.NO_SEPARATOR.concat("\u001B[", modeNum, ";2;", r, ";", b, ";", g, "m");
    }

    /**
     * Get one of the basic colours. Used to generate the constant colours
     * @param colour Name of the colour
     * @param mode Foreground/text or background/highlight
     * @param bright Whether to create a bright colour or normal
     * @return An ANSI escape sequence representing the colour
     */
    public static String getBasicColour(BaseColour colour, ColourMode mode, boolean bright) {
        ParameterChecks.checkForNull(colour);
        ParameterChecks.checkForNull(mode);

        int id = colour.ordinal() + 30;
        if (mode == ColourMode.BACKGROUND) {
            id += 10;
        }
        if (bright) {
            id += 60;
        }

        return Concat.NO_SEPARATOR.concat("\u001B[", id, "m");
    }

    /**
     * Prints out the set of 256 colours
     */
    public static void print256ColourTable() {
        int colourId = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                System.out.print(get256Colour(colourId, ColourMode.FOREGROUND) + colourId + "\t");
                colourId++;
            }
            System.out.print("\n");
        }
        System.out.print(DEFAULT_TEXT);
    }

    /**
     * Used for setting foreground or background for the methods in this class
     */
    public enum ColourMode {
        /**
         * Text
         */
        FOREGROUND,
        /**
         * Highlight
         */
        BACKGROUND
    }

    /**
     * The 8 basic colours
     */
    public enum BaseColour {
        /**
         * Black
         */
        BLACK,
        /**
         * Red
         */
        RED,
        /**
         * Green
         */
        GREEN,
        /**
         * Yellow
         */
        YELLOW,
        /**
         * Blue
         */
        BLUE,
        /**
         * Purple
         */
        PURPLE,
        /**
         * Cyan
         */
        CYAN,
        /**
         * White
         */
        WHITE,
        /**
         * Default
         */
        DEFAULT
    }
}
