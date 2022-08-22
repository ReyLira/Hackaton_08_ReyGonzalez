package controlador;

import dao.EmpleadoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import modelo.Empleado;

@Named(value = "empleadoC")
@SessionScoped
public class EmpleadoC implements Serializable {

    private Empleado ven;
    private Empleado venmodificar;
    private EmpleadoImpl dao;
    private List<Empleado> listadoVendedor;

    public EmpleadoC() {
        dao = new EmpleadoImpl();
        listadoVendedor = new ArrayList<>();
        ven = new Empleado();
        venmodificar = new Empleado();
    }

    public void listar() {
        try {
            listadoVendedor = dao.listar();
            for (Empleado listadoVendedor : listadoVendedor) {
                System.out.println(listadoVendedor);
            }
        } catch (Exception e) {
            System.out.println("Error al listar C" + e.getMessage());
        }
    }

    @PostConstruct
    public void construir() {
        listar();
    }

    public Empleado getVen() {
        return ven;
    }

    public void setVen(Empleado ven) {
        this.ven = ven;
    }

    public Empleado getVenmodificar() {
        return venmodificar;
    }

    public void setVenmodificar(Empleado venmodificar) {
        this.venmodificar = venmodificar;
    }

    public EmpleadoImpl getDao() {
        return dao;
    }

    public void setDao(EmpleadoImpl dao) {
        this.dao = dao;
    }

    public List<Empleado> getListadoVendedor() {
        return listadoVendedor;
    }

    public void setListadoVendedor(List<Empleado> listadoVendedor) {
        this.listadoVendedor = listadoVendedor;
    }
}
