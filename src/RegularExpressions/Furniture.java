package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>\\d+(\\.\\d+)?)!(?<quantity>\\d+)";
        double totalSum = 0;

        StringBuilder output = new StringBuilder("Bought furniture:\n");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("Purchase")) {
                break;
            }
            Matcher matcher = Pattern.compile(regex).matcher(input);
            if (matcher.find()) {
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                output.append(furniture).append("\n");
                totalSum += price * quantity;
            }
        }
        output.append(String.format("Total money spend: %.2f", totalSum));
        System.out.println(output);
    }
}

