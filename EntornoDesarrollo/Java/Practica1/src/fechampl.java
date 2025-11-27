public class fechampl implements Fecha{
    private Integer dia;
    private Integer mes;
    private Integer ano;

    public fechampl(Integer d, Integer m, Integer a){
        dia=d;
        mes=m;
        ano=a;
    }
    public Integer getDia() {
        return dia;
    }
    public Integer getMes() {
        return mes;
    }
    public Integer getAno() {
        return ano;
    }

    public String toString(){
        return getDia()+"/"+getMes()+"/"+getAno();
    }
}
