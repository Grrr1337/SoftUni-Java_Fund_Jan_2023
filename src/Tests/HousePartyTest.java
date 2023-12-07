package Tests;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HousePartyTest {
    @Test
    public void testHouseParty1() {
        // Test input and expected output
        String input = "5\n" +
                "Tom is going!\n" +
                "Annie is going!\n" +
                "Tom is going!\n" +
                "Garry is going!\n" +
                "Jerry is going!";
        String expectedOutput =
                "Tom is already in the list!\n" +
                        "Tom\n" +
                        "Annie\n" +
                        "Garry\n" +
                        "Jerry";

        // Redirect System.in and System.out to test input and output streams
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        // Call HouseParty method
        Lists.HouseParty.main(new String[0]);

        // Assert that output matches expected output
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testHouseParty2() {
        // Test input and expected output
        String input = "4\n" +
                        "Allie is going!\n" +
                        "George is going!\n" +
                        "John is not going!\n" +
                        "George is not going!";
        String expectedOutput = "John is not in the list!\n" +
                        "Allie";

        // Redirect System.in and System.out to test input and output streams
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        // Call HouseParty method
        Lists.HouseParty.main(new String[0]);

        // Assert that output matches expected output
        assertEquals(expectedOutput, out.toString());
    }

}
