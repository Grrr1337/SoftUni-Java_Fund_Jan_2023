package BasicSyntax;
import java.util.Scanner;

public class RageExpenses {
    private static boolean isWithinRange(double number, double[] range) {
        double min = range[0];
        double max = range[1];
        return (number >= min && number <= max);
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // define input data
        Double[] inputData = new Double[5];

        // read input data
        String lostGamesCountStr = scanner.nextLine();
        if (!isInteger(lostGamesCountStr)) {
            System.out.println("Invalid input: lost games count must be an integer.");
            return;
        }
        int lostGamesCount = Integer.parseInt(lostGamesCountStr);
        if (lostGamesCount < 0 || lostGamesCount > 1000) {
            System.out.println("Invalid input: lost games count must be in the range [0, 1000].");
            return;
        }
        inputData[0] = (double) lostGamesCount; // lost games count
        inputData[1] = Double.parseDouble(scanner.nextLine()); // headset price
        inputData[2] = Double.parseDouble(scanner.nextLine()); // mouse price
        inputData[3] = Double.parseDouble(scanner.nextLine()); // keyboard price
        inputData[4] = Double.parseDouble(scanner.nextLine()); // display price

        // validate input data
        double[][] ranges = {{0, 1000}, {0, 1000}, {0, 1000}, {0, 1000}, {0, 1000}};
        String[] outputMessages = {"Lost games count must be in the range [0...1000].",
                "Headset price must be in the range [0.00...1,000.00].",
                "Mouse price must be in the range [0.00...1,000.00].",
                "Keyboard price must be in the range [0.00...1,000.00].",
                "Display price must be in the range [0.00...1,000.00]."};

        for (int i = 0; i < ranges.length; i++) {
            if (!isWithinRange(inputData[i], ranges[i])) {
                System.out.println("Invalid input data. " + outputMessages[i]);
                return;
            }
        }

        // calculate the expenses
        int headsetCount = lostGamesCount / 2;
        int mouseCount = lostGamesCount / 3;
        int keyboardCount = lostGamesCount / 6;
        int displayCount = keyboardCount / 2;

        double headsetPrice = inputData[1];
        double mousePrice = inputData[2];
        double keyboardPrice = inputData[3];
        double displayPrice = inputData[4];

        double totalExpenses = headsetCount * headsetPrice
                + mouseCount * mousePrice
                + keyboardCount * keyboardPrice
                + displayCount * displayPrice;

        // output the result
        System.out.printf("Rage expenses: %.2f lv.%n", totalExpenses);
    }
}

