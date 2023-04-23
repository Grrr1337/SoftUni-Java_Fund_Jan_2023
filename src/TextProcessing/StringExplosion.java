package TextProcessing;


import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        int strength = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '>') {
                sb.append(currentChar);
                strength += Character.getNumericValue(input.charAt(i + 1));
                continue;
            }

            if (strength > 0) {
                strength--;
            } else {
                sb.append(currentChar);
            }
        }

        System.out.println(sb.toString());
    }
}
