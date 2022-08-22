package modelo;

public class Subfamilia {

    private Integer IDSUBFAM;
    private String NOMSUBFAM;
    private String DESSUBFAM;
    private Integer STOCKSUBFAM;
    private Double PRESUBFAM;
    private Familia familia = new Familia();
    private Sucursal sucursal = new Sucursal();

    public Subfamilia(Integer IDSUBFAM, String NOMSUBFAM, String DESSUBFAM, Integer STOCKSUBFAM, Double PRESUBFAM, Familia familia, Sucursal sucursal) {
        this.IDSUBFAM = IDSUBFAM;
        this.NOMSUBFAM = NOMSUBFAM;
        this.DESSUBFAM = DESSUBFAM;
        this.STOCKSUBFAM = STOCKSUBFAM;
        this.PRESUBFAM = PRESUBFAM;
        this.familia = familia;
        this.sucursal = sucursal;
    }

    public Subfamilia() {
    }

    public Integer getIDSUBFAM() {
        return IDSUBFAM;
    }

    public void setIDSUBFAM(Integer IDSUBFAM) {
        this.IDSUBFAM = IDSUBFAM;
    }

    public String getNOMSUBFAM() {
        return NOMSUBFAM;
    }

    public void setNOMSUBFAM(String NOMSUBFAM) {
        this.NOMSUBFAM = NOMSUBFAM;
    }

    public String getDESSUBFAM() {
        return DESSUBFAM;
    }

    public void setDESSUBFAM(String DESSUBFAM) {
        this.DESSUBFAM = DESSUBFAM;
    }

    public Integer getSTOCKSUBFAM() {
        return STOCKSUBFAM;
    }

    public void setSTOCKSUBFAM(Integer STOCKSUBFAM) {
        this.STOCKSUBFAM = STOCKSUBFAM;
    }

    public Double getPRESUBFAM() {
        return PRESUBFAM;
    }

    public void setPRESUBFAM(Double PRESUBFAM) {
        this.PRESUBFAM = PRESUBFAM;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
