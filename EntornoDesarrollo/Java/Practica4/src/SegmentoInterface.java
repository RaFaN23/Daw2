public interface SegmentoInterface {
    Punto3D getExtremo1();
    void setExtremo1(Punto3D extremo1);
    Punto3D getExtremo2();
    void setExtremo2(Punto3D extremo2);
    double longitud();
    String toString();
}