package hxasjc.utilstuff.util;

/**
 * Provides a number of helper methods for working with enums
 */
public class EnumUtils {
    /**
     * Get the next enum item in the class. Enum items are ordered according to the order they were declared in
     * @param clazz The class of the enum you are working with. Ex: {@code ExampleEnum.class}
     * @param currentEnum The current enum item. Or the one before the one you want to get
     * @return The next enum in the class
     * @param <T> The type of enum you are working with. Ex: {@code ExampleEnum}
     */
    public static <T extends Enum<T>> T nextEnum(Class<T> clazz, T currentEnum) {
        T[] enumItems = clazz.getEnumConstants();
        int currentIndex = -1;

        for (int i = 0; i < enumItems.length; i++) {
            if (enumItems[i].equals(currentEnum)) {
                currentIndex = i;
            }
        }

        int nextIndex = currentIndex + 1;

        if (nextIndex >= enumItems.length) {
            nextIndex -= enumItems.length;
        }

        return enumItems[nextIndex];
    }
}
