public class JugadorInazuma implements IJugadorInazuma {
    private String nombre;
    private String alias;
    private boolean esTitular;
    private String posicion;
    private String equipo;
    private double poder;

    public JugadorInazuma(String nombre, String alias, boolean esTitular,
                          String posicion, String equipo, double poder) {
        this.nombre = nombre;
        this.alias = alias;
        this.esTitular = esTitular;
        this.posicion = posicion;
        this.equipo = equipo;
        this.poder = poder;
    }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String getAlias() { return alias; }

    @Override
    public boolean isEsTitular() { return esTitular; }

    @Override
    public void setEsTitular(boolean esTitular) { this.esTitular = esTitular; }

    @Override
    public String getPosicion() { return posicion; }

    @Override
    public void setPosicion(String posicion) { this.posicion = posicion; }

    @Override
    public String getEquipo() { return equipo; }

    @Override
    public void setEquipo(String equipo) { this.equipo = equipo; }

    @Override
    public double getPoder() { return poder; }

    @Override
    public void setPoder(double poder) { this.poder = poder; }

    @Override
    public String toString() {
        String titularidad = esTitular ? "Es titular" : "No es titular";
        return String.format("%s (%s) . Juega como %s en %s. %s. Su poder es de %.1f.",
                nombre, alias, posicion, equipo, titularidad, poder);
    }
}