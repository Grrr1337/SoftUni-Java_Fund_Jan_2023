package RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int planets = Integer.parseInt(scanner.nextLine());
        List<String> attackedPlanetsList = new ArrayList<>();
        List<String> destroyedPlanetsList = new ArrayList<>();

        String regex = "@(?<planetName>[A-Za-z]+)[^@!:>-]*:(?<population>[0-9]+)[^@!:>-]*!(?<attackType>[AD])![^@!:>-]*->(?<soldiersCount>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 1; i <= planets; i++) {
            String input = scanner.nextLine();
            String newText = decryptText(input);

            Matcher matcher = pattern.matcher(newText);
            if (matcher.find()) {
                String name = matcher.group("planetName");
                String types = matcher.group("attackType");
                if (types.equals("A")) {
                    attackedPlanetsList.add(name);
                } else if (types.equals("D")) {
                    destroyedPlanetsList.add(name);
                }
            }
        }

        printPlanets("Attacked planets", attackedPlanetsList);
        printPlanets("Destroyed planets", destroyedPlanetsList);
    }

    public static String decryptText(String input) {
        int countSymbols = getCharCount(input);
        char[] charArr = input.toCharArray();
        for (int j = 0; j < charArr.length; j++) {
            charArr[j] = (char) (charArr[j] - countSymbols);
        }
        return new String(charArr);
    }

    public static int getCharCount(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (c == 's' || c == 't' || c == 'a' || c == 'r') {
                count++;
            }
        }
        return count;
    }

    public static void printPlanets(String title, List<String> planets) {
        Collections.sort(planets);
        System.out.println(title + ": " + planets.size());
        for (String planet : planets) {
            System.out.println("-> " + planet);
        }
    }
}
