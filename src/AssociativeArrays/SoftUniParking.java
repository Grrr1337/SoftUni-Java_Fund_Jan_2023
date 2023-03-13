package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {

    private Map<String, String> parkingDatabase = new LinkedHashMap<>();

    public void executeCommand(String command) {
        String[] parts = command.split("\\s+");
        if (parts[0].equals("register")) {
            String username = parts[1];
            String licensePlateNumber = parts[2];
            if (parkingDatabase.containsKey(username)) {
                System.out.println("ERROR: already registered with plate number " + parkingDatabase.get(username));
            } else {
                parkingDatabase.put(username, licensePlateNumber);
                System.out.println(username + " registered " + licensePlateNumber + " successfully");
            }
        } else if (parts[0].equals("unregister")) {
            String username = parts[1];
            if (!parkingDatabase.containsKey(username)) {
                System.out.println("ERROR: user " + username + " not found");
            } else {
                String licensePlateNumber = parkingDatabase.remove(username);
                System.out.println(username + " unregistered successfully");
            }
        }
    }

    public void printDatabase() {
        parkingDatabase.entrySet().forEach(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()));
    }

    public Map<String, String> getParkingDatabase() {
        return parkingDatabase;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the end of line character
        SoftUniParking validator = new SoftUniParking();
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            validator.executeCommand(command);
        }
        validator.printDatabase();
    }
}
