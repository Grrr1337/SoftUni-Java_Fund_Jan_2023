package Tests;
import Lists.AnonymousThreat;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnonymousThreatTest {
    @Test
    void testMerge() {
        List<String> data = new ArrayList<>(Arrays.asList("abc", "def", "ghi"));
        AnonymousThreat.merge(data, 0, 1);
        Assertions.assertEquals(Arrays.asList("abcdef", "ghi"), data);

        data = new ArrayList<>(Arrays.asList("abc", "def", "ghi"));
        AnonymousThreat.merge(data, 1, 2);
        Assertions.assertEquals(Arrays.asList("abc", "defghi"), data);

        data = new ArrayList<>(Arrays.asList("abc", "def", "ghi"));
        AnonymousThreat.merge(data, 0, 2);
        Assertions.assertEquals(Arrays.asList("abcdefghi"), data);
    }

    @Test
    public void testDivide1() {

        List<String> data = new ArrayList<>(Arrays.asList("abcdef", "ghi", "jkl"));
        List<String> expected = new ArrayList<>(Arrays.asList("ab", "cd", "ef", "ghi", "jkl"));
        AnonymousThreat.divide(data, 0, 3);
        Assertions.assertEquals(expected, data);

    }

    @Test
    public void testDivide2() {
        List<String> data = new ArrayList<>(Arrays.asList("abcd", "efgh", "ijkl"));
        List<String> expected = new ArrayList<>(Arrays.asList("a", "b", "cd", "efgh", "ijkl"));
        AnonymousThreat.divide(data, 0, 3);
        Assertions.assertEquals(expected, data);
    }

    // org.opentest4j.AssertionFailedError:
    // Expected :[ab, cd, ef, gh, ij, klmno, pqr]
    // Actual   :[abc, def, ghi, , , , , , , jklmno, pqr]
    @Test
    public void testDivide3() {
        List<String> data = new ArrayList<>(Arrays.asList("abc", "def", "ghi", "jklmno", "pqr"));
        List<String> expected = new ArrayList<>(Arrays.asList("ab", "cd", "ef", "gh", "ij", "klmno", "pqr"));
        AnonymousThreat.divide(data, 3, 7);
        Assertions.assertEquals(expected, data);
    }


    @Test
    public void testDivide4() {
        List<String> data = new ArrayList<>(Arrays.asList("abc", "def", "ghi", "jklmno", "pqr"));
        List<String> expected = new ArrayList<>(Arrays.asList("abc", "def", "ghi", "jklmno", "pqr"));
        AnonymousThreat.divide(data, 0, 0);
        Assertions.assertEquals(expected, data);
    }

    @Test
    public void testDivide5() {
        List<String> data = new ArrayList<>(Arrays.asList("abc", "def", "ghi", "jklmno", "pqr"));
        List<String> expected = new ArrayList<>(Arrays.asList("abc", "def", "ghi", "jklmno", "pqr"));
        AnonymousThreat.divide(data, 4, 0);
        Assertions.assertEquals(expected, data);
    }

}