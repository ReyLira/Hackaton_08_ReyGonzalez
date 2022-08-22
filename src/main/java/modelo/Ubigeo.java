package modelo;

public class Ubigeo {

    private String idubi;
    private String depubi;
    private String proubi;
    private String disubi;

    public Ubigeo(String idubi, String depubi, String proubi, String disubi) {
        this.idubi = idubi;
        this.depubi = depubi;
        this.proubi = proubi;
        this.disubi = disubi;
    }

    public Ubigeo() {
    }

    public String getIdubi() {
        return idubi;
    }

    public void setIdubi(String idubi) {
        this.idubi = idubi;
    }

    public String getDepubi() {
        return depubi;
    }

    public void setDepubi(String depubi) {
        this.depubi = depubi;
    }

    public String getProubi() {
        return proubi;
    }

    public void setProubi(String proubi) {
        this.proubi = proubi;
    }

    public String getDisubi() {
        return disubi;
    }

    public void setDisubi(String disubi) {
        this.disubi = disubi;
    }

}
