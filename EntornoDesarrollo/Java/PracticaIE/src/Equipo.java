import java.util.HashMap;
import java.util.Map;

public class Equipo {
    private String nombreEquipo;
    private Map<String, JugadorInazuma> miembros;

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.miembros = new HashMap<>();
    }

    public String getNombreEquipo() { return nombreEquipo; }
    public void setNombreEquipo(String nombreEquipo) { this.nombreEquipo = nombreEquipo; }
    public Map<String, JugadorInazuma> getMiembros() { return miembros; }
    public void setMiembros(Map<String, JugadorInazuma> miembros) { this.miembros = miembros; }

    public void agregarMiembro(JugadorInazuma nuevoMiembro) {
        miembros.put(nuevoMiembro.getAlias(), nuevoMiembro);
        nuevoMiembro.setEquipo(this.nombreEquipo);
    }

    public void quitarMiembro(JugadorInazuma jugador) {
        miembros.remove(jugador.getAlias());
    }

    public double poderDelEquipo() {
        if (miembros.isEmpty()) return 0.0;

        double sumaPoder = 0.0;
        for (JugadorInazuma jugador : miembros.values()) {
            sumaPoder += jugador.getPoder();
        }
        return sumaPoder / miembros.size();
    }

    @Override
    public String toString() {
        StringBuilder nombres = new StringBuilder();
        for (JugadorInazuma jugador : miembros.values()) {
            if (!nombres.isEmpty()) nombres.append(", ");
            nombres.append(jugador.getNombre());
        }
        return String.format("Equipo %s, miembros: %s.", nombreEquipo, nombres.toString());
    }
}