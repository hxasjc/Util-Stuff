package hxasjc.utilstuff.data;

import java.util.HashMap;

/**
 * HashMap wrapper used for counting items.
 * @param <K>
 */
public class HashMapCounter<K> {
    /**
     * internal map
     */
    private final HashMap<K, Integer> map = new HashMap<>();

    /**
     * Default value, used to prevent NullPointerExceptions; default value is 0, can be set using constructor
     */
    private int defaultValue = 0;

    /**
     * Create new HashMapCounter with no additional parameters
     */
    public HashMapCounter() {
        //
    }

    /**
     * Create a new HashMapCounter with the given default value
     * @param defaultValue Value to initialize {@code defaultValue} to
     * @see HashMapCounter#defaultValue
     */
    public HashMapCounter(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * Used internally to prevent NullPointerExceptions
     * @param key Key to check
     */
    private void checkForVoidValue(K key) {
        map.computeIfAbsent(key, k -> defaultValue);
    }

    /**
     * Increment the given key
     * @param key Key to increment
     * @return The new value
     */
    public int increment(K key) {
        checkForVoidValue(key);
        map.put(key, map.get(key) + 1);
        return map.get(key);
    }

    /**
     * Decrement the given key
     * @param key Key to decrement
     * @return The new value
     */
    public int decrement(K key) {
        checkForVoidValue(key);
        map.put(key, map.get(key) - 1);
        return map.get(key);
    }

    /**
     * Get the value of the given key
     * @param key Key to get the value of
     * @return The current value
     */
    public int getValue(K key) {
        checkForVoidValue(key);
        return map.get(key);
    }

    /**
     * Get the current default value
     * @return Value of {@code defaultValue}
     * @see HashMapCounter#defaultValue
     */
    public int getDefaultValue() {
        return defaultValue;
    }

    /**
     * Set the default value
     * @param defaultValue New value for {@code defaultValue}
     * @see HashMapCounter#defaultValue
     */
    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * Clears the map
     */
    public void clear() {
        map.clear();
    }

    /**
     * Returns a String representation of the map
     * @return The map as a String
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return map.toString();
    }
}
