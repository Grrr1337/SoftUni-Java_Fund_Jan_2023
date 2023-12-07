package Tests;

import ObjectsAndClasses.Students;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class StudentsTest {

    @Test
    public void testSortStudentsByGradeDescending() {
        List<Students.Student> students = new ArrayList<>();
        students.add(new Students.Student("Lakia", "Eason", 3.90));
        students.add(new Students.Student("Prince", "Messing", 5.49));
        students.add(new Students.Student("Akiko", "Segers", 4.85));
        students.add(new Students.Student("Rocco", "Erben", 6.00));
        Students.StudentSorter.sortStudentsByGradeDescending(students);
//        assertEquals("Rocco Erben: 6.00\nPrince Messing: 5.49\nAkiko Segers: 4.85\nLakia Eason: 3.90\n", getOutput(students));

        assertOutputEquals("Rocco Erben: 6.00\nPrince Messing: 5.49\nAkiko Segers: 4.85\nLakia Eason: 3.90\n", getOutput(students));

        students.clear();
        students.add(new Students.Student("Sydnie", "Britton", 5.79));
        students.add(new Students.Student("Amias", "Mathews", 2.30));
        students.add(new Students.Student("Mora", "Tod", 2.78));
        students.add(new Students.Student("Pete", "Kendrick", 2.61));
        Students.StudentSorter.sortStudentsByGradeDescending(students);
//        assertEquals("Sydnie Britton: 5.79\nMora Tod: 2.78\nPete Kendrick: 2.61\nAmias Mathews: 2.30\n", getOutput(students));
        assertOutputEquals("Sydnie Britton: 5.79\nMora Tod: 2.78\nPete Kendrick: 2.61\nAmias Mathews: 2.30\n", getOutput(students));
    }

    private String getOutput(List<Students.Student> students) {
        StringBuilder sb = new StringBuilder();
        for (Students.Student student : students) {
            sb.append(student.toString()).append("\n");
        }
        return sb.toString();
    }

    public static void assertOutputEquals(String expectedOutput, String actualOutput) {
        String normalizedExpected = expectedOutput.replaceAll("\\r\\n", "\n").trim();
        String normalizedActual = actualOutput.replaceAll("\\r\\n", "\n").trim();
        assertEquals(normalizedExpected, normalizedActual);
    }
}

