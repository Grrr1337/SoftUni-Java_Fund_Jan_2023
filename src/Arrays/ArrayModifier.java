package Arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
public class ArrayModifier {

    private static interface Command {
        void execute(int[] arr, String[] args);
    }

    private static class SwapCommand implements Command {
        public void execute(int[] arr, String[] args) {
            int index1 = Integer.parseInt(args[1]);
            int index2 = Integer.parseInt(args[2]);
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }

    private static class MultiplyCommand implements Command {
        public void execute(int[] arr, String[] args) {
            int index1 = Integer.parseInt(args[1]);
            int index2 = Integer.parseInt(args[2]);
            arr[index1] *= arr[index2];
        }
    }

    private static class DecreaseCommand implements Command {
        public void execute(int[] arr, String[] args) {
            for (int i = 0; i < arr.length; i++) {
                arr[i]--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Command[] commands = {
                new SwapCommand(),
                new MultiplyCommand(),
                new DecreaseCommand()
        };

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            String commandName = tokens[0];

            for (Command command : commands) {
                if (command.getClass().getSimpleName().toLowerCase().contains(commandName)) {
                    command.execute(arr, tokens);
                    break;
                }
            }

            input = scanner.nextLine();
        }

        String output = Arrays.stream(arr).mapToObj(String::valueOf).reduce((a, b) -> a + ", " + b).get();
        System.out.println(output);
    }
}
*/



// import java.util.Arrays;
// import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] items = scanner.nextLine().split("\\s+");
        int[] arr = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            arr[i] = Integer.parseInt(items[i]);
        }

        while (true) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            if (command.equals("end")) {
                break;
            }

            int index1 = Integer.parseInt(tokens[1]);
            int index2 = Integer.parseInt(tokens[2]);

            switch (command) {
                case "swap":
                    int temp = arr[index1];
                    arr[index1] = arr[index2];
                    arr[index2] = temp;
                    break;
                case "multiply":
                    arr[index1] *= arr[index2];
                    break;
                case "decrease":
                    for (int i = 0; i < arr.length; i++) {
                        arr[i]--;
                    }
                    break;
                default:
                    break;
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                result.append(arr[i]).append(", ");
            }
            System.out.println(result);
        }
    }
}


