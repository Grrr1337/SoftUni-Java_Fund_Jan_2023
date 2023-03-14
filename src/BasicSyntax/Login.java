package BasicSyntax;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = new StringBuilder(username).reverse().toString();
        int count = 0;
        while (true) {
            String input = scanner.nextLine();
            count++;
            if (count == 4) {
                System.out.printf("User %s blocked!%n", username);
                break;
            }
            if (input.equals(password)) {
                System.out.printf("User %s logged in.%n", username);
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
            }
        }
    }

}
