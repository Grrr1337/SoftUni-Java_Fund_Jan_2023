package Methods;

import java.util.Scanner;

public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        boolean isValid = true;

        // Check password length
        if (password.length() < 6 || password.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }

        // Check password contains only letters and digits
        if (!password.matches("[a-zA-Z0-9]+")) {
            System.out.println("Password must consist only of letters and digits");
            isValid = false;
        }

        // Check password has at least 2 digits
        int digitCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digitCount++;
            }
        }
        if (digitCount < 2) {
            System.out.println("Password must have at least 2 digits");
            isValid = false;
        }

        if (isValid) {
            System.out.println("Password is valid");
        }

        return isValid;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        isValidPassword(password);


    }
}
