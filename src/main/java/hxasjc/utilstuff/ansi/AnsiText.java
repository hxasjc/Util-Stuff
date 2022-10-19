package hxasjc.utilstuff.ansi;

/**
 * Stores text formatting ANSI escape sequences
 * @see ANSI
 */
public class AnsiText implements ANSI {

    /**
     * Makes text bold. Use {@link AnsiText#RESET_BOLD} to undo
     */
    public static final String BOLD = "\u001B[1m";
    /**
     * Reset {@link AnsiText#BOLD}
     */
    public static final String RESET_BOLD = "\u001B[22m";

    /**
     * Makes text dim/faint. Use {@link AnsiText#RESET_DIM} to undo
     */
    public static final String DIM = "\u001B[2m";
    /**
     * Reset {@link AnsiText#DIM}
     */
    public static final String RESET_DIM = "\u001B[22m";

    /**
     * Makes text italic. Use {@link AnsiText#RESET_ITALIC} to undo
     */
    public static final String ITALIC = "\u001B[3m";
    /**
     * Resets {@link AnsiText#ITALIC}
     */
    public static final String RESET_ITALIC = "\u001B[23m";

    /**
     * Underlines text. Use {@link AnsiText#RESET_UNDERLINE} to undo
     */
    public static final String UNDERLINE = "\u001B[4m";
    /**
     * Resets {@link AnsiText#UNDERLINE}
     */
    public static final String RESET_UNDERLINE = "\u001B[24m";

    /**
     * Unsure of exact purpose, could be broken. Use {@link AnsiText#RESET_BLINKING} to undo
     */
    public static final String BLINKING = "\u001B[5m";
    /**
     * Resets {{@link AnsiText#BLINKING}}
     */
    public static final String RESET_BLINKING = "\u001B[25m";

    /**
     * Swaps foreground and background colours. Use {@link AnsiText#RESET_INVERSE} to undo
     */
    public static final String INVERSE = "\u001B[7m";
    /**
     * Resets {@link AnsiText#INVERSE}
     */
    public static final String RESET_INVERSE = "\u001B[27m";

    /**
     * Unsure of purpose, could be broken. Use {@link AnsiText#RESET_HIDDEN} to undo
     */
    public static final String HIDDEN = "\u001B[8m";
    /**
     * Resets {@link AnsiText#HIDDEN}
     */
    public static final String RESET_HIDDEN = "\u001B[28m";

    /**
     * Strikes text through. Use {@link AnsiText#RESET_STRIKETHROUGH} to undo
     */
    public static final String STRIKETHROUGH = "\u001B[9m";
    /**
     * Resets {@link AnsiText#STRIKETHROUGH}
     */
    public static final String RESET_STRIKETHROUGH = "\u001B[29m";

    /**
     * Underlines text with double thickness. Use {@link AnsiText#RESET_DOUBLE_UNDERLINE} to undo
     */
    public static final String DOUBLE_UNDERLINE = "\u001B[21m";
    /**
     * Resets {@link AnsiText#DOUBLE_UNDERLINE}
     */
    public static final String RESET_DOUBLE_UNDERLINE = "\u001B[24m";
}
