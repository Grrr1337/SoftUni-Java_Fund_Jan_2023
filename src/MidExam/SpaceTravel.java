package MidExam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpaceTravel {
    public static List<Object[]> splitString(String str) {
        List<Object[]> result = new ArrayList<>();

//        Pattern pattern = Pattern.compile("\\s*([A-Za-z]+\\d*\\w*)\\s*(\\d*\\.?\\d+)\\s*\\|\\|");
        Pattern pattern = Pattern.compile("\\s*([A-Za-z]+\\d*\\w*)\\s*(-?\\d*\\.?\\d+)\\s*\\|\\|"); // handle negative numbers
        Matcher matcher = pattern.matcher(str);

        int pos = 0;
        while (matcher.find()) {
            if (pos != matcher.start()) {
                String lastItem = str.substring(pos, matcher.start()).trim();
                result.add(new Object[]{lastItem, Double.NaN});
            }
            String s = matcher.group(1);
            double d = Double.parseDouble(matcher.group(2));
            result.add(new Object[]{s, d});
            pos = matcher.end();
        }
        if (pos != str.length()) {
            String lastItem = str.substring(pos).trim();
            result.add(new Object[]{lastItem, Double.NaN});
        }

        return result;
    }// splitString

//    public static Map<String, Double> splitString2(String str) {
//        Pattern pattern = Pattern.compile("\\s*([A-Za-z]+\\d*\\w*)\\s*(-?\\d*\\.?\\d*)\\s*\\|\\|");
//        Matcher matcher = pattern.matcher(str);
//        Map<String, Double> result = new HashMap<>();
//        while (matcher.find()) {
//            String s = matcher.group(1).trim();
//            Double d;
//            try {
//                d = Double.parseDouble(matcher.group(2).trim());
//            } catch (NumberFormatException e) {
//                d = null;
//            }
//            result.put(s, d);
//        }
//        return new TreeMap<>(result);
//    }

    public static Map<String, Double> splitStringToTreeMap(String str) {
        String[] items = str.split("\\|\\|");
        Map<String, Double> result = new TreeMap<>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                int pos1 = str.indexOf(s1);
                int pos2 = str.indexOf(s2);
                return Integer.compare(pos1, pos2);
            }
        });
        for (String item : items) {
            String[] parts = item.trim().split("\\s+");
            String key = parts[0];
            Double value = parts.length > 1 ? Double.parseDouble(parts[1]) : null;
            result.put(key, value);
        }
        return result;
    }


    public static void main(String[] args){
        // Travel 20||Enemy 50||Enemy 50||Enemy 10||Repair 15||Enemy 50||Titan
        // 60
        // 100

        // The spaceship travelled 20 light-years.
        //An enemy with 50 armour is defeated.
        //An enemy with 50 armour is defeated.
        //An enemy with 10 armour is outmaneuvered.
        //Ammunitions added: 30.
        //Fuel added: 15.
        //Mission failed.

        // Travel 10||Enemy 30||Repair 15||Titan
        // 50
        // 80

        // The spaceship travelled 10 light-years.
        //An enemy with 30 armour is defeated.
        //Ammunitions added: 30.
        //Fuel added: 15.
        //You have reached Titan, all passengers are safe.

//        String InputStr = "Travel 20||Enemy 50||Enemy 50||Enemy 10||Repair 15||Enemy 50||Titan";

        Scanner scanner = new Scanner(System.in);
        String route = scanner.nextLine();

        int fuel = Integer.parseInt(scanner.nextLine());
        int ammo = Integer.parseInt(scanner.nextLine());

//        List<Object[]> result = splitString(route);
        Map<String, Double> result = splitStringToTreeMap(route);
        boolean missionFailed = false;

        // TEST
        // Tra123vel 20||   E44nemy -4 ||Enemy 50||  Enemy 10||Repair 15||Enemy -50  ||Titan
//        for (Object[] item : result) {
//            System.out.println(item[0] + " _ " + String.valueOf(item[1]));
//        }

        // ||  Pancho     ||Ga16cho||||Tra123vel 20||Titan||Test 442||   E44nemy -4 ||Enemy 50||  Enemy 10||Repair 15||Enemy -50  ||Titan
        // Tra123vel 20||Titan||Test 442||   E44nemy -4 ||Enemy 50||  Enemy 10||Repair 15||Enemy -50  ||Titan
        // Travel 20||Titan||Enemy 50
        //60
        //100

        for (Map.Entry<String, Double> entry : result.entrySet()) {
                System.out.println(entry.getKey() + " : "+ entry.getValue());
        }

        System.out.println("\n\n\n");

        String key;
//        for (Object[] item : result) {

        for (Map.Entry<String, Double> entry : result.entrySet()) {

            Object[] item = new Object[] { entry.getKey(), entry.getValue() };

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
                    // ammo
                    if (ammo >= enemyArmor) {
                        ammo -= enemyArmor;
                        System.out.printf("An enemy with %.0f armour is defeated.%n", enemyArmor);
                        break;
                    } else if (ammo < enemyArmor) {
                        if (fuel >= enemyArmor * 2) {
                            fuel -= enemyArmor * 2;
                            System.out.printf("An enemy with %.0f armour is outmaneuvered.%n", enemyArmor);
                            break;
                        } else {
                            System.out.println("Mission failed.");
                            missionFailed = true;
                            return;
                        }
                    }
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



    public static void main_oldd(String[] args) {

//        String route = "Tra123vel 20||   E44nemy 50 ||Enemy 50||  Enemy 10||Repair 15||Enemy 50  ||Titan";

        Scanner scanner = new Scanner(System.in);
        String route = scanner.nextLine();




    }

    public static void main_old(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] route = scanner.nextLine().split("\\|\\|");
        int fuel = Integer.parseInt(scanner.nextLine());
        int ammo = Integer.parseInt(scanner.nextLine());
        boolean missionFailed = false;

        for (String command : route) {
            String[] tokens = command.split(" ");
            switch (tokens[0]) {
                case "Travel":
                    int distance = Integer.parseInt(tokens[1]);
                    if (fuel >= distance) {
                        fuel -= distance;
                        System.out.printf("The spaceship travelled %d light-years.%n", distance);
                    } else {
                        System.out.println("Mission failed.");
                        missionFailed = true;
                    }
                    break;
                case "Enemy":
                    int enemyArmor = Integer.parseInt(tokens[1]);
                    if (ammo >= enemyArmor) {
                        ammo -= enemyArmor;
                        System.out.printf("An enemy with %d armour is defeated.%n", enemyArmor);
                    } else if (fuel >= enemyArmor * 2) {
                        fuel -= enemyArmor * 2;
                        System.out.printf("An enemy with %d armour is outmaneuvered.%n", enemyArmor);
                    } else {
                        System.out.println("Mission failed.");
                        missionFailed = true;
                        return;
                    }
                    break;
                case "Repair":
                    int repairAmmo = Integer.parseInt(tokens[1]) * 2;
                    int repairFuel = 15;
                    ammo += repairAmmo;
                    fuel += repairFuel;
                    System.out.printf("Ammunitions added: %d.", repairAmmo); // %n
                    System.out.printf("Fuel added: %d.", repairFuel); // %n
                    break;
                case "Titan":
                    System.out.println("You have reached Titan, all passengers are safe.");
                    return;
//                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
            if (missionFailed) {
                System.out.println("Mission failed.");
                missionFailed = true;
                return;
            }
        }
    }
}

// Travel 10||Enemy 30||Repair 15||Titan
// 50
// 80

// The spaceship travelled 10 light-years.
// An enemy with 30 armour is defeated.
// Ammunitions added: 30.
// Fuel added: 15.
// You have reached Titan, all passengers are safe.


// Travel 20||Enemy 50||Enemy 50||Enemy 10||Repair 15||Enemy 50||Titan
// 60
// 10

// The spaceship travelled 20 light-years.
// Mission failed.

