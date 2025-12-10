import java.util.Map;

public class Pokedex implements PokedexInterface {
    private Pokemon pokemon;
    private Map<String, String> debilidad;
    private Ataque ataque;

    public Pokedex(Pokemon pokemon, Map<String, String> debilidad, Ataque ataque) {
        this.pokemon = pokemon;
        this.debilidad = debilidad;
        this.ataque = ataque;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public Map<String, String> getDebilidad() {
        return debilidad;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public Pokemon comparador(Pokemon p1, Pokemon p2) {
        String tipo1 = p1.getTipo();
        String tipo2 = p2.getTipo();

        if (debilidad.containsKey(tipo1) && debilidad.get(tipo1).equals(tipo2)) {
            return p1;
        } else if (debilidad.containsKey(tipo2) && debilidad.get(tipo2).equals(tipo1)) {
            return p2;
        }
        return null;
    }

    @Override
    public String toString() {
        String numeroStr = String.format("%04d", pokemon.getNumero());
        return "N° " + numeroStr + " – " + pokemon.getNombre() + " – " + pokemon.getDescripcion() + "\n" +
                "**Altura: " + pokemon.getAltura() + "m**\n" +
                "**Peso: " + pokemon.getPeso() + " kg**\n" +
                "**Sexo: " + pokemon.getGenero() + "**\n" +
                "**Tipo: " + pokemon.getTipo() + "**\n" +
                "**Ataque: " + ataque.toString() + "**";
    }
}