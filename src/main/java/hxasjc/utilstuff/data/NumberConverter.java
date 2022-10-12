package hxasjc.utilstuff.data;

@Deprecated
public class NumberConverter {
    public static <T extends Number> int getIntValue(T number) {
        return number.intValue();
    }

    public static <T extends Number> double getDoubleNumber(T number) {
        return number.doubleValue();
    }
}
