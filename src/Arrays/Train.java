package Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sum = 0;

        int[] wagons = new int[n];
        for (int i = 0; i < n; i++) {
            wagons[i] = scn.nextInt();
            sum += wagons[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(wagons[i] + " ");
        }
        System.out.println("\n" + sum);
    }
}
