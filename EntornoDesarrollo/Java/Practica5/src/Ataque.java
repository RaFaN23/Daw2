public class Ataque implements AtaqueInterface {
    private String nombre;
    private int danio;

    public Ataque(String nombre, int danio) {
        this.nombre = nombre;
        this.danio = danio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    @Override
    public String toString() {
        return nombre + ", " + danio;
    }
}