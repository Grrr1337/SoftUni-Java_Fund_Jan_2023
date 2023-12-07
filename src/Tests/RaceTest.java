package Tests;

import RegularExpressions.Race;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;

public class RaceTest {

    @Test
    public void testRace1() {
        String input = "George, Peter, Bill, Tom\n" +
                "G4e@55or%6g6!68e!!@\n" +
                "R1@!3a$y4456@\n" +
                "B5@i@#123ll\n" +
                "G@e54o$r6ge#\n" +
                "7P%et^#e5346r\n" +
                "T$o553m&6\n" +
                "end of race";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));
        Race.main(new String[]{});
        String output = out.toString();
        String expected = "1st place: George\n2nd place: Peter\n3rd place: Bill\n";
//        assertEquals(expected, output);
        assertOutputEquals(expected, output);
    }

    @Test
    public void testRace2() {
        String input = "Joro, George, Georgi, Stamat\n" +
                "^&^%^232St#$ama&&^^t\n" +
                "^&^%^232St#$ama&&^^t\n" +
                "G7667eorge&^^&^\n" +
                "&^&&&J99999oro&^^57\n" +
                "end of race";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));
        Race.main(new String[]{});
        String output = out.toString();
        String expected = "1st place: Joro\n2nd place: George\n3rd place: Georgi\n";
//        assertEquals(expected, output);
        assertOutputEquals(expected, output);
    }

    public static void assertOutputEquals(String expectedOutput, String actualOutput) {
        String normalizedExpected = expectedOutput.replaceAll("\\r\\n", "\n").trim();
        String normalizedActual = actualOutput.replaceAll("\\r\\n", "\n").trim();
        assertEquals(normalizedExpected, normalizedActual);
    }

}
