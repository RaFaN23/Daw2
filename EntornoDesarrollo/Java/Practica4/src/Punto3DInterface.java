public interface Punto3DInterface {
    double getX();
    void setX(double x);
    double getY();
    void setY(double y);
    double getZ();
    void setZ(double z);
    double distancia(Punto3D otro);
    String toString();
}