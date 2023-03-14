package BasicSyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PadawanEquipment {
    private static boolean isWithinRange(double number, double[] range) {
        double min = range[0];
        double max = range[1];
        return (number >= min && number <= max);
    }
    private static boolean isWithinRange(int number, double[] range) {
        int min = (int) range[0];
        int max = (int) range[1];
        return (number >= min && number <= max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Object> inputData = new ArrayList<>();

        // read input data
        double budget = Double.parseDouble(scanner.nextLine());
        inputData.add(budget);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        inputData.add(studentsCount);
        double lightsaberPrice = Double.parseDouble(scanner.nextLine());
        inputData.add(lightsaberPrice);
        double robePrice = Double.parseDouble(scanner.nextLine());
        inputData.add(robePrice);
        double beltPrice = Double.parseDouble(scanner.nextLine());
        inputData.add(beltPrice);

        // validate input data
        double[][] ranges = {{0, 1000}, {0, 100}, {0, 100}, {0, 100}, {0, 100}};
        String[] outputMessages = {"Budget must be in the range [0.00...1,000.00].",
                "Students count must be in the range [0...100].",
                "Lightsaber price must be in the range [0.00...100.00].",
                "Robe price must be in the range [0.00...100.00].",
                "Belt price must be in the range [0.00...100.00]."};


        for (int i = 0; i < ranges.length; i++) {
            if (inputData.get(i) instanceof Double) {
                if (!isWithinRange((double)inputData.get(i), ranges[i])) {
                    System.out.println("Invalid input data. " + outputMessages[i]);
                    return;
                }
            } else if (inputData.get(i) instanceof Integer) {
                if (!isWithinRange((int)inputData.get(i), ranges[i])) {
                    System.out.println("Invalid input data. " + outputMessages[i]);
                    return;
                }
            }
        }

        // calculate the cost of the equipment
        int freeBeltsCount = (int) (studentsCount / 6);
        double sabersCount = Math.ceil(studentsCount * 1.1);
        double totalCost = sabersCount * lightsaberPrice + studentsCount * robePrice
                + (studentsCount - freeBeltsCount) * beltPrice;

        // output the result
        if (budget >= totalCost) {
            System.out.printf("The money is enough - it would cost %.2flv.%n", totalCost);
        } else {
            double neededMoney = totalCost - budget;
            System.out.printf("George Lucas will need %.2flv more.%n", neededMoney);
        }
    }
}
