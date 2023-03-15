package Lists;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class CardsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> firstPlayer = new ArrayDeque<>();
        Deque<Integer> secondPlayer = new ArrayDeque<>();

        int[] firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int card : firstPlayerCards) {
            firstPlayer.offer(card);
        }

        for (int card : secondPlayerCards) {
            secondPlayer.offer(card);
        }

        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            int firstPlayerCard = firstPlayer.poll();
            int secondPlayerCard = secondPlayer.poll();

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayer.offer(firstPlayerCard);
                firstPlayer.offer(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayer.offer(secondPlayerCard);
                secondPlayer.offer(firstPlayerCard);
            }
        }

        String winner = firstPlayer.isEmpty() ? "Second" : "First";
        int sum = 0;

        if (winner.equals("First")) {
            sum = firstPlayer.stream().mapToInt(Integer::intValue).sum();
        } else {
            sum = secondPlayer.stream().mapToInt(Integer::intValue).sum();
        }

        System.out.println(winner + " player wins! Sum: " + sum);
    }
}

