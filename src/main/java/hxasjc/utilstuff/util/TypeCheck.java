package hxasjc.utilstuff.util;

/**
 * Debugging class used to find the type of a given variable.
 *
 * <br/>
 *
 * All Methods return a {@link TypeCheckResult} object
 *
 * @see TypeCheckResult
 */
public class TypeCheck {
    /**
     * Handles any Object
     * @param obj Variable to check
     * @return A TypeCheckResult containing information about the variable passed
     * @see TypeCheckResult
     */
    public static TypeCheckResult check(Object obj) {
        return new TypeCheckResult(Type.OBJECT, obj.getClass().getSimpleName());
    }

    /**
     * Handles int primitives
     * @param i Variable to check
     * @return A TypeCheckResult containing information about the variable passed
     * @see TypeCheckResult
     */
    public static TypeCheckResult check(int i) {
        return new TypeCheckResult(Type.PRIMITIVE, "int");
    }

    /**
     * Handles char primitives
     * @param c Variable to check
     * @return A TypeCheckResult containing information about the variable passed
     * @see TypeCheckResult
     */
    public static TypeCheckResult check(char c) {
        return new TypeCheckResult(Type.PRIMITIVE, "char");
    }

    /**
     * Handles double primitives
     * @param d Variable to check
     * @return A TypeCheckResult containing information about the variable passed
     * @see TypeCheckResult
     */
    public static TypeCheckResult check(double d) {
        return new TypeCheckResult(Type.PRIMITIVE, "double");
    }

    /**
     * Handles float primitives
     * @param f Variable to check
     * @return A TypeCheckResult containing information about the variable passed
     * @see TypeCheckResult
     */
    public static TypeCheckResult check(float f) {
        return new TypeCheckResult(Type.PRIMITIVE, "float");
    }

    /**
     * Handles short primitives
     * @param s Variable to check
     * @return A TypeCheckResult containing information about the variable passed
     * @see TypeCheckResult
     */
    public static TypeCheckResult check(short s) {
        return new TypeCheckResult(Type.PRIMITIVE, "short");
    }

    /**
     * Handles long primitives
     * @param l Variable to check
     * @return A TypeCheckResult containing information about the variable passed
     * @see TypeCheckResult
     */
    public static TypeCheckResult check(long l) {
        return new TypeCheckResult(Type.PRIMITIVE, "long");
    }

    /**
     * Handles byte primitives
     * @param b Variable to check
     * @return A TypeCheckResult containing information about the variable passed
     * @see TypeCheckResult
     */
    public static TypeCheckResult check(byte b) {
        return new TypeCheckResult(Type.PRIMITIVE, "byte");
    }

    /**
     * Handles boolean primitives
     * @param b Variable to check
     * @return A TypeCheckResult containing information about the variable passed
     * @see TypeCheckResult
     */
    public static TypeCheckResult check(boolean b) {
        return new TypeCheckResult(Type.PRIMITIVE, "boolean");
    }

    /**
     * Used to store the result of any type checking method in the {@link TypeCheck} class
     * @param a {@link Type} enum representing whether the passed variable is a primitive or object
     * @param b String representing additional information based on the value of {@link TypeCheckResult#a}
     *          <br/>
     *          If the variable was a primitive, this value will be the name of the primitive. This will always be one of the following:
     *          ("int", "char", "double", "float", "short", "long", "byte", "boolean").
     *          <br/>
     *          If the variable was an object, this value will be the simple class name of the object
     */
    private record TypeCheckResult(Type a, String b) {}

    /**
     * Enum representing the type of the variable passed into the type check
     */
    public enum Type {
        /**
         * Represents an Object variable
         */
        OBJECT,

        /**
         * Represents a Primitive variable
         */
        PRIMITIVE;
    }
}
