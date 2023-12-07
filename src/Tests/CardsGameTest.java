package Tests;

import Lists.CardsGame;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardsGameTest {

    @Test
    public void testMain1() {
        String input = "20 30 40 50\n" +
                "10 20 30 40\n";
        String expectedOutput = "First player wins! Sum: 240"; // + System.lineSeparator();
        assertConsoleOutput(input, expectedOutput);
    }

    @Test
    public void testMain2() {
        String input = "10 20 30 40 50\n" +
                "50 40 30 30 10\n";
        String expectedOutput = "Second player wins! Sum: 50\n";
        assertConsoleOutput(input, expectedOutput);
    }

    private void assertConsoleOutput(String input, String expectedOutput) {
        // Redirect System.in to a string containing the test input
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        // Capture the console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the main method of the CardsGame class
        CardsGame.main(new String[]{});

        // Assert that the console output matches the expected output
        assertSame(expectedOutput, outContent.toString());


    }
}


