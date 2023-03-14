package BasicSyntax;

import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the valid coins, products, and their prices using a TreeMap
        TreeMap<Double, String> validCoins = new TreeMap<>();
        validCoins.put(0.1, "ten cents");
        validCoins.put(0.2, "twenty cents");
        validCoins.put(0.5, "fifty cents");
        validCoins.put(1.0, "one");
        validCoins.put(2.0, "two");

        TreeMap<String, Double> validProducts = new TreeMap<>();
        validProducts.put("Nuts", 2.0);
        validProducts.put("Water", 0.7);
        validProducts.put("Crisps", 1.5);
        validProducts.put("Soda", 0.8);
        validProducts.put("Coke", 1.0);

        // Prompt user to insert coins
        double totalMoney = 0;
        String input = scanner.nextLine();
        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);
            if (validCoins.containsKey(coin)) {
                totalMoney += coin;
            } else {
                System.out.printf("Cannot accept %.2f\n", coin);
            }
            input = scanner.nextLine();
        }

        // Prompt user to select products
        input = scanner.nextLine();
        while (!input.equals("End")) {
            if (validProducts.containsKey(input)) {
                double productPrice = validProducts.get(input);
                if (productPrice > totalMoney) {
                    System.out.println("Sorry, not enough money");
                } else {
                    totalMoney -= productPrice;
                    System.out.printf("Purchased %s\n", input);
                }
            } else {
                System.out.println("Invalid product");
            }
            input = scanner.nextLine();
        }

        // Output the remaining change
        System.out.printf("Change: %.2f\n", totalMoney);

        scanner.close();
    }
}
