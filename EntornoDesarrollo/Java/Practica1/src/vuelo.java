public interface vuelo {
    String getcodigoVuelo();
    String getdestino();
    double getprecio();
    void setprecio(double pr);
    Integer getnumeroPlazas();
    Integer getnumeroPasajero();
    void setnumeroPasajero(Integer p);
    Fecha getFechaSalida();
    Persona getPiloto();
    void setPiloto();

    void setPiloto(Persona p);
}
