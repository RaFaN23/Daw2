public class fechampl implements Fecha{
    private Integer dia;
    private Integer mes;
    private  Integer anio;

    @Override
    public Integer getdia() {
        return dia;
    }

    @Override
    public Integer getmes() {
        return mes;
    }

    @Override
    public Integer getanio() {
        return anio;
    }
    public void setdia(Integer dia) {
        this.dia = dia;

    }
    public void setmes(Integer mes) {
        this.mes = mes;
    }
    public void setanio(Integer anio) {
        this.anio = anio;
    }

}
