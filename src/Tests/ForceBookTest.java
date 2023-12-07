package Tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import AssociativeArrays.ForceBook;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class ForceBookTest {
    @Test
    public void testForceBook1() {
        String input = "Light | Peter\nDark | Kim\nLumpawaroo\n";
        String expectedOutput = "Side: Light, Members: 1\n! Peter\nSide: Dark, Members: 1\n! Kim\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));
        ForceBook.main(new String[]{});
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testForceBook2() {
        String input = "Lighter | Royal\nDarker | DCay\nIvan Ivanov -> Lighter\nDCay -> Lighter\nLumpawaroo\n";
        String expectedOutput = "Ivan Ivanov joins the Lighter side!\nDCay joins the Lighter side!\nSide: Lighter, Members: 3\n! Royal\n! Ivan Ivanov\n! DCay\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));
        ForceBook.main(new String[]{});
        assertEquals(expectedOutput, out.toString());
    }


}
