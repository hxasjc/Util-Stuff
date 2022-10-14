package hxasjc.utilstuff.util;

import java.util.List;

/**
 * Provides a number of helper methods for working with lists
 * @see List
 */
public class ListUtils {
    /**
     * Removes all null elements from the given list
     * @param list List to remove null elements from
     * @param <T> Type of object contained in the list
     */
    public static <T> void removeNullElements(List<T> list) {
        list.removeIf((item) -> (item == null));
    }
}
