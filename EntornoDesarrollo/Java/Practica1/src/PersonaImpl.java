public class PersonaImpl implements Persona{
    private String nombre;
    private String apellidos;
    private String DNI;
    private Integer edad;

    public PersonaImpl(String nom,String ape,String dni1, Integer e1){
        nombre=nom;
        apellidos=ape;
        DNI=dni1;
        edad=e1;
    }


    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String n) {
        nombre=n;
    }

    @Override
    public String getApellido() {
        return apellidos;
    }

    @Override
    public void setApellido(String ap) {

    }

    @Override
    public String getDni() {
        return DNI;
    }

    @Override
    public Integer getEdad() {
        return edad;
    }

    @Override
    public void setEdad(Integer e) {
        edad=e;
    }

    public String toString(){
        return getNombre()+" "+getApellido()+", "+getDni()+", "+getEdad()+" años";
    }
}
