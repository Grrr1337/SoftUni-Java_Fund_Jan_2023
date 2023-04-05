package DataTypesAndVariables;

import java.util.Scanner;

public class BeerKegs {

    private static boolean isWithinRange(int number, int[] range) {
        double min = range[0];
        double max = range[1];
        return (number >= min && number <= max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        if (!isWithinRange(n, new int[]{1, 10})) {
            return;
        }

        String maxKegModel = "";
        double maxVolume = 0;

        for (int i = 0; i < n; i++) {
            String kegModel = scanner.nextLine();
            double kegRadius = Double.parseDouble(scanner.nextLine());
            int kegHeight = Integer.parseInt(scanner.nextLine());

            double kegVolume = Math.PI * Math.pow(kegRadius, 2) * kegHeight;

            if (kegVolume > maxVolume) {
                maxVolume = kegVolume;
                maxKegModel = kegModel;
            }
        }

        System.out.println(maxKegModel);
    }
}


