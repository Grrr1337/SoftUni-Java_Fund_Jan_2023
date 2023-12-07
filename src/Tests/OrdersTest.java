package Tests;

import AssociativeArrays.Orders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdersTest {
    @Test
    public void testOrders1() {
        String input = "Beer 2.20 100\nIceTea 1.50 50\nNukaCola 3.30 80\nWater 1.00 500\nbuy\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Orders.main(new String[]{});

        String expectedOutput = "Beer -> 220.00\nIceTea -> 75.00\nNukaCola -> 264.00\nWater -> 500.00\n";
//        Assertions.assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    public void testOrders2() {
        String input = "Beer 2.40 350\nWater 1.25 200\nIceTea 5.20 100\nBeer 1.20 200\nIceTea 0.50 120\nbuy\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Orders.main(new String[]{});

        String expectedOutput = "Beer -> 660.00\nWater -> 250.00\nIceTea -> 110.00\n";
//        Assertions.assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    void testSingleOrder() {
        String input = "Beer 2.20 100\nIceTea 1.50 50\nNukaCola 3.30 80\nWater 1.00 500\nbuy\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Orders.main(new String[]{});

        String expectedOutput = "Beer -> 220.00\nIceTea -> 75.00\nNukaCola -> 264.00\nWater -> 500.00\n";
//        Assertions.assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    void testMultipleOrders() {
        String input = "Beer 2.40 350\nWater 1.25 200\nIceTea 5.20 100\nBeer 1.20 200\nIceTea 0.50 120\nbuy\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Orders.main(new String[]{});

        String expectedOutput = "Beer -> 660.00\nWater -> 250.00\nIceTea -> 110.00\n";
//        Assertions.assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    void testCaseSensitivity() {
        String input = "CesarSalad 10.20 25\nSuperEnergy 0.80 400\nBeer 1.35 350\nIceCream 1.50 25\nbuy\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Orders.main(new String[]{});

        String expectedOutput = "CesarSalad -> 255.00\nSuperEnergy -> 320.00\nBeer -> 472.50\nIceCream -> 37.50\n";
//        Assertions.assertEquals(expectedOutput, out.toString());
        assertOutputEquals(expectedOutput, out.toString());
    }

    @Test
    void testEmptyInput() {
        String input = "buy\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Orders.main(new String[]{});

//        Assertions.assertEquals("", out.toString());
        assertOutputEquals("", out.toString());
    }

    public static void assertOutputEquals(String expectedOutput, String actualOutput) {
        String normalizedExpected = expectedOutput.replaceAll("\\r\\n", "\n").trim();
        String normalizedActual = actualOutput.replaceAll("\\r\\n", "\n").trim();
        assertEquals(normalizedExpected, normalizedActual);
    }

}
