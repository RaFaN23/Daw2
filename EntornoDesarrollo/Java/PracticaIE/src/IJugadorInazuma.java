public interface IJugadorInazuma {

    String getNombre();
    String getAlias();
    boolean isEsTitular();
    String getPosicion();
    String getEquipo();
    double getPoder();


    void setNombre(String nombre);
    void setEsTitular(boolean esTitular);
    void setPosicion(String posicion);
    void setEquipo(String equipo);
    void setPoder(double poder);

    String toString();
}