package TextProcessing;

import java.util.Scanner;

public class ReplaceRepeatingChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(replaceRepeatingChars(input));
    }

    public static String replaceRepeatingChars(String input) {
        StringBuilder output = new StringBuilder();
        char previousChar = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar != previousChar) {
                output.append(currentChar);
                previousChar = currentChar;
            }
        }
        return output.toString();
    }

}

