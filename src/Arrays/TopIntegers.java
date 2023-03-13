package Arrays;

import java.util.*;

public class TopIntegers {
    /*
        Explanation:

        We first create a Scanner object to read input from the standard input stream.
        We read the array as a string of space-separated integers using the nextLine() method of the Scanner object.
        We then convert the string to an array of integers using a loop and the parseInt() method of the Integer class.
        We create an ArrayList called topIntegers to store the top integers.
        We iterate over the array from right to left using a loop:
        For each element, we check if it is bigger than all the elements to its right.
        We do this by iterating over the elements to the right using another loop and comparing their values with the current element.
        If the current element is bigger than all the elements to its right, we add it to the topIntegers list.
        We print the topIntegers list in reverse order using another loop.
        The program terminates.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // read the array
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        List<Integer> topIntegers = new ArrayList<>();

        // iterate over the array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            boolean isTop = true;
            // check if the current element is bigger than all the elements to its right
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    isTop = false;
                    break;
                }
            }
            if (isTop) {
                topIntegers.add(arr[i]);
            }
        }

        // print the top integers in reverse order
        for (int i = topIntegers.size() - 1; i >= 0; i--) {
            System.out.print(topIntegers.get(i) + " ");
        }
    }
}

