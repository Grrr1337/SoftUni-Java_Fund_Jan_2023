package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import AssociativeArrays.SoftUniParking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;

import org.junit.After;
import org.junit.Before;


public class SoftUniParkingTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testExecuteCommand() {
        SoftUniParking parking = new SoftUniParking();
        parking.executeCommand("register John CS1234JS");
        parking.executeCommand("register George JAVA123S");
        parking.executeCommand("register Andy AB4142CD");
        parking.executeCommand("register Jesica VR1223EE");
        parking.executeCommand("unregister Andy");
        LinkedHashMap<String, String> expectedDatabase = new LinkedHashMap<>();
        expectedDatabase.put("John", "CS1234JS");
        expectedDatabase.put("George", "JAVA123S");
        expectedDatabase.put("Jesica", "VR1223EE");
        assertEquals(expectedDatabase, parking.getParkingDatabase());
    }

    @Test
    public void testPrintDatabase() {
        SoftUniParking parking = new SoftUniParking();
        parking.executeCommand("register John CS1234JS");
        parking.executeCommand("register George JAVA123S");
        parking.executeCommand("register Andy AB4142CD");
        parking.executeCommand("register Jesica VR1223EE");
        parking.executeCommand("unregister Andy");

        // Redirect System.in to an empty input stream
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);

        // Redirect System.out to outContent
        System.setOut(new PrintStream(outContent));

        // Call printDatabase and verify output
        parking.printDatabase();
        assertEquals("John => CS1234JS\r\nGeorge => JAVA123S\r\nJesica => VR1223EE\r\n", outContent.toString());
    }


    @Test
    public void testMultipleRegistrations() {
        SoftUniParking parking = new SoftUniParking();
        parking.executeCommand("register Jony AA4132BB");
        parking.executeCommand("register Jony AA4132BB");
        parking.executeCommand("register Linda AA9999BB");
        parking.executeCommand("unregister Jony");
        LinkedHashMap<String, String> expectedDatabase = new LinkedHashMap<>();
        expectedDatabase.put("Linda", "AA9999BB");
        assertEquals(expectedDatabase, parking.getParkingDatabase());
    }

    @Test
    public void testMultipleCommands() {
        SoftUniParking parking = new SoftUniParking();
        parking.executeCommand("register Jacob MM1111XX");
        parking.executeCommand("register Anthony AB1111XX");
        parking.executeCommand("unregister Jacob");
        parking.executeCommand("register Joshua DD1111XX");
        parking.executeCommand("unregister Lily");
        parking.executeCommand("register Samantha AA9999BB");
        LinkedHashMap<String, String> expectedDatabase = new LinkedHashMap<>();
        expectedDatabase.put("Anthony", "AB1111XX");
        expectedDatabase.put("Joshua", "DD1111XX");
        expectedDatabase.put("Samantha", "AA9999BB");
        assertEquals(expectedDatabase, parking.getParkingDatabase());
    }

    @Test
    public void testCaseSensitivity() {
        SoftUniParking validator = new SoftUniParking();
        validator.executeCommand("register John CS1234JS");
        validator.executeCommand("register george JAVA123S");
        validator.executeCommand("register aNDY AB4142CD");
        validator.executeCommand("register Jesica VR1223EE");
        validator.executeCommand("unregister Andy");
        validator.executeCommand("unregister Jesica");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        validator.printDatabase();
        String expectedOutput = "John => CS1234JS\ngeorge => JAVA123S\naNDY => AB4142CD\n";
//        assertEquals(expectedOutput, outputStream.toString());
        assertOutputEquals(expectedOutput, outputStream.toString());
    }

    public static void assertOutputEquals(String expectedOutput, String actualOutput) {
        String normalizedExpected = expectedOutput.replaceAll("\\r\\n", "\n").trim();
        String normalizedActual = actualOutput.replaceAll("\\r\\n", "\n").trim();
        assertEquals(normalizedExpected, normalizedActual);
    }

}

