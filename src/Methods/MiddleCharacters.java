package Methods;
import java.util.Scanner;

public class MiddleCharacters {
    public static void printMiddleCharacter(String str) {
        int midIndex = str.length() / 2;
        if (str.length() % 2 == 0) {
            System.out.print(str.charAt(midIndex - 1));
        }
        System.out.println(str.charAt(midIndex));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        printMiddleCharacter(str);
    }

}
