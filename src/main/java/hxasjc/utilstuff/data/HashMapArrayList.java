package hxasjc.utilstuff.data;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

/**
 * Wrapper class for a HashMap where the values are ArrayLists
 * @param <K> Key
 * @param <V> Value
 */
public class HashMapArrayList<K, V> {
    /**
     * Internal map
     */
    private final HashMap<K, ArrayList<V>> map = new HashMap<>();

    /**
     * Blank Constructor
     */
    public HashMapArrayList() {
        //
    }

    /**
     * Used internally to prevent NullPointerExceptions
     * @param key Key to check
     */
    private void checkListExists(K key) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
    }

    /**
     * Add the given value to the list at the given key
     * @param key List to add the value to
     * @param value Value to add
     */
    public void add(K key, V value) {
        checkListExists(key);
        map.get(key).add(value);
    }

    /**
     * Add the given value to the list at the given key at the given index
     * @param key List to add the value to
     * @param value Value to add
     * @param index Index to add the value at
     */
    public void add(K key, V value, int index) {
        checkListExists(key);
        map.get(key).add(index, value);
    }

    /**
     * Add all values in the given collection to the given list
     * @param key List to add the values to
     * @param values Collection of values to add
     */
    public void addAll(K key, Collection<V> values) {
        checkListExists(key);
        map.get(key).addAll(values);
    }

    /**
     * Add all values in the given collection to the given list at the given index
     * @param key List to add the values to
     * @param values Collection of values to add
     * @param index Index to add the values at
     */
    public void addAll(K key, Collection<V> values, int index) {
        checkListExists(key);
        map.get(key).addAll(index, values);
    }

    /**
     * Clear the map
     */
    public void clear() {
        map.clear();
    }

    /**
     * Clear the list at the given key
     * @param key Key to clear
     */
    public void clear(K key) {
        checkListExists(key);
        map.get(key).clear();
    }

    /**
     * Checks if the map contains a list at the given key
     * @param key Key to check for
     * @return Whether a list exists at the given key, as a boolean
     */
    public boolean containsKey(K key) {
        //checkListExists(key);
        return map.containsKey(key);
    }

    /**
     * Checks if the given list contains the given object
     * @param key List to check in
     * @param object Object to check for
     * @return Whether the given object exists in the given list, as a boolean
     */
    public boolean containsValue(K key, V object) {
        checkListExists(key);
        return map.get(key).contains(object);
    }

    /**
     * Increases the list capacity to ensure it is at least equal to minCapacity
     * @param key Key to ensure capacity of
     * @param minCapacity Minimum capacity to ensure
     */
    public void ensureCapacity(K key, int minCapacity) {
        checkListExists(key);
        map.get(key).ensureCapacity(minCapacity);
    }

    /**
     * Check if the given object is equal to this object
     * @param o Object to check equality with
     * @return Whether the objects are equal
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashMapArrayList<?, ?> that = (HashMapArrayList<?, ?>) o;

        return map.equals(that.map);
    }

    /**
     * Returns the hash code of this object
     * @return The hash code for this object
     * @see Object#hashCode()
     * @see Map#hashCode()
     */
    @Override
    public int hashCode() {
        return map.hashCode();
    }

    /**
     * Iterate through all items in the map
     * @param action Action to do on all items, does not return anything
     * @see BiConsumer
     * @see Map#forEach(BiConsumer)
     */
    public void forEach(BiConsumer<K, ArrayList<V>> action) {
        map.forEach(action);
    }

    /**
     * Get the list associated with the given key
     * @param key Key to get list from
     * @return ArrayList belonging to the given key
     */
    public ArrayList<V> get(K key) {
        checkListExists(key);
        return map.get(key);
    }

    /**
     * Get the item at the given index in the given list
     * @param key List to get item from
     * @param index Index to get item from
     * @return The item, or {@code null} if an item cannot be found
     * @see ArrayList#get(int)
     */
    public V get(K key, int index) {
        checkListExists(key);
        return map.get(key).get(index);
    }

    /**
     * Get the first index of the given object in the given list
     * @param key List to check in
     * @param object Object to get index of
     * @return The index of the given object, or {@code -1} if it is not in the list
     * @see ArrayList#indexOf(Object)
     */
    public int indexOf(K key, V object) {
        checkListExists(key);
        return map.get(key).indexOf(object);
    }

    /**
     * Checks if the map is empty
     * @return Whether the map is empty
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * Checks if the list at the given key is empty
     * @param key Key to check
     * @return Whether the list at the given key is empty
     */
    public boolean isEmpty(K key) {
        if (!map.containsKey(key)) {
            return true;
        }
        return map.get(key).isEmpty();
    }

    /**
     * Get a {@link Set} of the keys contained in the map
     * @return A Set of keys in the map
     * @see Map#keySet()
     */
    public Set<K> keySet() {
        return map.keySet();
    }

    /**
     * Get the last index of the given object in the given list
     * @param key List to check
     * @param object Object to check for
     * @return Returns the highest index the object appears at, or {@code -1} if it is not in the list
     */
    public int lastIndexOf(K key, V object) {
        checkListExists(key);
        return map.get(key).lastIndexOf(object);
    }

    /**
     * Remove the item at the given index in the given list
     * @param key List to remove the item from
     * @param index Index to remove the item at
     * @return Returns the removed item
     */
    public V remove(K key, int index) {
        return map.get(key).remove(index);
    }

    /**
     * Remove the first instance of the given object in the given list
     * @param key List to remove the item from
     * @param object Object to remove (if present)
     * @return Whether the object was removed from the list
     */
    public boolean remove(K key, V object) {
        return map.get(key).remove(object);
    }

    /**
     * Removes all items in the given collection from the given list
     * @param key List to remove items from
     * @param collection Collection of items to remove
     * @return Whether the list was modified
     */
    public boolean removeAll(K key, Collection<V> collection) {
        return map.get(key).removeAll(collection);
    }

    /**
     * Removes all items in the given list if they satisfy the filter
     * @param key List to remove items from
     * @param filter Filter to check items against
     * @return Whether any items were removed
     * @see Predicate
     */
    public boolean removeIf(K key, Predicate<V> filter) {
        return map.get(key).removeIf(filter);
    }

    /**
     * Remove all items from the given list that are not in the given collection
     * @param key List to remove items from
     * @param collection Objects to retain
     * @return Whether the list was changed
     */
    public boolean retainAll(K key, Collection<V> collection) {
        return map.get(key).retainAll(collection);
    }

    /**
     * Sets the item at the given index in the given list to the given object
     * @param key List to set item in
     * @param index Index to replace
     * @param value New object to set
     * @return The object previously at the given index
     */
    public V set(K key, int index, V value) {
        return map.get(key).set(index, value);
    }

    /**
     * Get a sublist from the given list, from {@code startIndex} to {@code endIndex}
     * @param key List to get sublist from
     * @param startIndex Starting index of the sublist (inclusive)
     * @param endIndex Ending index of the sublist (exclusive
     * @return The specified sublist
     */
    public List<V> subList(K key, int startIndex, int endIndex) {
        return map.get(key).subList(startIndex, endIndex);
    }

    /**
     * Get an array of items in the given list
     * @param key List to get array of
     * @return Array of all items in list
     */
    public Object[] toArray(K key) {
        return map.get(key).toArray();
    }

    /**
     * Put the given ArrayList at the given key
     * @param key Key to assign the values to
     * @param values Values to assign to the key
     */
    public void put(K key, ArrayList<V> values) {
        map.put(key, values);
    }

    /**
     * Put all Key, Value associations into this map
     * @param putMap Map to put into this map
     */
    public void putAll(Map<K, ArrayList<V>> putMap) {
        map.putAll(putMap);
    }

    /**
     * Remove the list at the given key
     * @param key List to remove
     * @return Previous list associated with this key
     */
    public ArrayList<V> remove(K key) {
        return map.remove(key);
    }

    /**
     * Get the size of the given list
     * @param key List to get the size of
     * @return Size of the given list
     */
    public int size(K key) {
        return map.get(key).size();
    }
}
