public class Segmento implements SegmentoInterface {
    private Punto3D extremo1;
    private Punto3D extremo2;

    public Segmento(Punto3D extremo1, Punto3D extremo2) {
        this.extremo1 = extremo1;
        this.extremo2 = extremo2;
    }

    public Punto3D getExtremo1() {
        return extremo1;
    }

    public void setExtremo1(Punto3D extremo1) {
        this.extremo1 = extremo1;
    }

    public Punto3D getExtremo2() {
        return extremo2;
    }

    public void setExtremo2(Punto3D extremo2) {
        this.extremo2 = extremo2;
    }

    public double longitud() {
        return extremo1.distancia(extremo2);
    }

    @Override
    public String toString() {
        return "[" + extremo1.toString() + ", " + extremo2.toString() + "]";
    }
}