public class Test {
    public static void main(String[] args){
        Fecha f = new Fecha(1, 1, 2019);
        Cancion c = new Cancion("Yeyo", "Sergio", 192, f, "Rock");


        c.setNumeroDeReproducciones(232);
        c.setCalificacion(8.5);
        c.setReproducir(true);

        System.out.println("=== INFORMACIÓN COMPLETA DE LA CANCIÓN ===");
        System.out.println(c);
        System.out.println("==========================================");


        System.out.println("\n=== ACCESO INDIVIDUAL A PROPIEDADES ===");
        System.out.println("Nombre: " + c.getNombre());
        System.out.println("Intérprete: " + c.getInterprete());
        System.out.println("Duración: " + c.getDuracion() + " segundos");
        System.out.println("Fecha: " + c.getFechaLanzamiento());
        System.out.println("Género: " + c.getGenero());
        System.out.println("Reproducciones: " + c.getNumeroReproducciones());
        System.out.println("Calificación: " + c.getCalificaciones() + "/10");
        System.out.println("Reproduciendo: " + c.getReproducir());
    }
}