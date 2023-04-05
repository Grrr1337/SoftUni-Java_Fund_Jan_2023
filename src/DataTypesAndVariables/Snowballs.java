package DataTypesAndVariables;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] snowballData = new int[3];
        double bestSnowballValue = 0;
        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;

        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            snowballData[0] = snowballSnow;
            snowballData[1] = snowballTime;
            snowballData[2] = snowballQuality;

            double snowballValue = Math.pow(snowballData[0] * 1.0 / snowballData[1], snowballData[2]);

            if (snowballValue > bestSnowballValue) {
                bestSnowballValue = snowballValue;
                bestSnowballSnow = snowballSnow;
                bestSnowballTime = snowballTime;
                bestSnowballQuality = snowballQuality;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)", bestSnowballSnow, bestSnowballTime, bestSnowballValue, bestSnowballQuality);
    }
}
