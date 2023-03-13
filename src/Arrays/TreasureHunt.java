package Arrays;

import java.util.*;


public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] treasureChest = scanner.nextLine().split("\\|");
        List<String> items = new ArrayList<>(Arrays.asList(treasureChest));

        String input = scanner.nextLine();
        while (!input.equals("Yohoho!")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        String item = tokens[i];
                        if (!items.contains(item)) {
                            items.add(0, item);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < items.size()) {
                        String item = items.remove(index);
                        items.add(item);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    List<String> stolenItems = new ArrayList<>();
                    for (int i = 0; i < count && !items.isEmpty(); i++) {
                        stolenItems.add(items.remove(items.size() - 1));
                    }
                    Collections.reverse(stolenItems);
                    System.out.println(String.join(", ", stolenItems));
                    break;
            }

            input = scanner.nextLine();
        }

        if (items.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double totalLength = 0;
            for (String item : items) {
                totalLength += item.length();
            }
            double averageGain = totalLength / items.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        }
    }
}



