public class Fecha {
    public int dia;
    public int mes;
    public int anio;

    public Fecha(int D, int M, int A) {
        this.dia = D;
        this.mes = M;
        this.anio = A;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return "Fecha "+getDia()+"/"+getMes()+"/"+getAnio();
    }
}


