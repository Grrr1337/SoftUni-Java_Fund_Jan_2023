package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read the initial state of the train
        List<Integer> wagons = new ArrayList<>();
        String[] wagonsStr = scanner.nextLine().split(" ");
        for (String wagonStr : wagonsStr) {
            wagons.add(Integer.parseInt(wagonStr));
        }

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        // process the commands
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if (command.startsWith("Add")) {
                int passengers = Integer.parseInt(command.split(" ")[1]);
                addWagon(wagons, passengers);
            } else {
                int passengers = Integer.parseInt(command);
                fillWagon(wagons, maxCapacity, passengers);
            }

            command = scanner.nextLine();
        }

        // print the final state of the train
        for (int i = 0; i < wagons.size(); i++) {
            System.out.print(wagons.get(i));
            if (i < wagons.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static void addWagon(List<Integer> wagons, int passengers) {
        wagons.add(passengers);
    }

    private static void fillWagon(List<Integer> wagons, int maxCapacity, int passengers) {
        for (int i = 0; i < wagons.size(); i++) {
            int freeCapacity = maxCapacity - wagons.get(i);
            if (passengers <= freeCapacity) {
                wagons.set(i, wagons.get(i) + passengers);
                break;
            }
        }
    }
}

