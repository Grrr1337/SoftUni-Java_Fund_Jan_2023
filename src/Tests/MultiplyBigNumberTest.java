package Tests;
import TextProcessing.MultiplyBigNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyBigNumberTest {
    @Test
    void test1() {
        String first = "23";
        int second = 2;
        String expected = "46";
        String actual = MultiplyBigNumber.multiply(first, second);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        String first = "9999";
        int second = 9;
        String expected = "89991";
        String actual = MultiplyBigNumber.multiply(first, second);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        String first = "9238472389319831924628321024";
        int second = 1;
        String expected = "9238472389319831924628321024";
        String actual = MultiplyBigNumber.multiply(first, second);
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        String first = "123456789012345678901234567890";
        int second = 9;
        String expected = "111111110111111110111111110111111110111111110111111110111111110111111110";
        String actual = MultiplyBigNumber.multiply(first, second);
        assertEquals(expected, actual);
    }
}
