package Tests;

import TextProcessing.ValidUsernames;
import org.junit.Test;
import static org.junit.Assert.*;


public class ValidUsernamesTest {
    @Test
    public void testValidUsername() {
        assertTrue(ValidUsernames.isValid("jeffbutt"));
        assertTrue(ValidUsernames.isValid("john45"));
        assertTrue(ValidUsernames.isValid("peter-ivanov"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(ValidUsernames.isValid("sh"));
        assertFalse(ValidUsernames.isValid("too_long_username"));
        assertFalse(ValidUsernames.isValid("!lleg@l ch@rs"));
        assertFalse(ValidUsernames.isValid("@smith"));
    }

    @Test
    public void testBoundaryCases() {
        assertTrue(ValidUsernames.isValid("abc"));
        assertTrue(ValidUsernames.isValid("abcdefghijklmnop"));
        assertFalse(ValidUsernames.isValid("ab"));
        assertFalse(ValidUsernames.isValid("abcdefghijklmnopq"));
        assertFalse(ValidUsernames.isValid(""));
    }
}

