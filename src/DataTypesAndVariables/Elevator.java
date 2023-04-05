package DataTypesAndVariables;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Enter the number of people: ");
        int n = scanner.nextInt();

//        System.out.print("Enter the capacity of the elevator: ");
        int p = scanner.nextInt();

        int fullCourses = n / p;
        int extraCourse = n % p == 0 ? 0 : 1;
        int totalCourses = fullCourses + extraCourse;

//        System.out.println("Number of courses needed: " + totalCourses);
        System.out.println(totalCourses);
        scanner.close();
    }
}
