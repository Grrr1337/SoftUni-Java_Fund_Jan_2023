package AssociativeArrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.*;
import java.util.stream.*;

public class LegendaryFarming {
    private Map<String, Integer> keyMaterials = new HashMap<>();
    private Map<String, Integer> junkItems = new TreeMap<>();

    public void processInput(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] tokens = line.split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();
                if (isKeyMaterial(material)) {
                    keyMaterials.merge(material, quantity, Integer::sum);
                    if (hasLegendaryItem()) {
                        return;
                    }
                } else {
                    junkItems.merge(material, quantity, Integer::sum);
                }
            }
        }
    }

    private boolean isKeyMaterial(String material) {
        return material.equals("shards") || material.equals("fragments") || material.equals("motes");
    }

    private boolean hasLegendaryItem() {
        for (String material : keyMaterials.keySet()) {
            if (keyMaterials.get(material) >= 250) {
                printLegendaryItem(material);
                return true;
            }
        }
        return false;
    }

    private void printLegendaryItem(String material) {
        String item;
        switch (material) {
            case "shards":
                item = "Shadowmourne";
                break;
            case "fragments":
                item = "Valanyr";
                break;
            case "motes":
                item = "Dragonwrath";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + material);
        }
        System.out.println(item + " obtained!");
        keyMaterials.compute(material, (m, q) -> q - 250);
    }

    public Map<String, Integer> getKeyMaterials() {
        return keyMaterials;
    }

    public Map<String, Integer> getJunkItems() {
        return junkItems;
    }

    public void printResults() {
        printKeyMaterials();
        printJunkItems();
    }

    private void printKeyMaterials() {
        keyMaterials.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }

    private void printJunkItems() {
        junkItems.entrySet().stream()
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}
