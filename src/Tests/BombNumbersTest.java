package Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import Lists.BombNumbers;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class BombNumbersTest {
    @Test
    public void testDetonate1() {
        int[] sequence = {1, 2, 2, 4, 2, 2, 2, 9};
        int[] bombInfo = {4, 2};
        int expectedSum = 12;
        List<Integer> remainingNumbers = BombNumbers.detonate(sequence, bombInfo);
        int actualSum = remainingNumbers.stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testDetonate2() {
        int[] sequence = {1, 4, 4, 2, 8, 9, 1};
        int[] bombInfo = {9, 3};
        int expectedSum = 5;
        List<Integer> remainingNumbers = BombNumbers.detonate(sequence, bombInfo);
        int actualSum = remainingNumbers.stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testDetonate3() {
        int[] sequence = {1, 7, 7, 1, 2, 3};
        int[] bombInfo = {7, 1};
        int expectedSum = 6;
        List<Integer> remainingNumbers = BombNumbers.detonate(sequence, bombInfo);
        int actualSum = remainingNumbers.stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testDetonate4() {
        int[] sequence = {1, 1, 2, 1, 1, 1, 2, 1, 1, 1};
        int[] bombInfo = {2, 1};
        int expectedSum = 4;
        List<Integer> remainingNumbers = BombNumbers.detonate(sequence, bombInfo);
        int actualSum = remainingNumbers.stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedSum, actualSum);
    }

}
