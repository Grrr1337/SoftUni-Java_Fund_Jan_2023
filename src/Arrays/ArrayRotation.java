package Arrays;

import java.util.*;

public class ArrayRotation {
    /*
    Explanation:

    We first create a Scanner object to read input from the standard input stream.
    We read the array as a string of space-separated integers using the nextLine() method of the Scanner object.
    We then convert the string to an array of integers using a loop and the parseInt() method of the Integer class.
    We read the number of rotations using the nextInt() method of the Scanner object.
    We perform the rotations using a loop:
    We first store the value of the first element in a variable called first.
    We then shift all the elements one position to the left using a loop, overwriting each element with the value of the next element.
    Finally, we assign the value of first to the last element of the array.
    We print the resulting array using a loop.
    The program terminates
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // read the array
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int rotations = sc.nextInt(); // read the number of rotations

        // perform the rotations
        for (int i = 0; i < rotations; i++) {
            int first = arr[0];
            for (int j = 1; j < arr.length; j++) {
                arr[j-1] = arr[j];
            }
            arr[arr.length-1] = first;
        }

        // print the resulting array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
