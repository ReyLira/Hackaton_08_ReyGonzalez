package controlador;

import dao.UbigeoImpl;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.Ubigeo;

@Named(value = "UbigeoC")
@SessionScoped
public class UbigeoC implements Serializable {

    private List<Ubigeo> lstubi;
    private Ubigeo ubigeo;
    private UbigeoImpl dao;

    public UbigeoC() {
        dao = new UbigeoImpl();
        ubigeo = new Ubigeo();

    }

    @PostConstruct
    public void lista() {
        try {
            lstubi = dao.listUbi();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Ubigeo> getLstubi() {
        return lstubi;
    }

    public void setLstubi(List<Ubigeo> lstubi) {
        this.lstubi = lstubi;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

}
