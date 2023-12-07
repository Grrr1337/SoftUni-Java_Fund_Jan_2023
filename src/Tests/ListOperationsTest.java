package Tests;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import Lists.ListOperations;

public class ListOperationsTest {


    @Test
    public void testListOperations1() {
        // Test input and expected output
        String input = "1 23 29 18 43 21 20\n" +
                "Add 5\n" +
                "Remove 5\n" +
                "Shift left 3\n" +
                "Shift left 1\n" +
                "End\n";
        String expectedOutput = "43 20 5 1 23 29 18" + System.lineSeparator();

        // Redirect System.in and System.out to test input and output streams
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        // Call ListOperations method
        ListOperations.main(new String[0]);

        // Assert that output matches expected output
        assertEquals(expectedOutput, out.toString().trim());
    }

    @Test
    public void testListOperations2() {
        // Test input and expected output
        String input = "5 12 42 95 32 1\n" +
                "Insert 3 0\n" +
                "Remove 10\n" +
                "Insert 8 6\n" +
                "Shift right 1\n" +
                "Shift left 2\n" +
                "End";
        String expectedOutput = "Invalid index" + System.lineSeparator() +
                "5 12 42 95 32 8 1 3" + System.lineSeparator();

        // Redirect System.in and System.out to test input and output streams
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        // Call ListOperations method
        ListOperations.main(new String[0]);

        // Assert that output matches expected output
        assertEquals(expectedOutput, out.toString().trim());
    }
}



/*
 public static void main(String[] args) {
        // Test input and expected output
        String input = "1 23 29 18 43 21 20\n" +
                "Add 5\n" +
                "Remove 5\n" +
                "Shift left 3\n" +
                "Shift left 1\n" +
                "End";
        String expectedOutput = "43 20 5 1 23 29 18" + System.lineSeparator();

        // Redirect System.in and System.out to test input and output streams
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        // Call ListOperations method
        Lists.ListOperations.main(new String[0]);
        System.out.println("Expected output:\n");
        System.out.print(expectedOutput);

        System.out.println("Actual output: \n");
        System.out.println(out.toString().trim());
    }
*/
