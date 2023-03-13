package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double[]> products = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("buy")) {
                break;
            }

            String[] tokens = input.split("\\s+");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            products.putIfAbsent(product, new Double[]{0.0, 0.0});
            Double[] values = products.get(product);
            values[0] += quantity;
            if (price != values[1]) {
                values[1] = price;
            }
        }

        products.forEach((product, values) -> {
            double totalPrice = values[0] * values[1];
            System.out.printf("%s -> %.2f%n", product, totalPrice);
        });
    }
}


