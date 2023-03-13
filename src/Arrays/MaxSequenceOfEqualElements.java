package Arrays;

import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    /*
        This solution reads the input string from the user, splits it into an array of elements,
        and then iterates over the array to find the longest sequence of equal elements.
        It keeps track of the current sequence start and end indices,
        as well as the maximum sequence start and end indices seen so far.
        When a new sequence starts, it updates the current sequence start and end indices.
        When a sequence ends, it compares the length of the current sequence with the length of the maximum sequence seen so far,
        and updates the maximum sequence start and end indices if the current sequence is longer.
        Finally, it prints the longest sequence found.
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split(" ");

        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int currentStartIndex = 0;
        int currentEndIndex = 0;

        for (int i = 1; i < elements.length; i++) {
            if (elements[i].equals(elements[i - 1])) {
                currentEndIndex = i;
                if (currentEndIndex - currentStartIndex > maxEndIndex - maxStartIndex) {
                    maxStartIndex = currentStartIndex;
                    maxEndIndex = currentEndIndex;
                }
            } else {
                currentStartIndex = i;
                currentEndIndex = i;
            }
        }

        for (int i = maxStartIndex; i <= maxEndIndex; i++) {
            System.out.print(elements[i] + " ");
        }
    }

}
