package TextProcessing;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        int second = scanner.nextInt();
        System.out.println(multiply(first, second));

    }

    public static String multiply(String first, int second) {
        StringBuilder sb = new StringBuilder();
        int remain = 0;
        for (int i = first.length() - 1; i >= 0; i--) {
            int digit = first.charAt(i) - '0';
            int current = digit * second + remain;
            sb.append((char) ('0' + (current % 10)));
            remain = current / 10;
        }
        if (remain != 0) {
            sb.append((char) ('0' + remain));
        }
        int i = sb.length() - 1;
        while (i > 0 && sb.charAt(i) == '0') {
            i--;
        }
        sb.setLength(i + 1);
        return (sb.reverse().toString());
    }
}
