package Tests;

import Lists.SUCoursePlanning;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


public class SUCoursePlanningTest {

    @Test
    public void testScenario1() {
        String input = "Data Types, Objects, Lists\nAdd:Databases\nInsert:Arrays:0\nRemove:Lists\ncourse start\n";
        String expectedOutput = "1.Arrays\n2.Data Types\n3.Objects\n4.Databases\n";
        Assertions.assertEquals(expectedOutput, runTest(input));
    }

    //    Expected:
    // 1.Methods
    //2.Databases
    //3.Databases-Exercise
    //4.Arrays
    //5.Lists

    //    Actual:
    // 1.Methods
    //2.Databases
    //3.Arrays
    //4.Lists
    //5.Databases-Exercise
    @Test
    public void testScenario2() {
        String input = "Arrays, Lists, Methods\nSwap:Arrays:Methods\nExercise:Databases\nSwap:Lists:Databases\nInsert:Arrays:0\ncourse start\n";
        String expectedOutput = "1.Methods\n2.Databases\n3.Databases-Exercise\n4.Arrays\n5.Lists\n";
        Assertions.assertEquals(expectedOutput, runTest(input));
    }

    @Test
    public void testScheduleWithAddInsertAndRemoveCommands() {
        String input = "Data Types, Objects, Lists\nAdd:Databases\nInsert:Arrays:0\nRemove:Lists\ncourse start\n";
        String expectedOutput = "1.Arrays\n2.Data Types\n3.Objects\n4.Databases\n";
        Assertions.assertEquals(expectedOutput, runTest(input));
    }

    @Test
    public void testScheduleWithSwapAndExerciseCommands() {
        String input = "Arrays, Lists, Methods\nSwap:Arrays:Methods\nExercise:Databases\nSwap:Lists:Databases\nInsert:Arrays:0\ncourse start\n";
        String expectedOutput = "1.Methods\n2.Databases\n3.Databases-Exercise\n4.Arrays\n5.Lists\n";
        Assertions.assertEquals(expectedOutput, runTest(input));
    }



    private String runTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        List<String> outputList = new ArrayList<>();
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                outputList.add(String.valueOf((char) b));
            }
        }));
        SUCoursePlanning.main(new String[]{});
        return outputList.stream().collect(Collectors.joining());
    }
}

