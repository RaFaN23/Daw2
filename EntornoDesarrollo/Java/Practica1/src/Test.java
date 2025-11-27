public class Test {
    public static void main(String[] args){
        Fecha f = new fechampl(1,2,2025);
        Persona p = new PersonaImpl("Jose Ignacio","Naranjo Garcia","12335k",35);
        vuelo v=new tipoVuelo("IB123","Almonte",500.1,200,193,f,p);
        System.out.println(v);
    }
}