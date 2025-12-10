import java.util.HashMap;
import java.util.Map;

public class TestPokedex {
    public static void main(String[] args) {
        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur",
                "Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo.",
                0.7, 6.9, "♦♀", "Planta/Veneno");

        Ataque latigoCepa = new Ataque("Latigo cepa", 10);

        Map<String, String> debilidades = new HashMap<>();
        debilidades.put("Planta/Veneno", "Fuego");
        debilidades.put("Fuego", "Agua");
        debilidades.put("Agua", "Planta");

        Pokedex pokedex = new Pokedex(bulbasaur, debilidades, latigoCepa);

        System.out.println("=== POKEDEX ===");
        System.out.println(pokedex.toString());

        System.out.println("\n=== PROPIEDADES ===");
        System.out.println("Pokemon: " + pokedex.getPokemon().getNombre());
        System.out.println("Ataque: " + pokedex.getAtaque().toString());
        System.out.println("Debilidades: " + pokedex.getDebilidad());

        System.out.println("\n=== MODIFICACIONES ===");
        bulbasaur.setAltura(0.8);
        bulbasaur.setPeso(7.2);
        bulbasaur.setDescripcion("Nueva descripción del Pokémon.");
        latigoCepa.setDanio(12);

        System.out.println("Altura modificada: " + bulbasaur.getAltura() + "m");
        System.out.println("Peso modificado: " + bulbasaur.getPeso() + "kg");
        System.out.println("Descripción modificada: " + bulbasaur.getDescripcion());
        System.out.println("Ataque modificado: " + latigoCepa.toString());

        System.out.println("\n=== COMPARADOR ===");
        Pokemon charmander = new Pokemon(4, "Charmander",
                "Prefiere las cosas calientes.", 0.6, 8.5, "♦♂", "Fuego");

        Pokemon squirtle = new Pokemon(7, "Squirtle",
                "Tras nacer, su espalda se hincha y endurece como una concha.", 0.5, 9.0, "♦♀", "Agua");

        Pokemon debil = pokedex.comparador(charmander, squirtle);
        if (debil != null) {
            System.out.println("El Pokémon débil es: " + debil.getNombre());
        } else {
            System.out.println("No hay debilidad directa entre estos tipos");
        }
    }
}