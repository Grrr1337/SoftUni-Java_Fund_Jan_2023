package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogueStatic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsepower = Integer.parseInt(tokens[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            vehicles.add(vehicle);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("Close the Catalogue") && (!input.isEmpty() && input.length() != 0)) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(input)) {
                    System.out.println(vehicle);
                    break;
                }
            }

            input = scanner.nextLine();
        }

        double avgCarHorsepower = Vehicle.getAverageHorsepower(vehicles, "Car");
        double avgTruckHorsepower = Vehicle.getAverageHorsepower(vehicles, "Truck");

        System.out.printf("Cars have average horsepower of: %.2f.%n", avgCarHorsepower);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", avgTruckHorsepower);

        scanner.close();
    }


    public static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = toCamelCase(type);
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }

        public static int getTotalHorsepower(List<Vehicle> vehicles, String type) {
            int totalHorsepower = 0;
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getType().equals(type)) {
                    totalHorsepower += vehicle.getHorsepower();
                }
            }
            return totalHorsepower;
        }

        public static double getAverageHorsepower(List<Vehicle> vehicles, String type) {
            int count = 0;
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getType().equalsIgnoreCase(type)) {
                    count++;
                }
            }
            if (count == 0) {
                return 0.0;
            } else {
                int totalHorsepower = getTotalHorsepower(vehicles, type);
                return (double) totalHorsepower / count;
            }
        }

        public String toString() {
            return "Type: " + type + "\nModel: " + model + "\nColor: " + color + "\nHorsepower: " + horsepower;
        }

        private static String toCamelCase(String str) {
            if (str == null || str.isEmpty()) {
                return str;
            }
            String[] words = str.split("\\s+|_|-");
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                if (!word.isEmpty()) {
                    result.append(Character.toUpperCase(word.charAt(0)));
                    if (word.length() > 1) {
                        result.append(word.substring(1).toLowerCase());
                    }
                }
            }
            return result.toString();
        }
    }
}
