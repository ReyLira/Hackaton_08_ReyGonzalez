package controlador;

import dao.SubfamiliaImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Familia;
import modelo.Subfamilia;

@Named(value = "subfamiliaC")
@SessionScoped
public class SubFamiliaC implements Serializable {

    private SubfamiliaImpl dao;
    private Subfamilia subfamilia;
    private Subfamilia subfamiliamodificar;
    private List<Subfamilia> listado;

    public SubFamiliaC() {
        subfamilia = new Subfamilia();
        dao = new SubfamiliaImpl();
        subfamiliamodificar = new Subfamilia();
        listado = new ArrayList<>();
    }

    @PostConstruct
    public void onInit() {
        // Si quieres que la lista se inicie en otros controladores debes declararlo en funcionamiento para luego usarlo y no demorarse horas
        try {

            listar();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void registrarproductos() {
        try {
            dao.registrar(subfamilia);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado", "Se registro correctamente"));
            limpiar();
            this.listar();

        } catch (Exception e) {
            System.out.println("Error al registarC" + e.getMessage());
        }
    }

    public void editar() {
        try {
            dao.modificar(subfamiliamodificar);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificado", "Se modificó correctame"));
            limpiar();
            this.listar();
        } catch (Exception e) {
            System.out.println("Error al editarC" + e.getMessage());
        }
    }

    public void eliminar(Subfamilia pro) {
        try {

            dao.eliminar(pro);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Se elimino correctame"));
            this.listar();
        } catch (Exception e) {
            System.out.println("Error al eliminarC" + e.getMessage());
        }
    }

    public void limpiar() {
        dao = new SubfamiliaImpl();
    }

    public void listar() {
        try {
            listado = new ArrayList<>();
            listado = dao.listar();

        } catch (Exception e) {
        }
    }

    private List<Familia> listFam;
    private String Fam;

    public void listFam() throws Exception {

        try {
            listFam = dao.listFam();
        } catch (Exception e) {
            ;
        }
    }

    public SubfamiliaImpl getDao() {
        return dao;
    }

    public void setDao(SubfamiliaImpl dao) {
        this.dao = dao;
    }

    public Subfamilia getSubfamilia() {
        return subfamilia;
    }

    public void setSubfamilia(Subfamilia subfamilia) {
        this.subfamilia = subfamilia;
    }

    public Subfamilia getSubfamiliamodificar() {
        return subfamiliamodificar;
    }

    public void setSubfamiliamodificar(Subfamilia subfamiliamodificar) {
        this.subfamiliamodificar = subfamiliamodificar;
    }

    public List<Subfamilia> getListado() {
        return listado;
    }

    public void setListado(List<Subfamilia> listado) {
        this.listado = listado;
    }

    public List<Familia> getListFam() {
        return listFam;
    }

    public void setListFam(List<Familia> listFam) {
        this.listFam = listFam;
    }

    public String getFam() {
        return Fam;
    }

    public void setFam(String Fam) {
        this.Fam = Fam;
    }
}
