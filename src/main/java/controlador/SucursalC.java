package controlador;

import dao.SucursalImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.Sucursal;

@Named(value = "sucursalC")
@SessionScoped
public class SucursalC implements Serializable {

    private Sucursal sucursal;
    private SucursalImpl dao;
    private List<Sucursal> listadosucursal;

    public SucursalC() {
        sucursal = new Sucursal();
        dao = new SucursalImpl();
        listadosucursal = new ArrayList<>();
    }

    public void listar() {
        try {
            listadosucursal = dao.listar();
        } catch (Exception e) {
            System.out.println("Error en ListarC" + e.getMessage());
        }
    }

    @PostConstruct
    public void construir() {
        listar();
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public SucursalImpl getDao() {
        return dao;
    }

    public void setDao(SucursalImpl dao) {
        this.dao = dao;
    }

    public List<Sucursal> getListadosucursal() {
        return listadosucursal;
    }

    public void setListadosucursal(List<Sucursal> listadosucursal) {
        this.listadosucursal = listadosucursal;
    }
}
