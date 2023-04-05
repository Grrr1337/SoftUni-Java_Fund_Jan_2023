package DataTypesAndVariables;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int charTimes = Integer.parseInt(scanner.nextLine());
        int total = 0;
        for (int i = 1; i <= charTimes; i++) {
            char currentChar = scanner.nextLine().charAt(0);
            total += currentChar;
        }
        System.out.printf("The sum equals: %d", total);
    }
}

/*
public class SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean toReturn = false;
        int n = scanner.nextInt();
        if (n < 1 || n > 20) {
//            System.out.println("n must be in the interval [1, 20]");
            return;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            char ch = scanner.next().charAt(0);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                sum += ch;
            } else {
                ch = 0;
                toReturn = true;
            }
        }
//        if (toReturn == true) { return;  }
        System.out.println("The sum equals: " + sum);
    }
}
*/