
package ObjectsAndClasses;
import java.util.Random;
import java.util.Scanner;

import java.util.Scanner;

public class AdvertisementMessage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of messages to generate: ");
        int count = scanner.nextInt();

        AdvertisementMessageGenerator advertisementMessage = new AdvertisementMessageGenerator(
                new String[] {"Excellent product.", "Such a great product.", "I always use that product.",
                        "Best product of its category.", "Exceptional product.", "I can't live without this product."},
                new String[] {"Now I feel good.", "I have succeeded with this product.",
                        "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                        "Try it yourself, I am very satisfied!", "I feel great!"},
                new String[] {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"},
                new String[] {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"}
        );

        String[] messages = advertisementMessage.generateMessages(count);
        for (String message : messages) {
            System.out.println(message);
        }
    }


    public static class AdvertisementMessageGenerator {
        private final String[] phrases;
        private final String[] events;
        private final String[] authors;
        private final String[] cities;

        public AdvertisementMessageGenerator(String[] phrases, String[] events, String[] authors, String[] cities) {
            this.phrases = phrases;
            this.events = events;
            this.authors = authors;
            this.cities = cities;
        }

        public String generateMessage() {
            Random random = new Random();
            String phrase = phrases[random.nextInt(phrases.length)];
            String event = events[random.nextInt(events.length)];
            String author = authors[random.nextInt(authors.length)];
            String city = cities[random.nextInt(cities.length)];
            return String.format("%s %s %s - %s", phrase, event, author, city);
        }

        public String[] generateMessages(int count) {
            String[] messages = new String[count];
            for (int i = 0; i < count; i++) {
                messages[i] = generateMessage();
            }
            return messages;
        }
    }

}

