package TextProcessing;

import java.util.Scanner;

public class LettersChangeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.printf("%.2f", sumOfProcessedNumbers(input));
    }

    public static double sumOfProcessedNumbers(String input) {
        double sum = 0;
        String[] strings = input.split("\\s+");
        for (String string : strings) {
            char firstLetter = string.charAt(0);
            char lastLetter = string.charAt(string.length() - 1);
            int number = Integer.parseInt(string.substring(1, string.length() - 1));
            if (Character.isUpperCase(firstLetter)) {
                sum += (double) number / (firstLetter - 'A' + 1);
            } else {
                sum += (double) number * (firstLetter - 'a' + 1);
            }
            if (Character.isUpperCase(lastLetter)) {
                sum -= lastLetter - 'A' + 1;
            } else {
                sum += lastLetter - 'a' + 1;
            }
        }
        return sum;
    }
}
