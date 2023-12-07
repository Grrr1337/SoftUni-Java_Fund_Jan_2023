package Tests;

import AssociativeArrays.MinerTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinerTaskTest {

    @Test
    void testMinerTask() {
        String input = "Gold\n155\nSilver\n10\nCopper\n17\nstop\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        MinerTask.main(new String[]{});

        String expectedOutput = "Gold -> 155\nSilver -> 10\nCopper -> 17\n";
//        Assertions.assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    void testMinerTaskCaseSensitivity() {
        String input = "Gold\n155\ngold\n15\nstop\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        MinerTask.main(new String[]{});

        String expectedOutput = "Gold -> 155\ngold -> 15\n";
//        Assertions.assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    void testMinerTaskMultiple() {
        String input = "gold\n155\nsilver\n10\ncopper\n17\nstop\ngold\n15\nstop\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        MinerTask.main(new String[]{});

        String expectedOutput = "gold -> 155\nsilver -> 10\ncopper -> 17\n";
//        Assertions.assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    void testMinerTaskOrder() {
        String input = "Gold\n155\nSilver\n10\nGold\n15\nstop\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        MinerTask.main(new String[]{});

        String expectedOutput = "Gold -> 170\nSilver -> 10\n";
//        Assertions.assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    public static void assertOutputEquals(String expectedOutput, String actualOutput) {
        String normalizedExpected = expectedOutput.replaceAll("\\r\\n", "\n").trim();
        String normalizedActual = actualOutput.replaceAll("\\r\\n", "\n").trim();
        assertEquals(normalizedExpected, normalizedActual);
    }

}
