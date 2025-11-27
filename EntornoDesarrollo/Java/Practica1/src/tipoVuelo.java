public class tipoVuelo  implements vuelo{

    //Atributo variable
    private String codigoVuelo;
    private String destino;
    private Double precio;
    private Integer numeroPlazas;
    private Integer numeroPasajeros;
    private Fecha fechaSalida;
    private Persona Piloto;
    //Contructores

    public tipoVuelo(String codigoVuelo, String destino, Double precio, Integer numeroPlazas, Integer numeroPasajeros, Fecha fechaSalida, Persona piloto) {
        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        this.precio = precio;
        this.numeroPlazas = numeroPlazas;
        this.numeroPasajeros = numeroPasajeros;
        this.fechaSalida = fechaSalida;
        Piloto = piloto;
    }
    //getter y setters
    @Override
    public String getcodigoVuelo() {
        return codigoVuelo;
    }

    @Override
    public String getdestino() {
        return destino;
    }

    @Override
    public double getprecio() {
        return precio;
    }

    @Override
    public void setprecio(double pr) {
        precio = pr;
    }

    @Override
    public Integer getnumeroPlazas() {
        return numeroPlazas;
    }

    @Override
    public Integer getnumeroPasajero() {
        return numeroPasajeros;
    }

    @Override
    public void setnumeroPasajero(Integer np) {
        numeroPasajeros = np;
    }

    @Override
    public Fecha getFechaSalida() {
        return fechaSalida;
    }

    @Override
    public Persona getPiloto() {
        return Piloto;
    }

    @Override
    public void setPiloto() {

    }

    @Override
    public void setPiloto(Persona p) {
        Piloto=p;
    }



    //derivadas
    public double recaudacion(){
        return getprecio()*getnumeroPlazas();
    }

    //toString
    public String toString(){
        return getcodigoVuelo()+ "("+getdestino()+")"+getPiloto()+"-" + getFechaSalida();
    }
}
