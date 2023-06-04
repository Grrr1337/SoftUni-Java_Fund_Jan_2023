package RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
//        String demons = "Aamon 80.8/100.0*Stars+200.0 -50.5";
        Scanner scanner = new Scanner(System.in);
        String demons = scanner.nextLine();
        List<Demon> extractedDemons = extractDemonData(demons);
        for (Demon demon : extractedDemons) {
            System.out.println(demon);
        }
    }

    public static List<Demon> extractDemonData(String demons) {
        List<Demon> demonList = new ArrayList<>();
        Pattern demonPattern = Pattern.compile("[^,\\s+]+");
        Matcher demonMatcher = demonPattern.matcher(demons);

        while (demonMatcher.find()) {
            String demonName = demonMatcher.group();
            int demonHealth = getDemonHealth(demonName);
            double demonDamage = getDemonDamage(demonName);

            Demon demon = new Demon(demonName, demonHealth, demonDamage);
            demonList.add(demon);
        }

        return demonList;
    }

    private static double getDemonDamage(String name) {
        Pattern damagePattern = Pattern.compile("[-|+]?(\\d+\\.?\\d+|\\d+)");
        Matcher damageMatcher = damagePattern.matcher(name);

        double damage = 0.0;
        while (damageMatcher.find()) {
            damage += Double.parseDouble(damageMatcher.group());
        }

        Pattern pattern = Pattern.compile("[*/]");
        damageMatcher = pattern.matcher(name);

        while (damageMatcher.find()) {
            String symbol = damageMatcher.group();
            if (symbol.equals("*")) {
                damage *= 2;
            } else if (symbol.equals("/")) {
                damage /= 2;
            }
        }

        return damage;
    }

    private static int getDemonHealth(String name) {
        Pattern healthPattern = Pattern.compile("[^-+0-9*/.]");
        Matcher healthMatcher = healthPattern.matcher(name);
        int sumOfCharCodes = 0;
        while (healthMatcher.find()) {
            int symbolAsciiCode = healthMatcher.group().charAt(0);
            sumOfCharCodes += symbolAsciiCode;
        }

        return sumOfCharCodes;
    }

    public static class Demon {
        private String name;
        private int health;
        private double damage;

        public Demon(String name, int health, double damage) {
            this.name = name;
            this.health = health;
            this.damage = damage;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        public double getDamage() {
            return damage;
        }

        @Override
        public String toString() {
            return String.format("%s - %d health, %.2f damage", name, health, damage);
        }
    }
}

