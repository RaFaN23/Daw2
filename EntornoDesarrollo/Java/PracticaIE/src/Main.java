public class Main {
    public static void main(String[] args) {

        JugadorInazuma mark = new JugadorInazuma("Mark Evans", "El Guardián Legendario",
                true, "portero", "Raimon", 8.5);
        JugadorInazuma axel = new JugadorInazuma("Axel Blaze", "El Delantero de Fuego",
                false, "delantero", "Raimon", 9.5);
        JugadorInazuma jude = new JugadorInazuma("Jude Sharp", "El Genio Eterno",
                true, "centrocampista", "Royal Academy", 9.0);
        JugadorInazuma erik = new JugadorInazuma("Erik Eagle", "El Capitán Águila",
                true, "defensa", "Royal Academy", 8.0);


        Equipo raimon = new Equipo("Raimon");
        raimon.agregarMiembro(mark);
        raimon.agregarMiembro(axel);

        Equipo royal = new Equipo("Royal Academy");
        royal.agregarMiembro(jude);
        royal.agregarMiembro(erik);


        System.out.println("=== JUGADORES ===");
        System.out.println(mark);
        System.out.println(axel);
        System.out.println();

        System.out.println("=== EQUIPOS ===");
        System.out.println(raimon);
        System.out.println(royal);
        System.out.println();

        System.out.println("=== PODER DE EQUIPOS ===");
        System.out.printf("Poder medio de Raimon: %.2f\n", raimon.poderDelEquipo());
        System.out.printf("Poder medio de Royal Academy: %.2f\n", royal.poderDelEquipo());
        System.out.println();


        System.out.println("=== SIMULACIÓN DE PARTIDO ===");
        Partido partido = new Partido(raimon, royal);
        System.out.println(partido.simularEnfrentamiento());
    }
}