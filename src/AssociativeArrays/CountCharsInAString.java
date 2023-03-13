package AssociativeArrays;

import java.util.Scanner;
import java.util.stream.Collectors;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        scanner.close();

        System.out.println(countChars(input));
    }

    public static String countChars(String input) {
        return input.chars()
                .filter(c -> c != ' ')
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .map(entry -> entry.getKey() + " -> " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}
