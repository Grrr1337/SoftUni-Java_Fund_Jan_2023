package Tests;

import Lists.PokemonDontGo;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonDontGoTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMain() {
        String input = "5 10 6 3 5\n2\n4\n1\n1\n3\n0\n0\n";
        String expectedOutput = "51\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        PokemonDontGo.main(null);
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void testExample1() {
        // Simulate user input "4 5 3\n1\n1\n0\n"
        String input = "4 5 3\n1\n1\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PokemonDontGo.main(new String[]{});

        // Check the output
        assertEquals("14\n", outContent.toString());
    }

    @Test
    public void testExample2() {
        // Simulate user input "5 10 6 3 5\n2\n4\n1\n1\n3\n0\n0\n"
        String input = "5 10 6 3 5\n2\n4\n1\n1\n3\n0\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PokemonDontGo.main(new String[]{});

        // Check the output
        assertEquals("51\n", outContent.toString());
    }

    @Test
    public void testNoInput() {
        // Simulate user input ""
        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PokemonDontGo.main(new String[]{});

        // Check the output
        assertEquals("0\n", outContent.toString());
    }

    @Test
    public void testNegativeIndex() {
        // Simulate user input "1 2 3\n-1\n0\n"
        String input = "1 2 3\n-1\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PokemonDontGo.main(new String[]{});

        // Check the output
        assertEquals("9\n", outContent.toString());
    }

    @Test
    public void testLargeIndex() {
        // Simulate user input "1 2 3\n5\n0\n"
        String input = "1 2 3\n5\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PokemonDontGo.main(new String[]{});

        // Check the output
        assertEquals("6\n", outContent.toString());
    }

    @Test
    public void testSinglePokemon() {
        // Simulate user input "1\n0\n"
        String input = "1\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PokemonDontGo.main(new String[]{});

        // Check the output
        assertEquals("1\n", outContent.toString());
    }

    @Test
    public void testTwoPokemons() {
        // Simulate user input "1 2\n0\n0\n"
        String input = "1 2\n0\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        PokemonDontGo.main(new String[]{});

        // Check the output
        assertEquals("3\n", outContent.toString());
    }
}
