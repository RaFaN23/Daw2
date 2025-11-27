public class Cancion {
    //atributo
    private String Nombre;
    private String Interprete;
    private Integer Duracion;
    private Fecha FechaLanzamiento;
    private String Genero;
    private Integer NumeroReproducciones;
    private double Calificaciones;
    private Boolean Reproducir;
    //Constructores

    public Cancion(String nombre, String interprete, Integer duracion,
                   Fecha fechaLanzamiento, String genero) {
        this.Nombre = nombre;
        this.Interprete = interprete;
        this.Duracion = duracion;
        this.FechaLanzamiento = fechaLanzamiento;
        this.Genero = genero;
        this.NumeroReproducciones = 0;
        this.Calificaciones = 0.0;
        this.Reproducir = false;
    }

    //getter y setters

    public String getNombre() {
        return Nombre;
    }

    public String getInterprete() {
        return Interprete;
    }

    public Integer getDuracion() {
        return Duracion;
    }

    public Fecha getFechaLanzamiento() {
        return FechaLanzamiento;
    }

    public String getGenero() {
        return Genero;
    }

    public Integer getNumeroReproducciones() {
        return NumeroReproducciones;
    }

    public double getCalificaciones() {
        return Calificaciones;
    }

    public Boolean getReproducir() {
        return Reproducir;
    }

    //derivadas


    //toString

    @Override
    public String toString() {
        return "[" + Nombre + ", " + Interprete + "]";
    }


    public void setNumeroDeReproducciones(int i) {
    }

    public void setCalificacion(double v) {
    }

    public void setReproducir(boolean b) {
    }
}
