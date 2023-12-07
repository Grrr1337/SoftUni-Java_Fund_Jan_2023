package Tests;

import TextProcessing.CaesarCipher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CaesarCipherTest {

    @Test
    void Test1() {
        String message = "Programming is cool!";
        String expected = "Surjudpplqj#lv#frro$";
        String actual = CaesarCipher.encrypt(message);
        assertEquals(expected, actual);
    }

    @Test
    void Test2() {
        String message = "One year has 365 days.";
        String expected = "Rqh#|hdu#kdv#698#gd|v1";
        String actual = CaesarCipher.encrypt(message);
        assertEquals(expected, actual);
    }
}
