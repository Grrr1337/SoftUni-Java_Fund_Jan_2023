package Tests;

import ObjectsAndClasses.OrderByAge;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderByAgeTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @Test
    void testOrderByAge() {
        String input = "George 123456 20\n" +
                "Peter 78911 15\n" +
                "Stephan 524244 10\n" +
                "End\n";
        String expectedOutput = "Stephan with ID: 524244 is 10 years old.\n" +
                "Peter with ID: 78911 is 15 years old.\n" +
                "George with ID: 123456 is 20 years old.\n";
        provideInput(input);
        OrderByAge.main(new String[]{});
//        assertEquals(expectedOutput, getOutput());
        assertOutputEquals(expectedOutput, getOutput());
    }

    @Test
    void testOrderByAgeWithSameAge() {
        String input = "Cindy 88611 2\n" +
                "Kaloyan 13967 3\n" +
                "Simona 53316 11\n" +
                "Gil 31837 72\n" +
                "End\n";
        String expectedOutput = "Cindy with ID: 88611 is 2 years old.\n" +
                "Kaloyan with ID: 13967 is 3 years old.\n" +
                "Simona with ID: 53316 is 11 years old.\n" +
                "Gil with ID: 31837 is 72 years old.\n";
        provideInput(input);
        OrderByAge.main(new String[]{});
//        assertEquals(expectedOutput, getOutput());

//        assertEquals(expectedOutput.replaceAll("\\r\\n", "\n").trim(),
//                getOutput().replaceAll("\\r\\n", "\n").trim());
        assertOutputEquals(expectedOutput, getOutput());
    }

    public static void assertOutputEquals(String expectedOutput, String actualOutput) {
        String normalizedExpected = expectedOutput.replaceAll("\\r\\n", "\n").trim();
        String normalizedActual = actualOutput.replaceAll("\\r\\n", "\n").trim();
        assertEquals(normalizedExpected, normalizedActual);
    }



}
