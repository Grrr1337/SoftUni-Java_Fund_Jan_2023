package TextProcessing;

import java.util.Scanner;

public class CharacterMultiplier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter two strings separated by space: ");
        String str1 = scanner.next();
        String str2 = scanner.next();
        int result = multiply(str1, str2);
        System.out.println(result);
    }

    public static int multiply(String str1, String str2) {
        int sum = 0;
        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            sum += str1.charAt(i) * str2.charAt(i);
        }

        if (len1 > len2) {
            sum += sumRemainingChars(str1, minLen);
        } else if (len2 > len1) {
            sum += sumRemainingChars(str2, minLen);
        }

        return sum;
    }

    private static int sumRemainingChars(String str, int start) {
        int sum = 0;
        for (int i = start; i < str.length(); i++) {
            sum += str.charAt(i);
        }
        return sum;
    }
}
