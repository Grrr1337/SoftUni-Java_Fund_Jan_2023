package ObjectsAndClasses;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OpinionPoll {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted((p1, p2) -> people.indexOf(p1) - people.indexOf(p2))
                .map(Person::toString)
                .forEach(System.out::println);
    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String toString() {
            return name + " - " + age;
        }
    }
}