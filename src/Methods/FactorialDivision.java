package Methods;

import java.util.Scanner;


public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f", (factorial(firstNum) / factorial(secondNum)));
    }

    public static double factorial(int num){
        double sum = 1;
        for (int i = num; i >= 1; i--) {
            sum *= i;
        }
        return sum;
    }
}
