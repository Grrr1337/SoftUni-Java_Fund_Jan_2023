package DataTypesAndVariables;

import java.util.Scanner;

public class PrintPartOfTheASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startIndex = scanner.nextInt();
        int endIndex = scanner.nextInt();

        for (int i = startIndex; i <= endIndex; i++) {
            char c = (char) i;
            System.out.print(c + " ");
        }
    }
}
