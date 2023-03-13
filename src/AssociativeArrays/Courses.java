package AssociativeArrays;

import java.util.*;
public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];

            courses.putIfAbsent(courseName, new ArrayList<>());
            courses.get(courseName).add(studentName);

            input = scanner.nextLine();
        }

        courses.entrySet().stream()
                .forEach(e -> {
                    System.out.printf("%s: %d%n", e.getKey(), e.getValue().size());
                    e.getValue().stream().forEach(s -> System.out.printf("-- %s%n", s));
                });
    }
}
