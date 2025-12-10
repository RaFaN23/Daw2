public interface IJugadorInazuma {
    String getNombre();
    void setNombre(String nombre);
    String getAlias();
    boolean isEsTitular();
    void setEsTitular(boolean esTitular);
    String getPosicion();
    void setPosicion(String posicion);
    String getEquipo();
    void setEquipo(String equipo);
    double getPoder();
    void setPoder(double poder);

    @Override
    String toString();
}