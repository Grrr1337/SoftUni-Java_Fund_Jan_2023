package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> data = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

        String input = scanner.nextLine();
        while (!input.equals("3:1")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "merge":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    merge(data, startIndex, endIndex);
                    break;

                case "divide":
                    int index = Integer.parseInt(tokens[1]);
                    int partitions = Integer.parseInt(tokens[2]);
                    divide(data, index, partitions);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(String.join(" ", data));
    }

    public static void merge(List<String> data, int startIndex, int endIndex) {
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (endIndex > data.size() - 1) {
            endIndex = data.size() - 1;
        }

        StringBuilder merged = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            merged.append(data.get(i));
        }

        data.subList(startIndex, endIndex + 1).clear();
        data.add(startIndex, merged.toString());
    }

    public static void divide(List<String> data, int index, int partitions) {
        String element = data.get(index);
        int length = element.length();

        if (partitions == 0) {
            return;
        }

        int partitionSize = length / partitions;

        List<String> divided = new ArrayList<>();
        int i = 0;
        for (int j = 1; j <= partitions; j++) {
            int endIndex = i + partitionSize;
            if (j == partitions) {
                endIndex = length;
            }

            divided.add(element.substring(i, endIndex));
            i = endIndex;
        }

        data.remove(index);
        data.addAll(index, divided);
    }
}

