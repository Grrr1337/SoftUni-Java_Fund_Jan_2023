package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] bombInfo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> remainingNumbers = detonate(sequence, bombInfo);

        int sum = remainingNumbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

    public static List<Integer> detonate(int[] sequence, int[] bombInfo) {
        int bombNumber = bombInfo[0];
        int power = bombInfo[1];

        List<Integer> remainingNumbers = new ArrayList<>();

        for (int i = 0; i < sequence.length; i++) {
            int currentNumber = sequence[i];

            if (currentNumber == bombNumber) {
                int startIndex = Math.max(0, i - power);
                int endIndex = Math.min(sequence.length - 1, i + power);

                for (int j = startIndex; j <= endIndex; j++) {
                    sequence[j] = 0;
                }
            }
        }

        for (int number : sequence) {
            if (number != 0) {
                remainingNumbers.add(number);
            }
        }

        return remainingNumbers;
    }
}
