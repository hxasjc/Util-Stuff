package hxasjc.utilstuff.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

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
        list.removeIf(Objects::isNull);
    }

    /**
     * Remove duplicate elements in a list
     * @param list List to remove elements from
     * @return An ArrayList that contains no duplicate elements
     * @param <T> Type of object in the list
     */
    public static <T> List<T> removeDuplicateElements(List<T> list) {
        /*ArrayList<T> uniqueElements = new ArrayList<>();
        for (T obj : list) {
            if (uniqueElements.contains(obj)) {
                list.remove(obj);
            } else {
                uniqueElements.add(obj);
            }
        }*/

        //HashSet<T> set = new HashSet<>(list);
        return new ArrayList<>(new HashSet<>(list));
    }
}
