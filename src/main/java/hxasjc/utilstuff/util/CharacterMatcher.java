package hxasjc.utilstuff.util;

import java.util.*;
import java.util.function.Predicate;

/**
 * Defines sets of Characters that can be used for a variety of functions that include matching characters
 */
public class CharacterMatcher implements Predicate<Character> {
    /**
     * Predefined set of the 26 upper case letters in the Latin alphabet
     */
    public static final CharacterMatcher UPPER_CASE_LETTERS;

    static {
        Character[] characters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        UPPER_CASE_LETTERS = getCharacterMatcherWithAnyOf(Arrays.asList(characters));
    }

    /**
     * Predetermined set of the 26 lower case letters in the Latin alphabet
     */
    public static final CharacterMatcher LOWER_CASE_LETTERS;

    static {
        Character[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        LOWER_CASE_LETTERS = getCharacterMatcherWithAnyOf(Arrays.asList(characters));
    }

    /**
     * Predetermined set of the digits 1-0
     */
    public static final CharacterMatcher DIGITS;

    static {
        Character[] characters = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        DIGITS = getCharacterMatcherWithAnyOf(characters);
    }

    /**
     * The set of characters in the CharacterMatcher
     */
    private final Set<Character> matchingCharacters;
    /**
     * Random object used for {@link CharacterMatcher#getRandomCharacter()}
     */
    private final Random random = new Random();

    /**
     * Create a new CharacterMatcher with the given list of characters.
     * <br/>
     * For creating new CharacterMatcher objects, use {@link CharacterMatcher#getCharacterMatcherWithAnyOf(List)}
     * @param characters Characters to use in the set
     */
    protected CharacterMatcher(List<Character> characters) {
        ListUtils.removeNullElements(characters);
        matchingCharacters = new HashSet<>(characters);
    }

    /**
     * Only provided to satisfy the Predicate interface
     * @deprecated
     * @param character The input argument
     * @return False
     */
    @Deprecated
    @Override
    public boolean test(Character character) {
        return false;
    }

    /**
     * Combines the current CharacterMatcher and the given one
     * @param other The CharacterMatcher to combine with the current one
     * @return A CharacterMatcher, which is a combination of the 2 used in this method
     */
    public CharacterMatcher and(CharacterMatcher other) {
        ArrayList<Character> list = new ArrayList<>();
        list.addAll(this.getMatchingCharacters());
        list.addAll(other.getMatchingCharacters());
        return getCharacterMatcherWithAnyOf(list);
    }

    /**
     * Whether the given character is contained in the set
     * @param c Character to check
     * @return Whether the given character is contained in the set
     */
    public boolean matches(char c) {
        for (Character character : matchingCharacters) {
            if (character.equals(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove all characters in the given CharSequence that are contained in the set
     * @param sequence CharSequence to remove characters from
     * @return A string containing the CharSequence after removing characters contained in the set
     */
    public String removeMatching(CharSequence sequence) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : sequence.toString().toCharArray()) {
            if (!matches(character)) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Remove all characters in the given CharSequence that are NOT contained in the set
     * @param sequence CharSequence to remove characters from
     * @return A string containing the CharSequence after removing characters NOT contained in the set
     */
    public String removeNonMatching(CharSequence sequence) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : sequence.toString().toCharArray()) {
            if (matches(character)) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Get a set of all characters in the CharacterMatcher
     * @return Set containing the characters
     */
    public Set<Character> getMatchingCharacters() {
        return matchingCharacters;
    }

    /**
     * Get a random character in the set.
     * @return A pseudo-random character contained in the CharacterMatcher
     */
    public Character getRandomCharacter() {
        Character[] array = matchingCharacters.toArray(new Character[0]);
        int index = random.nextInt(array.length);
        return array[index];
    }

    /**
     * Count the number of characters in the given CharSequence that are contained in this CharacterMatcher
     * @param sequence The CharSequence to count from
     * @return The count
     */
    public int countIn(CharSequence sequence) {
        int count = 0;
        for (Character character : sequence.toString().toCharArray()) {
            if (matches(character)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns a CharacterMatcher containing the given list of characters
     * @param characters Characters to include in the CharacterMatcher
     * @return New CharacterMatcher
     */
    public static CharacterMatcher getCharacterMatcherWithAnyOf(List<Character> characters) {
        return new CharacterMatcher(characters);
    }

    /**
     * Returns a CharacterMatcher containing the given characters
     * @param characters Any number of characters to include
     * @return New CharacterMatcher
     */
    public static CharacterMatcher getCharacterMatcherWithAnyOf(Character... characters) {
        ArrayList<Character> list = new ArrayList<>();
        list.addAll(Arrays.asList(characters));
        return new CharacterMatcher(list);
    }

    /**
     * Returns a new CharacterMatcher containing the characters in the given CharSequence
     * @param sequence CharSequence to get the characters from
     * @return New CharacterMatcher
     */
    public static CharacterMatcher getCharacterMatcherWithAnyOf(CharSequence sequence) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character character : sequence.toString().toCharArray()) {
            list.add(character);
        }
        return getCharacterMatcherWithAnyOf(list);
    }

    /**
     * Returns a new CharacterMatcher containing only the given character. Use {@link CharacterMatcher#getCharacterMatcherWithAnyOf(Character...)} instead.
     * @deprecated 
     * @param character Character to create the CharacterMatcher from
     * @return New CharacterMatcher
     */
    @Deprecated
    public static CharacterMatcher getCharacterMatcherWith(Character character) {
        ArrayList<Character> list = new ArrayList<>();
        list.add(character);
        return new CharacterMatcher(list);
    }
}
