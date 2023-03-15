package Lists;

import java.util.ArrayList;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCommands = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> guests = new ArrayList<>();

        for (int i = 0; i < numCommands; i++) {
            String command = scanner.nextLine();
            String[] tokens = command.split(" ");
            String name = tokens[0];

            if (tokens[2].equals("going!")) {
                if (guests.contains(name)) {
                    System.out.println(name + " is already in the list!");
                } else {
                    guests.add(name);
                }
            } else if (tokens[2].equals("not")) {
                if (guests.contains(name)) {
                    guests.remove(name);
                } else {
                    System.out.println(name + " is not in the list!");
                }
            }
        }

        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}

