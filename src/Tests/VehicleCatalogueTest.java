package Tests;

import ObjectsAndClasses.Vehicle;

import ObjectsAndClasses.VehicleCatalogue;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VehicleCatalogueTest  {

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

}

