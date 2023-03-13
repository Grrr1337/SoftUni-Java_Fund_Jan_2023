package Arrays;

import java.util.*;

public class CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // read the first array
        String[] arr1 = sc.nextLine().split(" ");

        // read the second array
        String[] arr2 = sc.nextLine().split(" ");

        // create a HashSet to store the common elements
        Set<String> common = new HashSet<>();

        // loop through each element in the second array
        for (String elem : arr2) {
            // if the element is present in the first array, add it to the common set
            if (Arrays.asList(arr1).contains(elem)) {
                common.add(elem);
            }
        }

        // print the common elements
        for (String elem : common) {
            System.out.print(elem + " ");
        }
    }
}
