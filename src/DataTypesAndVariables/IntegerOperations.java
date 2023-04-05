package DataTypesAndVariables;

import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = new int[4];

        for (int i = 0; i < nums.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter number " + (i+1) + ": ");
                if (scanner.hasNextInt()) {
                    nums[i] = scanner.nextInt();
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter an integer value.");
                    scanner.next(); // clear the scanner buffer
                }
            }
        }

        int sum = nums[0] + nums[1];
        int division = sum / nums[2];
        int multiplication = division * nums[3];

        System.out.println("Result: " + multiplication);
//        System.out.println(multiplication);
        scanner.close();
    }
}
