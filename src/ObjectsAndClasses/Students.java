package ObjectsAndClasses;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Students {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String firstName = scanner.next();
            String lastName = scanner.next();
            double grade = scanner.nextDouble();
            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }
        StudentSorter.sortStudentsByGradeDescending(students);
        for (Student student : students) {
            System.out.println(student);
        }
        scanner.close();
    }


    public static class StudentSorter {
        public static void sortStudentsByGradeDescending(List<Student> students) {
            Comparator<Student> byGradeDescending = Comparator.comparingDouble(Student::getGrade).reversed();
            Collections.sort(students, byGradeDescending);
        }
    }

    public static class Student {
        private String firstName;
        private String lastName;
        private double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;
        }

        public String toString() {
            return firstName + " " + lastName + ": " + String.format("%.2f", grade);
        }
    }


}
