public class Cancion implements CancionInterface {
    private String nombre;
    private String interprete;
    private int duracion;
    private Fecha fechaLanzamiento;
    private String genero;
    private int numeroDeReproducciones;
    private double calificacion;
    private boolean reproducir;

    public Cancion(String nombre, String interprete, int duracion, Fecha fechaLanzamiento, String genero) {
        this.nombre = nombre;
        this.interprete = interprete;
        this.duracion = duracion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.numeroDeReproducciones = 0;
        this.calificacion = 0.0;
        this.reproducir = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInterprete() {
        return interprete;
    }

    public int getDuracion() {
        return duracion;
    }

    public Fecha getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public int getNumeroDeReproducciones() {
        return numeroDeReproducciones;
    }

    public void setNumeroDeReproducciones(int numeroDeReproducciones) {
        this.numeroDeReproducciones = numeroDeReproducciones;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isReproducir() {
        return reproducir;
    }

    public void setReproducir(boolean reproducir) {
        this.reproducir = reproducir;
    }

    @Override
    public String toString() {
        return "[" + nombre + ", " + interprete + "]";
    }
}