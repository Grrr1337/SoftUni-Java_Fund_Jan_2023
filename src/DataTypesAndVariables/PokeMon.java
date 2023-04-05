package DataTypesAndVariables;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());

        int originalN = n;
        int targetsPoked = 0;

        while (n >= m) {
            n -= m;
            targetsPoked++;

            if (n == originalN / 2.0) {
                if (y != 0) {
                    n /= y;
                }
            }
        }

        System.out.println(n);
        System.out.println(targetsPoked);
    }

//    private static boolean isWithinRange(int number, int[] range) {
//        double min = range[0];
//        double max = range[1];
//        return (number >= min && number <= max);
//    }
}

