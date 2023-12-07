package Tests;

import TextProcessing.ReplaceRepeatingChars;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplaceRepeatingCharsTest {
    @Test
    void test1() {
        String input = "aaaaabbbbbcdddeeeedssaa";
        String expectedOutput = "abcdedsa";
        String actualOutput = ReplaceRepeatingChars.replaceRepeatingChars(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void test2() {
        String input = "qqqwerqwecccwd";
        String expectedOutput = "qwerqwecwd";
        String actualOutput = ReplaceRepeatingChars.replaceRepeatingChars(input);
        assertEquals(expectedOutput, actualOutput);
    }
}
