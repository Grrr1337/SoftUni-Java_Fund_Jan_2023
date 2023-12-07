package Tests;

import ObjectsAndClasses.VehicleCatalogueStatic;
import ObjectsAndClasses.VehicleCatalogueStatic.Vehicle;
import ObjectsAndClasses.VehicleCatalogueStatic;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class VehicleCatalogueStaticTest {

    @Test
    public void testConstructorAndGetters() {
        Vehicle car = new Vehicle("car", "Ford", "green", 120);
        assertEquals("car", car.getType());
        assertEquals("Ford", car.getModel());
        assertEquals("green", car.getColor());
        assertEquals(120, car.getHorsepower());
    }

    @Test
    public void testGetTotalHorsepower() {
        List<Vehicle> cars = new ArrayList<>();
        cars.add(new Vehicle("car", "Ford", "green", 120));
        cars.add(new Vehicle("car", "Ferrari", "red", 550));
        cars.add(new Vehicle("car", "Lamborghini", "orange", 570));
        assertEquals(1240, Vehicle.getTotalHorsepower(cars, "car"));

        List<Vehicle> trucks = new ArrayList<>();
        trucks.add(new Vehicle("truck", "Man", "red", 200));
        trucks.add(new Vehicle("truck", "Mercedes", "blue", 300));
        assertEquals(500, Vehicle.getTotalHorsepower(trucks, "truck"));
    }

    @Test
    public void testGetAverageHorsepower() {
        List<Vehicle> cars = new ArrayList<>();
        cars.add(new Vehicle("car", "Ford", "green", 120));
        cars.add(new Vehicle("car", "Ferrari", "red", 550));
        cars.add(new Vehicle("car", "Lamborghini", "orange", 570));
        assertEquals(413.33, Vehicle.getAverageHorsepower(cars, "car"), 0.01);

        List<Vehicle> trucks = new ArrayList<>();
        trucks.add(new Vehicle("truck", "Man", "red", 200));
        trucks.add(new Vehicle("truck", "Mercedes", "blue", 300));
        assertEquals(250.00, Vehicle.getAverageHorsepower(trucks, "truck"), 0.01);
    }

    @Test
    public void testCatalogueWithOneCar() {
        List<Vehicle> cars = new ArrayList<>();
        cars.add(new Vehicle("car", "Opel", "green", 736));
        assertEquals(736.00, Vehicle.getAverageHorsepower(cars, "car"), 0.01);
        assertEquals(0.00, Vehicle.getAverageHorsepower(cars, "truck"), 0.01);
    }

    @Test
    public void testCatalogueWithMultipleVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("truck", "Man", "red", 200));
        vehicles.add(new Vehicle("truck", "Mercedes", "blue", 300));
        vehicles.add(new Vehicle("car", "Ford", "green", 120));
        vehicles.add(new Vehicle("car", "Ferrari", "red", 550));
        vehicles.add(new Vehicle("car", "Lamborghini", "orange", 570));
        String expectedOutput = "Type: Car\nModel: Ferrari\nColor: red\nHorsepower: 550\n" +
                "Type: Car\nModel: Ford\nColor: green\nHorsepower: 120\n" +
                "Type: Truck\nModel: Man\nColor: red\nHorsepower: 200\n" +
                "Cars have average horsepower of: 413.33.\n" +
                "Trucks have average horsepower of: 250.00.\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        // VehicleCatalogue.printVehicles(vehicles, "Ferrari");
        String actualOutput = outputStream.toString();
//        assertEquals(expectedOutput, actualOutput);
        assertOutputEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCatalogueWithOneCar2() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("car", "Opel", "green", 736));
        double expectedAverageHorsepower = 736.00;
        double actualAverageHorsepower = 0.0;
        int carCount = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals("car")) {
                actualAverageHorsepower += vehicle.getHorsepower();
                carCount++;
            }
        }
        if (carCount > 0) {
            actualAverageHorsepower /= carCount;
        }
        String expectedOutput = "Cars have average horsepower of: " +
                String.format("%.2f", expectedAverageHorsepower) + ".\n" +
                "Trucks have average horsepower of: 0.00.\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        // VehicleCatalogue.printVehicles(vehicles, "Opel");
        String actualOutput = outputStream.toString();
//        assertEquals(expectedOutput, actualOutput);
        assertOutputEquals(expectedOutput, actualOutput);
        assertEquals(expectedAverageHorsepower, actualAverageHorsepower, 0.01);
    }

    public static void assertOutputEquals(String expectedOutput, String actualOutput) {
        String normalizedExpected = expectedOutput.replaceAll("\\r\\n", "\n").trim();
        String normalizedActual = actualOutput.replaceAll("\\r\\n", "\n").trim();
        assertEquals(normalizedExpected, normalizedActual);
    }

}
