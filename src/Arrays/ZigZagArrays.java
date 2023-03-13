package Arrays;


import java.util.*;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // read the number of pairs

        int[] arr1 = new int[n]; // create the first array
        int[] arr2 = new int[n]; // create the second array

        // read the pairs and fill the arrays
        for (int i = 0; i < n; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            if (i % 2 == 0) {
                arr1[i] = num1;
                arr2[i] = num2;
            } else {
                arr1[i] = num2;
                arr2[i] = num1;
            }
        }

        // print the arrays
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();

        for (int num : arr2) {
            System.out.print(num + " ");
        }
    }
}
