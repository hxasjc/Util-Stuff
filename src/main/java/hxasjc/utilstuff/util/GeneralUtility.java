package hxasjc.utilstuff.util;

import hxasjc.utilstuff.data.Concat;

/**
 * Provides easy of use methods, including better printing methods. Designed to be extended by the class you are using.
 */
public class GeneralUtility {
    /**
     * Concat object used for concatenating objects in preparation for printing
     */
    public static final Concat PRINT_CONCAT = new Concat.ConcatBuilder()
            .separator(" ")
            .skipNulls()
            .build();

    /**
     * Prints the given objects using {@code System.out.print()}.
     * @param objects Any number of objects to print
     */
    public static void print(Object... objects) {
        System.out.print(PRINT_CONCAT.concat(objects));
    }

    /**
     * Prints the given objects using {@code System.out.print()} and the given Concat object.
     * @param concat Concat object to concatenate with
     * @param objects Any number of objects to print
     */
    public static void print(Concat concat, Object... objects) {
        System.out.println(concat.concat(objects));
    }

    /**
     * Prints the given objects using {@code System.out.println()}.
     * @param objects Any number of objects to print
     */
    public static void println(Object... objects) {
        System.out.println(PRINT_CONCAT.concat(objects));
    }

    /**
     * Prints the given objects using {@code System.out.println()} and the given Concat object.
     * @param concat Concat object to concatenate with
     * @param objects Any number of objects to print
     */
    public static void println(Concat concat, Object... objects) {
        System.out.println(concat.concat(objects));
    }
}
