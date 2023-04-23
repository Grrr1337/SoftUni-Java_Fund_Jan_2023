package TextProcessing;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter usernames separated by comma: ");
        String[] usernames = scanner.nextLine().split(", ");

        for (String username : usernames) {
            if (isValid(username)) {
                System.out.println(username);
            }
        }
    }

    public static boolean isValid(String username) {
        return username.matches("^[a-zA-Z0-9_-]{3,16}$");
    }
}
