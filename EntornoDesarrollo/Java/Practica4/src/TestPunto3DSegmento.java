public class TestPunto3DSegmento {
    public static void main(String[] args) {
        Punto3D punto1 = new Punto3D(1.0, 2.0, 3.0);
        Punto3D punto2 = new Punto3D(4.0, 6.0, 9.0);

        System.out.println("Punto 1: " + punto1.toString());
        System.out.println("Punto 2: " + punto2.toString());
        System.out.println("Distancia entre puntos: " + punto1.distancia(punto2));

        punto1.setX(2.0);
        punto1.setY(3.0);
        punto1.setZ(4.0);
        System.out.println("\nPunto 1 modificado: " + punto1.toString());
        System.out.println("Nueva distancia: " + punto1.distancia(punto2));

        Segmento segmento = new Segmento(punto1, punto2);
        System.out.println("\nSegmento: " + segmento.toString());
        System.out.println("Longitud del segmento: " + segmento.longitud());

        Punto3D punto3 = new Punto3D(0.0, 0.0, 0.0);
        segmento.setExtremo1(punto3);
        System.out.println("\nSegmento con extremo1 modificado: " + segmento.toString());
        System.out.println("Nueva longitud: " + segmento.longitud());
    }
}