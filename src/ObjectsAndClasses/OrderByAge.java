package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {

    static class Person {
        private final String name;
        private final String id;
        private final int age;

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name + " with ID: " + id + " is " + age + " years old.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("End")) {
                break;
            }

            String[] tokens = line.split(" ");
            String name = tokens[0];
            String id = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Person person = new Person(name, id, age);
            people.add(person);
        }

        people.sort(Comparator.comparingInt(Person::getAge));

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}

