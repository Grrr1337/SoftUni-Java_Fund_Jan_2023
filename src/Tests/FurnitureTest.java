package Tests;

import RegularExpressions.Furniture;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FurnitureTest {

    @Test
    public void testCalculate() {
        String input = ">>Sofa<<312.23!3\n>>TV<<300!5\n>Invalid<<!5\nPurchase\n";
        String expectedOutput = "Bought furniture:\n" +
                "Sofa\n" +
                "TV\n" +
                "Total money spend: 2436.69";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Furniture.main(new String[] {});

        assertEquals(expectedOutput, out.toString().trim());
    }
}
