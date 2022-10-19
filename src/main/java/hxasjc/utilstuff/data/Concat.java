package hxasjc.utilstuff.data;

import hxasjc.utilstuff.internal.Optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class for easily concatenating any number of objects. All fields in this class are final. It is possible to concatenate any type of objects
 */
public class Concat {
    /**
     * Pre-created Concat with no separator that skips nulls
     */
    public static final Concat NO_SEPARATOR = new ConcatBuilder().separator("").skipNulls().build();

    /**
     * String to separate objects with
     */
    private final String separator;
    /**
     * What to do regarding null elements
     * @see NullBehaviour
     */
    private final NullBehaviour nullBehaviour;
    /**
     * What to replace null elements with (if desired)
     * @see Concat#nullBehaviour
     */
    private final String nullReplaceText;

    /**
     * Internal constructor. Use {@link ConcatBuilder} to create a new Concat object
     * @param separator String to separate objects with
     * @param nullBehaviour What to do regarding null elements
     * @param nullReplaceText What to replace null elements with (if desired)
     */
    private Concat(String separator, NullBehaviour nullBehaviour, String nullReplaceText) {
        this.separator = separator;
        this.nullBehaviour = nullBehaviour;
        this.nullReplaceText = nullReplaceText;
    }

    /*public String concat(Object[] objects) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < objects.length; i++) {
            Object obj = objects[i];
            stringBuilder.append(obj);
            if (i < (objects.length - 1)) {
                stringBuilder.append(separator);
            }
        }
        return stringBuilder.toString();
    }*/

    /*public String concat(Object... objects) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < objects.length; i++) {
            Object obj = objects[i];
            stringBuilder.append(obj);
            if (i < (objects.length - 1)) {
                stringBuilder.append(separator);
            }
        }
        return stringBuilder.toString();
    }*/

    /*public String concat(Object[]... objects) {
        //
    }*/

    /**
     * Concatenate any number of objects
     * @param obj1 First object to concatenate
     * @param obj2 Second object to concatenate
     * @param objects Any number of additional objects to concatenate
     * @return A concatenated String
     */
    public String concat(Object obj1, Object obj2, @Optional Object... objects) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        if (objects != null) {
            list.addAll(Arrays.asList(objects));
        }
        return concat(list);
    }

    /**
     * Concatenate any number of object arrays.
     * @param arr1 First array to concatenate
     * @param arr2 Second array to concatenate
     * @param objects Any number of additional arrays to concatenate
     * @return A concatenated String
     */
    public String concat(Object[] arr1, Object[] arr2, @Optional Object[]... objects) {
        ArrayList<Object> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr1));
        list.addAll(Arrays.asList(arr2));
        if (objects != null) {
            for (Object[] arr : objects) {
                list.addAll(Arrays.asList(arr));
            }
        }
        return concat(list);
    }

    /**
     * For concatenating a single array
     * @param arr Array to concatenate
     * @return A concatenated String
     */
    public String concat(Object[] arr) {
        return concat(Arrays.asList(arr));
    }

    /**
     * Concatenate a List of objects
     * @param objects List to concatenate
     * @return A concatenated String
     */
    public String concat(List<?> objects) {
        //System.out.println(objects); //debug
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < objects.size(); i++) {
            Object obj = objects.get(i);
            boolean ignoreObj = false;
            if (obj == null) {
                switch (nullBehaviour) {
                    case SKIP -> ignoreObj = true;
                    case REPLACE -> obj = nullReplaceText;
                }
            }
            if (!ignoreObj) {
                stringBuilder.append(obj);
                //TODO: dont append separator if string is an escape sequence
                if (obj.toString().startsWith("\\") && obj.toString().contains(" ")) {
                    if (i < (objects.size() - 1)) {
                        stringBuilder.append(separator);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Returns a String representation of the Concat object
     * @return A String representing the object
     */
    @Override
    public String toString() {
        return "Concat{" +
                "separator='" + separator + '\'' +
                ", nullBehaviour=" + nullBehaviour +
                ", nullReplaceText='" + nullReplaceText + '\'' +
                '}';
    }

    /**
     * Contains the 2 options for dealing with null elements when concatenating
     */
    public enum NullBehaviour {
        /**
         * Skip any null elements
         */
        SKIP,
        /**
         * Replace any null elements with the string stored in {@link Concat#nullReplaceText}
         */
        REPLACE
    }

    /**
     * Build a new Concat object. These properties cannot be changed after initialization
     */
    public static class ConcatBuilder {
        /**
         * String to separate objects with
         */
        private String separator;
        /**
         * What to do regarding null elements
         */
        private NullBehaviour nullBehaviour;
        /**
         * What to replace null elements with (if desired)
         */
        private String nullReplaceText;

        /**
         * Create a new ConcatBuilder
         */
        public ConcatBuilder() {
            //
        }

        /**
         * Set the concatenation separator string
         * @param separator Set the separator string
         * @return This builder object
         */
        public ConcatBuilder separator(String separator) {
            this.separator = separator;
            return this;
        }

        /**
         * Sets the null handling behaviour to ignore null elements
         * @return This builder object
         */
        public ConcatBuilder skipNulls() {
            nullBehaviour = NullBehaviour.SKIP;
            return this;
        }

        /**
         * Sets the null handling behaviour to replace null elements with the given string
         * @param replacementText Text to replace null elements with
         * @return This builder element
         */
        public ConcatBuilder replaceNullsWith(String replacementText) {
            nullBehaviour = NullBehaviour.REPLACE;
            nullReplaceText = replacementText;
            return this;
        }

        /**
         * Build the Concat object
         * @return A Concat object that contains the information passed into the builder
         * @throws NullPointerException if either the separator text or null handling behaviour have not been set
         */
        public Concat build() {
            if (separator == null) {
                throw new NullPointerException("Cannot build Concat object with null parameters (missing separator)");
            }
            if (nullBehaviour == null) {
                throw new NullPointerException("Cannot build Concat object with null parameters (missing null behaviour)");
            }
            if (nullBehaviour.equals(NullBehaviour.REPLACE) && nullReplaceText == null) {
                throw new NullPointerException("Cannot build Concat object with null parameters (missing null replacement text)");
            }

            return new Concat(separator, nullBehaviour, nullReplaceText);
        }
    }
}
