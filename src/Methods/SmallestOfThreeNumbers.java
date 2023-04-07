package Methods;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        System.out.print("Enter the first number: ");
        int num1 = input.nextInt();

//        System.out.print("Enter the second number: ");
        int num2 = input.nextInt();

//        System.out.print("Enter the third number: ");
        int num3 = input.nextInt();

        int smallest = findSmallest(num1, num2, num3);
//        System.out.println("The smallest number is: " + smallest);
        System.out.println(smallest);
        input.close();
    }

    public static int findSmallest(int num1, int num2, int num3) {
        int smallest = num1;
        if (num2 < smallest) {
            smallest = num2;
        }
        if (num3 < smallest) {
            smallest = num3;
        }
        return smallest;
    }
}
