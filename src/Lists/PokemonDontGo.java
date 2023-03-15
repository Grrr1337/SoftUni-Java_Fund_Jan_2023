package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokemonDontGo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> pokemons = new ArrayList<>();
        long sumRemoved = 0;

        for (String number : input) {
            pokemons.add(Integer.parseInt(number));
        }

        while (!pokemons.isEmpty()) {
            int index = scanner.nextInt();
            int removed;

            if (index < 0) {
                index = 0;
                removed = pokemons.remove(0);
                pokemons.add(0, pokemons.get(pokemons.size() - 1));
            } else if (index >= pokemons.size()) {
                index = pokemons.size() - 1;
                removed = pokemons.remove(pokemons.size() - 1);
                pokemons.add(pokemons.get(0));
            } else {
                removed = pokemons.remove(index);
            }

            sumRemoved += removed;

            for (int i = 0; i < pokemons.size(); i++) {
                int pokemon = pokemons.get(i);
                if (pokemon <= removed) {
                    pokemons.set(i, pokemon + removed);
                } else {
                    pokemons.set(i, pokemon - removed);
                }
            }
        }

        System.out.println(sumRemoved);
    }
}
