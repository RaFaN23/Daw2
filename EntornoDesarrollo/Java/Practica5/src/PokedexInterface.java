import java.util.Map;

public interface PokedexInterface {
    Pokemon getPokemon();
    Map<String, String> getDebilidad();
    Ataque getAtaque();
    Pokemon comparador(Pokemon p1, Pokemon p2);
    String toString();
}