package Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] arrays = input.split("\\|");

        List<Integer> result = new ArrayList<>();

        for (int i = arrays.length - 1; i >= 0; i--) {
            String[] numbers = arrays[i].trim().split("\\s+");
            for (String number : numbers) {
                result.add(Integer.parseInt(number));
            }
        }

        // Collections.reverse(result);

        for (int number : result) {
            System.out.print(number + " ");
        }
    }
}
