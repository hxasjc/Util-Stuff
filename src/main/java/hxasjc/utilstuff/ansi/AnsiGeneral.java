package hxasjc.utilstuff.ansi;

import hxasjc.utilstuff.internal.NotImplementedException;

/**
 * Contains general ANSI escape sequences and methods
 * @see ANSI
 */
public class AnsiGeneral implements ANSI {
    /**
     * Reset all ANSI formatting.
     * For resetting specific tags, use {@link AnsiTextColours#DEFAULT_TEXT}, {@link AnsiTextColours#DEFAULT_BACKGROUND},
     * or the corresponding escape sequences in {@link AnsiText}.
     */
    public static final String RESET_FORMATTING = "\u001B[0m";

    /**
     * Will eventually build a custom ANSI escape sequence
     * @return null
     * @throws NotImplementedException This method is not yet implemented
     */
    public static String ansiTagBuilder() {
        throw new NotImplementedException();
    }
}
