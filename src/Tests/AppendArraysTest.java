package Tests;

import Lists.AppendArrays;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppendArraysTest {
    @Test
    public void testAppendArrays1() {
        String input = "1 2 3 |4 5 6 |  7  8\n";
        String expectedOutput = "7 8 4 5 6 1 2 3";
        testAppendArrays(input, expectedOutput);
    }

    @Test
    public void testAppendArrays2() {
        String input = "7 | 4  5|1 0| 2 5 |3\n";
        String expectedOutput = "3 2 5 1 0 4 5 7";
        testAppendArrays(input, expectedOutput);
    }

    @Test
    public void testAppendArrays3() {
        String input = "1| 4 5 6 7  |  8 9\n";
        String expectedOutput = "8 9 4 5 6 7 1";
        testAppendArrays(input, expectedOutput);
    }

    private void testAppendArrays(String input, String expectedOutput) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        AppendArrays.main(new String[0]);

        assertEquals(expectedOutput, outContent.toString().trim());
    }
}
