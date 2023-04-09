package Methods;
import java.util.Scanner;

public class CharactersInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the starting character: ");
        char start = scanner.next().charAt(0);

        System.out.print("Enter the ending character: ");
        char end = scanner.next().charAt(0);

        System.out.print("Characters in range: ");
        printCharsInRange(start, end);
    }

    public static void printCharsInRange(char start, char end) {
        // Ensure start is smaller than end
        if (start > end) {
            char temp = start;
            start = end;
            end = temp;
        }

        for (char ch = (char) (start + 1); ch < end; ch++) {
            System.out.print(ch + " ");
        }
    }
}
