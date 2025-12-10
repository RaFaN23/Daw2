public class Pokemon implements PokemonInterface {
    private int numero;
    private String nombre;
    private String descripcion;
    private double altura;
    private double peso;
    private String genero;
    private String tipo;

    public Pokemon(int numero, String nombre, String descripcion, double altura, double peso, String genero, String tipo) {
        this.numero = numero;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }
}