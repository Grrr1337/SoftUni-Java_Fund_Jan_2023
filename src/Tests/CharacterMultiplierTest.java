package Tests;

import TextProcessing.CharacterMultiplier;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterMultiplierTest {
    @Test
    public void testStringsWithSameLength() {
        int expected = 52114;
        int result = CharacterMultiplier.multiply("George", "Peter");
        assertEquals(expected, result);
    }

    @Test
    public void testStringsWithDifferentLength() {
        int expected = 45337;
        int result = CharacterMultiplier.multiply("love", "SoftUni");
        assertEquals(expected, result);
    }

    @Test
    public void testStringsWithNumbers() {
        int expected = 7647;
        int result = CharacterMultiplier.multiply("123", "522");
        assertEquals(expected, result);
    }
}


/*
public class CharacterMultiplierTest {
    @Test
    public void testMultiply() {
        assertEquals(52114, CharacterMultiplier.multiply("George", "Peter"));
        assertEquals(7647, CharacterMultiplier.multiply("123", "522"));
        assertEquals(45337, CharacterMultiplier.multiply("love", "SoftUni"));
    }
}
*/
