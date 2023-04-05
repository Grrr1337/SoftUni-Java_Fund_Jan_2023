package DataTypesAndVariables;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();

        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

//        System.out.println("Sum of digits: " + sum);
        System.out.println(sum);
        scanner.close();
    }
}
