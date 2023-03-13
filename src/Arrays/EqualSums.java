package Arrays;

import java.util.Scanner;

public class EqualSums {
    /*
        The program reads the input array of integers from the standard input and then iterates through all
        the indices of the array. For each index, it computes the sum of the elements to its left and to its right
        and checks if they are equal. If so, it prints the index and terminates the program.
        If no such index is found, it prints "no". Note that the sums of the empty arrays
        to the left and to the right are considered to be zero by default.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("no");
    }
}

