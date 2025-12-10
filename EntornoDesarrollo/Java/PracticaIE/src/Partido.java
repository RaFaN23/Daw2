public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;

    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public Equipo getEquipo1() { return equipo1; }
    public Equipo getEquipo2() { return equipo2; }

    public String simularEnfrentamiento() {
        double factor1 = 1.0 + Math.random();
        double factor2 = 1.0 + Math.random();

        double puntuacion1 = equipo1.poderDelEquipo() * factor1;
        double puntuacion2 = equipo2.poderDelEquipo() * factor2;

        Equipo ganador = (puntuacion1 > puntuacion2) ? equipo1 : equipo2;

        StringBuilder resultado = new StringBuilder();
        resultado.append(String.format("¡Partido entre %s y %s!\n",
                equipo1.getNombreEquipo(), equipo2.getNombreEquipo()));
        resultado.append(String.format("Puntuación %s: %.2f\n",
                equipo1.getNombreEquipo(), puntuacion1));
        resultado.append(String.format("Puntuación %s: %.2f\n",
                equipo2.getNombreEquipo(), puntuacion2));
        resultado.append(String.format("⚽ GANADOR: %s\n", ganador.getNombreEquipo()));
        resultado.append("Jugadores del equipo ganador:\n");

        for (JugadorInazuma jugador : ganador.getMiembros().values()) {
            resultado.append("  - ").append(jugador.getNombre()).append("\n");
        }

        return resultado.toString();
    }
}