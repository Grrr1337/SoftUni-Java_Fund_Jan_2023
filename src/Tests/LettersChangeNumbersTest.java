package Tests;

import TextProcessing.LettersChangeNumbers;
import org.junit.Test;
import static org.junit.Assert.*;

public class LettersChangeNumbersTest {

    @Test
    public void testLettersChangeNumbers() {
        String input1 = "A12b s17G";
        String input2 = "P34562Z q2576f   H456z";
        String input3 = "a1A";
        double expectedOutput1 = 330.00;
        double expectedOutput2 = 46015.13;
        double expectedOutput3 = 0.00;
        assertEquals(expectedOutput1, LettersChangeNumbers.sumOfProcessedNumbers(input1), 0.01);
        assertEquals(expectedOutput2, LettersChangeNumbers.sumOfProcessedNumbers(input2), 0.01);
        assertEquals(expectedOutput3, LettersChangeNumbers.sumOfProcessedNumbers(input3), 0.01);
    }
}

