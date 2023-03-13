package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> grades = new LinkedHashMap<>();
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            grades.computeIfAbsent(name, k -> 0.0);
            grades.computeIfPresent(name, (k, v) -> v + grade);

            counts.computeIfAbsent(name, k -> 0);
            counts.computeIfPresent(name, (k, v) -> v + 1);
        }

        grades.entrySet().stream()
                .filter(entry -> entry.getValue() / counts.get(entry.getKey()) >= 4.5)
                .forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue() / counts.get(entry.getKey())));
    }
}

