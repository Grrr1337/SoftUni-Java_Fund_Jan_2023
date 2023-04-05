package DataTypesAndVariables;
import java.util.Scanner;


public class WaterOverflow {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int capacity = 255;
        int total = 0;

        for (int i = 1; i <= n; i++) {
            int pouredLiters = Integer.parseInt(s.nextLine());
            total += pouredLiters;
            if (total > capacity){
                System.out.println("Insufficient capacity!");
                total -= pouredLiters;
            }
            if (i == n) {
                System.out.println(total);
            }
        }
    }
}

