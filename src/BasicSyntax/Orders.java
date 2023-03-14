package BasicSyntax;
import java.util.Scanner;

public class Orders {

    private static boolean isWithinRange(int num, int[] range) {
        return num >= range[0] && num <= range[1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0;

        for (int i = 0; i < n; i++) {
            double pricePerCapsule = scanner.nextDouble();
            int days = scanner.nextInt();
            int capsulesCount = scanner.nextInt();

            if (!isWithinRange(days, new int[]{1, 31}) || !isWithinRange(capsulesCount, new int[]{0, 7000000})) {
                System.out.println("Invalid input!");
                continue;
            }

            double orderPrice = (days * capsulesCount) * pricePerCapsule;
            System.out.printf("The price for the coffee is: $%.2f%n", orderPrice);
            totalPrice += orderPrice;
        }

        System.out.printf("Total: $%.2f%n", totalPrice);
    }

}
