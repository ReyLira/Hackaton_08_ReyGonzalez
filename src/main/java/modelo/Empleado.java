package modelo;

public class Empleado {

    private Integer IDEMP;
    private String NOMEMP;
    private String APEEMP;
    private String DIRECEMP;
    private String DNIEMP;
    private String TELFEMP;
    private String TIPEMP;
    private String ESTEMP;
    private Sucursal sucursal = new Sucursal();

    public Integer getIDEMP() {
        return IDEMP;
    }

    public void setIDEMP(Integer IDEMP) {
        this.IDEMP = IDEMP;
    }

    public String getNOMEMP() {
        return NOMEMP;
    }

    public void setNOMEMP(String NOMEMP) {
        this.NOMEMP = NOMEMP;
    }

    public String getAPEEMP() {
        return APEEMP;
    }

    public void setAPEEMP(String APEEMP) {
        this.APEEMP = APEEMP;
    }

    public String getDIRECEMP() {
        return DIRECEMP;
    }

    public void setDIRECEMP(String DIRECEMP) {
        this.DIRECEMP = DIRECEMP;
    }

    public String getDNIEMP() {
        return DNIEMP;
    }

    public void setDNIEMP(String DNIEMP) {
        this.DNIEMP = DNIEMP;
    }

    public String getTELFEMP() {
        return TELFEMP;
    }

    public void setTELFEMP(String TELFEMP) {
        this.TELFEMP = TELFEMP;
    }

    public String getTIPEMP() {
        return TIPEMP;
    }

    public void setTIPEMP(String TIPEMP) {
        this.TIPEMP = TIPEMP;
    }

    public String getESTEMP() {
        return ESTEMP;
    }

    public void setESTEMP(String ESTEMP) {
        this.ESTEMP = ESTEMP;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

}
