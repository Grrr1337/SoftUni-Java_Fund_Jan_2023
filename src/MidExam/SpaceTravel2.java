

package MidExam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Titan||Travel 10||Enemy 30||Repair 15||Titan

// Travel 20||Enemy 50||Enemy 50||Enemy 10||Repair 15||Enemy 50||Titan
//60
//100

public class SpaceTravel2 {

    public static Map<String, List<Double>> splitString(String str) {
        String[] items = str.split("\\|\\|");
        Map<String, List<Double>> result = new LinkedHashMap<>();
        for (String item : items) {
            String[] parts = item.trim().split("\\s+");
            String key = parts[0];
            Double value = parts.length > 1 ? Double.parseDouble(parts[1]) : null;
            List<Double> values = result.get(key);
            if (values == null) {
                values = new ArrayList<>();
                result.put(key, values);
            }
            values.add(value);
        }
        return result;
    }
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String route = scanner.nextLine();

        int fuel = Integer.parseInt(scanner.nextLine());
        int ammo = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> result = splitString(route);
        boolean missionFailed = false;

         for (Map.Entry<String, List<Double>> entry : result.entrySet()) {
            System.out.println(entry.getKey());
            for ( double val : entry.getValue()) {
                System.out.println(val);
            }
         }

        String key;


        for (Map.Entry<String, List<Double>> entry : result.entrySet()) {

            Object[] item = new Object[] { entry.getKey(), entry.getValue() }; // < YES I KNOW THIS IS UNPROFESSIONAL, -SHUT UP!

            key = ((String)item[0]).toLowerCase();

             System.out.println("Processing " + item[0]);

            if (key.equals("titan")) {
                System.out.println("You have reached Titan, all passengers are safe.");
                return;
            }

            if (!(key.equals("repair")) && (fuel < 0)) {
                System.out.println("Mission failed.");
                missionFailed = true;
                return;
            }

            //            System.out.println(item[0] + " _ " + String.valueOf(item[1]));

            switch (((String)item[0]).toLowerCase()) {
                case "travel": {
                    double distance = (double) item[1];
                    if (fuel >= distance) {
                        fuel -= distance;
                        System.out.printf("The spaceship travelled %.0f light-years.%n", distance);
                    } else {
                        System.out.println("Mission failed.");
                        missionFailed = true;
                        return;
                    }
                    break;
                }
                case "enemy": {
                    double enemyArmor = (double) item[1];
                    if (ammo >= enemyArmor) {
                        ammo -= enemyArmor;
                        System.out.printf("An enemy with %.0f armour is defeated.%n", enemyArmor);
                    } else if (fuel >= enemyArmor * 2) {
                        fuel -= enemyArmor * 2;
                        System.out.printf("An enemy with %.0f armour is outmaneuvered.%n", enemyArmor);
                    } else {
                        System.out.println("Mission failed.");
                        missionFailed = true;
                        return;
                    }
                    break;
                }
                case "repair": {
                    double repairAmmo = (double) item[1] * 2;
                    int repairFuel = 15;
                    ammo += repairAmmo;
                    fuel += repairFuel;
                    System.out.printf("Ammunitions added: %.0f.%n", repairAmmo);
                    System.out.printf("Fuel added: %d.%n", repairFuel);
                    break;
                }
                case "titan": {
                    System.out.println("You have reached Titan, all passengers are safe.");
                    break;
                }
                default: {
                    //                    System.out.println("Invalid command.");
                    break;
                }
            }// switch

        } // for
        System.out.println("Mission failed.");

    }// main
}// class





