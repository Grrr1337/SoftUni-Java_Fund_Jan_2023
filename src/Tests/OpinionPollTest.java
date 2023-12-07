package Tests;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

import ObjectsAndClasses.OpinionPoll;
import org.junit.jupiter.api.Assertions;

public class OpinionPollTest {

    @Test
    public void testOpinionPoll1() {
        String input = "3\n" +
                "Peter 12\n" +
                "Sam 31\n" +
                "Itan 48\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OpinionPoll.main(new String[]{});

        String expectedOutput = "Sam - 31\n" + "Itan - 48\n";
//        assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    public void testOpinionPoll2() {
        String input = "5\n" +
                "Niko 33\n" +
                "Yana 88\n" +
                "Todor 22\n" +
                "Lisa 44\n" +
                "Sam 11\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OpinionPoll.main(new String[]{});

        List<String> expectedOutputList = Arrays.asList("Niko - 33\n", "Yana - 88\n", "Lisa - 44\n");
        String expectedOutput = String.join("", expectedOutputList);
//        assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    public static void assertOutputEquals(String expectedOutput, String actualOutput) {
        String normalizedExpected = expectedOutput.replaceAll("\\r\\n", "\n").trim();
        String normalizedActual = actualOutput.replaceAll("\\r\\n", "\n").trim();
        Assertions.assertEquals(normalizedExpected, normalizedActual);
    }

}

