package Tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import AssociativeArrays.Courses;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class CoursesTest {
    @Test
    public void test1() {
        String input = "Programming Fundamentals : John Smith\n" +
                "Programming Fundamentals : Linda Johnson\n" +
                "JS Core : Will Wilson\n" +
                "Java Advanced : Harrison White\n" +
                "end\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Courses.main(new String[0]);

        String expectedOutput = "Programming Fundamentals: 2\n" +
                "-- John Smith\n" +
                "-- Linda Johnson\n" +
                "JS Core: 1\n" +
                "-- Will Wilson\n" +
                "Java Advanced: 1\n" +
                "-- Harrison White\n";
//        assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    public void test2() {
        String input = "Algorithms : Jay Moore\n" +
                "Programming Basics : Martin Taylor\n" +
                "Python Fundamentals : John Anderson\n" +
                "Python Fundamentals : Andrew Robinson\n" +
                "Algorithms : Bob Jackson\n" +
                "Python Fundamentals : Clark Lewis\n" +
                "end\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Courses.main(new String[0]);

        String expectedOutput = "Algorithms: 2\n" +
                "-- Jay Moore\n" +
                "-- Bob Jackson\n" +
                "Programming Basics: 1\n" +
                "-- Martin Taylor\n" +
                "Python Fundamentals: 3\n" +
                "-- John Anderson\n" +
                "-- Andrew Robinson\n" +
                "-- Clark Lewis\n";
//        assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    public void test3() {
        String input = "Data Structures : Alice Brown\n" +
                "Algorithms : Bob Smith\n" +
                "Algorithms : Charlie Jones\n" +
                "Data Structures : David Lee\n" +
                "end\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Courses.main(new String[0]);

        String expectedOutput = "Data Structures: 2\n" +
                "-- Alice Brown\n" +
                "-- David Lee\n" +
                "Algorithms: 2\n" +
                "-- Bob Smith\n" +
                "-- Charlie Jones\n";
//        assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    public void test4() {
        String input = "Art History : Emily Davis\n" +
                "Biology : Frank Evans\n" +
                "end\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Courses.main(new String[0]);

        String expectedOutput = "Art History: 1\n" +
                "-- Emily Davis\n" +
                "Biology: 1\n" +
                "-- Frank Evans\n";
//        assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    public static void assertOutputEquals(String expectedOutput, String actualOutput) {
        String normalizedExpected = expectedOutput.replaceAll("\\r\\n", "\n").trim();
        String normalizedActual = actualOutput.replaceAll("\\r\\n", "\n").trim();
        assertEquals(normalizedExpected, normalizedActual);
    }

}
