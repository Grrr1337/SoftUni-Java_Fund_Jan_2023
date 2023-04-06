package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public Vehicle(String type, String model, String color, int horsepower) {
        this.type = type;
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
            if (vehicle.getType().equals(type)) {
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
}
