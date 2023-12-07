package MidExam;

import java.util.*;

public class ChatLogger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> chat = new ArrayList<>();

        String command = input.nextLine();
        while (!command.equals("end")) {
            String[] tokens = command.split(" ");
            String action = tokens[0];

            switch (action) {
                case "Chat":
                    chat.add(tokens[1]);
                    break;
                case "Delete":
                    if (chat.contains(tokens[1])) {
                        chat.remove(tokens[1]);
                    }
                    break;
                case "Edit":
                    if (chat.contains(tokens[1])) {
                        int index = chat.indexOf(tokens[1]);
                        chat.set(index, tokens[2]);
                    }
                    break;
                case "Pin":
                    if (chat.contains(tokens[1])) {
                        chat.remove(tokens[1]);
                        chat.add(tokens[1]);
                    }
                    break;
                case "Spam":
                    for (int i = 1; i < tokens.length; i++) {
                        chat.add(tokens[i]);
                    }
                    break;
                default:
                    break;
            }

            command = input.nextLine();
        }

        for (String message : chat) {
            System.out.println(message);
        }
    }
}

// Chat Hello
// Chat darling
// Edit darling Darling
// Spam how are you
// Delete Darling
// end

// Hello
// how
// are
// you


