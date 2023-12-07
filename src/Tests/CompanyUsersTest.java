package Tests;

import AssociativeArrays.CompanyUsers;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyUsersTest {
    @Test
    public void testSingleCompanySingleEmployee() {
        String input = "SoftUni -> AA12345\nEnd\n";
        String expectedOutput = "SoftUni\n" +
                "-- AA12345\n";

        assertInputOutput(input, expectedOutput);
//        assertOutputEquals(input, expectedOutput);
    }


    @Test
    public void testSingleCompanyMultipleEmployees() {
        String input = "SoftUni -> AA12345\nSoftUni -> BB12345\nEnd\n";
        String expectedOutput = "SoftUni\n" +
                "-- AA12345\n" +
                "-- BB12345\n";

        assertInputOutput(input, expectedOutput);
//        assertOutputEquals(input, expectedOutput);
    }

    @Test
    public void testMultipleCompaniesSingleEmployee() {
        String input = "SoftUni -> AA12345\nMicrosoft -> BB12345\nEnd\n";
        String expectedOutput = "SoftUni\n" +
                "-- AA12345\n" +
                "Microsoft\n" +
                "-- BB12345\n";

        assertInputOutput(input, expectedOutput);
//        assertOutputEquals(input, expectedOutput);
    }

    @Test
    public void testMultipleCompaniesMultipleEmployees() {
        String input = "SoftUni -> AA12345\nMicrosoft -> BB12345\nSoftUni -> CC12345\nEnd\n";
        String expectedOutput = "SoftUni\n" +
                "-- AA12345\n" +
                "-- CC12345\n" +
                "Microsoft\n" +
                "-- BB12345\n";

        assertInputOutput(input, expectedOutput);
//        assertOutputEquals(input, expectedOutput);
    }

    @Test
    public void testDuplicateEmployeeIds() {
        String input = "SoftUni -> AA12345\nSoftUni -> AA12345\nEnd\n";
        String expectedOutput = "SoftUni\n" +
                "-- AA12345\n";

        assertInputOutput(input, expectedOutput);
//        assertOutputEquals(input, expectedOutput);
    }

    private void assertInputOutput(String input, String expectedOutput) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        CompanyUsers.main(new String[]{});

//        assertEquals(expectedOutput, outputStream.toString());
        assertOutputEquals(expectedOutput, outputStream.toString());
    }


    public static void assertOutputEquals(String expectedOutput, String actualOutput) {
        String normalizedExpected = expectedOutput.replaceAll("\\r\\n", "\n").trim();
        String normalizedActual = actualOutput.replaceAll("\\r\\n", "\n").trim();
        assertEquals(normalizedExpected, normalizedActual);
    }

}
