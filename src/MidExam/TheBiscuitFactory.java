package MidExam;

import java.util.*;

public class TheBiscuitFactory {

    private static boolean isWithinRange(double number, double[] range) {
        double min = range[0];
        double max = range[1];
        return (number >= min && number <= max);
    }

    public static boolean isDoubleAnInteger(double d) {
        try {
            return ((int) d) == d;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] inputs = new double[3];

        double biscuitsPerDay = Double.parseDouble(scanner.nextLine());
        double workersCount = Double.parseDouble(scanner.nextLine());
        double competitorBiscuits = Double.parseDouble(scanner.nextLine());


        inputs[0] = biscuitsPerDay;
        inputs[1] = workersCount;
        inputs[2] = competitorBiscuits;

        double[][] inputRanges = {
                {1.0, 200.0}, // biscuitsPerDay range
                {1.0, 1000.0}, // workersCount range
                {1.0, 500000.0} // competitorBiscuits range
        };

        for (int i = 0; i < inputRanges.length; i++) {
            double[] range = inputRanges[i];
            double inputValue = inputs[i];
            if (!isWithinRange(inputValue, range)) {
//                System.out.printf("Input value %.0f is out of range [%.0f, %.0f]\n", inputValue, range[0], range[1]);
//                return;
                continue;
            }
            if (!isDoubleAnInteger(inputValue))
            {
//                System.out.printf("Input value %.0f is not an integer\n", inputValue);
//                return;
                continue;
            }
        }


        double production = 0;
        double biscuitsPerDayTotal = 0;

        for (int i = 1; i <= 30; i++) {
            double biscuitsPerWorker = biscuitsPerDay;
            if (i % 3 == 0) {
                biscuitsPerWorker = 0.75 * biscuitsPerDay;
            }
            biscuitsPerDayTotal += biscuitsPerWorker;
//            production += Math.floor(biscuitsPerWorker) * workersCount;
//            production += biscuitsPerDayTotal;
        }
//        System.out.println(biscuitsPerDayTotal);
        production += biscuitsPerDayTotal * workersCount;

        double diff = production - competitorBiscuits;
        double percentage = (diff / competitorBiscuits) * 100;

        List<String> output = new ArrayList<>();
        output.add(String.format("You have produced %.0f biscuits for the past month.", production));
        if (diff > 0) {
            output.add(String.format("You produce %.2f percent more biscuits.", percentage));
        } else {
            output.add(String.format("You produce %.2f percent less biscuits.", Math.abs(percentage)));
        }
        System.out.println(String.join("\n", output));
    }
}

