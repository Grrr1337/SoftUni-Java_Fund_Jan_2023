package TextProcessing;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(encrypt(input));
    }
    public static String encrypt(String message) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char current = (char) (message.charAt(i) + 3);
            sb.append(current);
        }
        return sb.toString();
    }
}



