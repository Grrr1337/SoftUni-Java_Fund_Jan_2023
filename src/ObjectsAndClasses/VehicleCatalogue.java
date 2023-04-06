package ObjectsAndClasses;

import java.util.*;
import ObjectsAndClasses.Vehicle;

public class VehicleCatalogue {
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
        while (!input.equals("Close the Catalogue")) {
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


}


