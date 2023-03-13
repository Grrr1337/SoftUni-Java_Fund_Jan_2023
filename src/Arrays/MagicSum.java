package Arrays;

import java.util.*;

public class MagicSum {
    /*
        The program reads the input array of integers and the target sum from standard input,
        then uses two nested loops to iterate over all pairs of elements in the array.
        If a pair's sum is equal to the target sum, the program adds the pair (in ascending order) to a set of unique pairs.
        Finally, the program prints each unique pair to standard output.
    */

    /*
        The issue in the previous solution was that
        I was not sorting the pairs before adding them to the pairs set,
        which caused the pairs to be in the wrong order.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        int targetSum = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == targetSum) {
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
    }

    public static void main_oldd(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int targetSum = scanner.nextInt();

        Set<String> pairs = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int currentSum = arr[i] + arr[j];
                if (currentSum == targetSum) {
                    int smaller = Math.min(arr[i], arr[j]);
                    int greater = Math.max(arr[i], arr[j]);
                    pairs.add(smaller + " " + greater);
                }
            }
        }

        pairs.forEach(System.out::println);
    }

    public static void main_old(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int targetSum = Integer.parseInt(scanner.nextLine());

        Set<String> uniquePairs = new HashSet<String>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == targetSum) {
                    int x = Math.min(nums[i], nums[j]);
                    int y = Math.max(nums[i], nums[j]);
                    uniquePairs.add(String.format("%d %d", x, y));
                }
            }
        }
        for (String pair : uniquePairs) {
            System.out.println(pair);
        }
    }
}

