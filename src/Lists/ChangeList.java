package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = readIntegerList(scanner);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int element;
            int position;

            switch (command) {
                case "Delete":
                    element = Integer.parseInt(tokens[1]);
                    deleteElement(numbers, element);
                    break;
                case "Insert":
                    element = Integer.parseInt(tokens[1]);
                    position = Integer.parseInt(tokens[2]);
                    insertElement(numbers, element, position);
                    break;
            }

            input = scanner.nextLine();
        }

        printIntegerList(numbers);
    }

    private static List<Integer> readIntegerList(Scanner scanner) {
        String[] tokens = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            int number = Integer.parseInt(token);
            numbers.add(number);
        }

        return numbers;
    }

    private static void deleteElement(List<Integer> numbers, int element) {
        numbers.removeIf(e -> e == element);
    }

    private static void insertElement(List<Integer> numbers, int element, int position) {
        numbers.add(position, element);
    }

    private static void printIntegerList(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}

