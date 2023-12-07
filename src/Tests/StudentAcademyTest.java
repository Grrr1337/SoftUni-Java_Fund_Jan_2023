package Tests;


import AssociativeArrays.StudentAcademy;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class StudentAcademyTest {

    @Test
    public void test1() {
        String input = "5\n" + "John\n" + "5.5\n" + "John\n" + "4.5\n" + "Alice\n" + "6\n" + "Alice\n" + "3\n" + "George\n" + "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        StudentAcademy.main(new String[0]);

        String expectedOutput = "John -> 5.00\n" + "Alice -> 4.50\n" + "George -> 5.00\n";
//        assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    public void test2() {
        String input = "5\n" + "Amanda\n" + "3.5\n" + "Amanda\n" + "4\n" + "Rob\n" + "5.5\n" + "Christian\n" + "5\n" + "Robert\n" + "6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        StudentAcademy.main(new String[0]);

        String expectedOutput = "Rob -> 5.50\n" + "Christian -> 5.00\n" + "Robert -> 6.00\n";
//        assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    public void test3() {
        String input = "4\n" + "John\n" + "4.5\n" + "Alice\n" + "4.25\n" + "George\n" + "4.75\n" + "Alice\n" + "3.75\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        StudentAcademy.main(new String[0]);

        String expectedOutput = "John -> 4.50\n" + "George -> 4.75\n";
//        assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    public static void assertOutputEquals(String expectedOutput, String actualOutput) {
        String normalizedExpected = expectedOutput.replaceAll("\\r\\n", "\n").trim();
        String normalizedActual = actualOutput.replaceAll("\\r\\n", "\n").trim();
        Assertions.assertEquals(normalizedExpected, normalizedActual);
    }
}