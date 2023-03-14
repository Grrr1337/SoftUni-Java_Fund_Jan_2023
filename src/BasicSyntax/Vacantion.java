package BasicSyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vacantion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        Map<String, Map<String, Double>> prices = new HashMap<>();
        prices.put("Students", new HashMap<String, Double>());
        prices.put("Business", new HashMap<String, Double>());
        prices.put("Regular", new HashMap<String, Double>());
        prices.get("Students").put("Friday", 8.45);
        prices.get("Students").put("Saturday", 9.80);
        prices.get("Students").put("Sunday", 10.46);
        prices.get("Business").put("Friday", 10.90);
        prices.get("Business").put("Saturday", 15.60);
        prices.get("Business").put("Sunday", 16.00);
        prices.get("Regular").put("Friday", 15.00);
        prices.get("Regular").put("Saturday", 20.00);
        prices.get("Regular").put("Sunday", 22.50);

        // Read in the number of people in the group
//        System.out.print("Enter the number of people in the group: ");
        int groupSize = input.nextInt();

        // Read in the type of the group
//        System.out.print("Enter the type of the group (Students, Business, Regular): ");
        String groupType = input.next();

        // Read in the day of the week
//        System.out.print("Enter the day of the week (Friday, Saturday, Sunday): ");
        String dayOfWeek = input.next();

        input.close();

        // Calculate the base price for the group
        double pricePerPerson = prices.get(groupType).get(dayOfWeek);
        double basePrice = groupSize * pricePerPerson;

        // Apply the discounts in the correct order
        if (groupType.equals("Students") && groupSize >= 30) {
            basePrice *= 0.85;
        }
        if (groupType.equals("Business") && groupSize >= 100) {
            basePrice -= 10 * pricePerPerson;
        }
        if (groupType.equals("Regular") && groupSize >= 10 && groupSize <= 20) {
            basePrice *= 0.95;
        }

        // Print the total price, formatted to two decimal places
        System.out.printf("Total price: %.2f", basePrice);
    }
}
