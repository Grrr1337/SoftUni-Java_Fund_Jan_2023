package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        while (true) {
            String resource = scanner.nextLine();
            if (resource.equals("stop")) {
                break;
            }

            int quantity = Integer.parseInt(scanner.nextLine());

            resources.merge(resource, quantity, Integer::sum);
        }

        resources.forEach((resource, quantity) ->
                System.out.println(resource + " -> " + quantity));
    }
}
