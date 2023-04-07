package Methods;

import java.util.Scanner;

public class NxNmatrix {
    public static void printNxNMatrix(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        printNxNMatrix(n);
        input.close();
    }
}
