package controlador;

import dao.FamiliaImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.Familia;

@Named(value = "familiaC")
@SessionScoped
public class FamiliaC implements Serializable {

    private Familia familia;
    private FamiliaImpl dao;
    private List<Familia> listadoFamilia;

    public FamiliaC() {
        familia = new Familia();
        dao = new FamiliaImpl();
        listadoFamilia = new ArrayList<>();
    }

    public void listar() {
        try {
            listadoFamilia = dao.listarTodos();
        } catch (Exception e) {
            System.out.println("Error en ListarC" + e.getMessage());
        }
    }

    @PostConstruct
    public void construir() {
        listar();
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public FamiliaImpl getDao() {
        return dao;
    }

    public void setDao(FamiliaImpl dao) {
        this.dao = dao;
    }

    public List<Familia> getListadoFamilia() {
        return listadoFamilia;
    }

    public void setListadoFamilia(List<Familia> listadoFamilia) {
        this.listadoFamilia = listadoFamilia;
    }
}
