public class TestCancion {
    public static void main(String[] args) {
        Fecha fecha = new Fecha(15, 6, 2021);
        Cancion cancion = new Cancion("Bohemian Rhapsody", "Queen", 354, fecha, "Rock");

        System.out.println("Nombre: " + cancion.getNombre());
        System.out.println("Intérprete: " + cancion.getInterprete());
        System.out.println("Duración: " + cancion.getDuracion() + " segundos");
        System.out.println("Fecha Lanzamiento: " + cancion.getFechaLanzamiento());
        System.out.println("Género: " + cancion.getGenero());
        System.out.println("Reproducciones iniciales: " + cancion.getNumeroDeReproducciones());
        System.out.println("Calificación inicial: " + cancion.getCalificacion());
        System.out.println("Reproduciendo inicial: " + cancion.isReproducir());
        System.out.println("ToString: " + cancion.toString());

        cancion.setNumeroDeReproducciones(1000);
        cancion.setCalificacion(9.5);
        cancion.setReproducir(true);

        System.out.println("\nDespués de modificar:");
        System.out.println("Reproducciones: " + cancion.getNumeroDeReproducciones());
        System.out.println("Calificación: " + cancion.getCalificacion());
        System.out.println("Reproduciendo: " + cancion.isReproducir());
    }
}