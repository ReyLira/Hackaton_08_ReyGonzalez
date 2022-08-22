package modelo;

public class Familia {

    private Integer IDFAM;
    private String NOMFAM;
    private String DESFAM;

    public Familia(Integer IDFAM, String NOMFAM, String DESFAM) {
        this.IDFAM = IDFAM;
        this.NOMFAM = NOMFAM;
        this.DESFAM = DESFAM;
    }

    public Familia() {
    }

    public Integer getIDFAM() {
        return IDFAM;
    }

    public void setIDFAM(Integer IDFAM) {
        this.IDFAM = IDFAM;
    }

    public String getNOMFAM() {
        return NOMFAM;
    }

    public void setNOMFAM(String NOMFAM) {
        this.NOMFAM = NOMFAM;
    }

    public String getDESFAM() {
        return DESFAM;
    }

    public void setDESFAM(String DESFAM) {
        this.DESFAM = DESFAM;
    }
}
