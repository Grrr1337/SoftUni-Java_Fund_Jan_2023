package DataTypesAndVariables;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = scanner.nextInt();
        int totalSpice = 0;
        int days = 0;

        while (startingYield >= 100) {
            int currentSpice = startingYield - 26;
            totalSpice += currentSpice;
            startingYield -= 10;
            days++;
        }

        if (totalSpice >= 26) {
            totalSpice -= 26;
        }

        System.out.println(days);
        System.out.println(totalSpice);
    }
}

