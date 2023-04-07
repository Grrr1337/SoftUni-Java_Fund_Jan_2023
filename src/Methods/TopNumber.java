package Methods;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopNumber {

    public static List<Integer> findTopNumbers(int n) {
        List<Integer> topNumbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            // check if i has at least one odd digit
            boolean hasOddDigit = false;
            int sumOfDigits = 0;
            int num = i;

            while (num > 0) {
                int digit = num % 10;
                if (digit % 2 != 0) {
                    hasOddDigit = true;
                }
                sumOfDigits += digit;
                num /= 10;
            }

            if (hasOddDigit && sumOfDigits % 8 == 0) {
                topNumbers.add(i);
            }
        }

        return topNumbers;
    }

    public static void main(String[] args) {
//        int n = 100;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> topNumbers = findTopNumbers(n);

//        System.out.println("Top numbers up to " + n + ": ");
        for (int i : topNumbers) {
            System.out.println(i);
        }
    }
}

