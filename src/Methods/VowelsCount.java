package Methods;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = input.nextLine();

        int vowelsCount = countVowels(str);
        System.out.println("The number of vowels in the string is: " + vowelsCount);
        System.out.println(vowelsCount);
        input.close();
    }

    public static int countVowels(String str) {
        int count = 0;
        String vowels = "AEIOU";
        char[] vowelChars = vowels.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toUpperCase(str.charAt(i));
            if (new String(vowelChars).contains(String.valueOf(ch))) {
                count++;
            }
        }
        return count;
    }

}

