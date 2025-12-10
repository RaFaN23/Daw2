public interface CancionInterface {
    String getNombre();
    String getInterprete();
    int getDuracion();
    Fecha getFechaLanzamiento();
    String getGenero();
    int getNumeroDeReproducciones();
    void setNumeroDeReproducciones(int numeroDeReproducciones);
    double getCalificacion();
    void setCalificacion(double calificacion);
    boolean isReproducir();
    void setReproducir(boolean reproducir);
    String toString();
}