package BasicSyntax;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        scn.close();

        int sum = 0;
        int n = number;
        while (n != 0) {
            int digit = n % 10;
            sum += factorial(digit);
            n /= 10;
        }

        if (sum == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
