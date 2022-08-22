package controlador;

import Service.StockS;
import dao.VentaDetalleImpl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.VentaDetalle;

@Named(value = "ventadetalleC")
//@Dependent
@SessionScoped
public class VentaDetalleC implements Serializable {

    private static final long serialVersionUID = 1L;

    private VentaDetalle ventadetalle;
    private VentaDetalleImpl dao;
    private List<VentaDetalle> listadoVentaDetalle;
    private List<VentaDetalle> vendidos;
    private boolean cerrar;

    public VentaDetalleC() {
        ventadetalle = new VentaDetalle();
        dao = new VentaDetalleImpl();
        listadoVentaDetalle = new ArrayList<>();
        vendidos = new ArrayList<>();
    }

    public VentaDetalle getVentadetalle() {
        return ventadetalle;
    }

    public void setVentadetalle(VentaDetalle ventadetalle) {
        this.ventadetalle = ventadetalle;
    }

    public VentaDetalleImpl getDao() {
        return dao;
    }

    public void setDao(VentaDetalleImpl dao) {
        this.dao = dao;
    }

    public List<VentaDetalle> getListadoVentaDetalle() {
        return listadoVentaDetalle;
    }

    public void setListadoVentaDetalle(List<VentaDetalle> listadoVentaDetalle) {
        this.listadoVentaDetalle = listadoVentaDetalle;
    }

    public List<VentaDetalle> getVendidos() {
        return vendidos;
    }

    public void setVendidos(List<VentaDetalle> vendidos) {
        this.vendidos = vendidos;
    }

    public boolean isCerrar() {
        return cerrar;
    }

    public void setCerrar(boolean cerrar) {
        this.cerrar = cerrar;
    }

    @PostConstruct
    public void construir() {
        listar();

    }

    public void registrar() throws Exception {
        try {

            dao.registrarVenta(ventadetalle);
            int idVent = dao.obtenerUltimoId();
            dao.registromultiple(listadoVentaDetalle, idVent);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con Exito"));
            limpiar();
            listar();
            listadoVentaDetalle.clear();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Falta Completar Datos"));
            System.out.println("Error en RegistrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(ventadetalle);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();

        } catch (Exception e) {
            System.out.println("Error en ModificarC " + e.getMessage());
        }
    }

    public void eliminar(VentaDetalle ventadetalle) throws Exception {
        try {
            dao.eliminar(ventadetalle);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "Al Eliminar"));
            System.out.println("Error en EliminarC " + e.getMessage());
        }
    }

    public List<String> completeTextVenta(String query) throws SQLException, Exception {
        VentaDetalleImpl daoVenta = new VentaDetalleImpl();
        return daoVenta.autocompleteVenta(query);
    }

    public List<String> completeTextProducto(String query) throws SQLException, Exception {
        VentaDetalleImpl daoProducto = new VentaDetalleImpl();
        return daoProducto.autocompleteProducto(query);
    }

    public void limpiar() {
        this.ventadetalle = new VentaDetalle();
    }

    public void agregarFila() {

        try {

            VentaDetalle ventadet = dao.agregarFila(ventadetalle.getSubfamilia().getIDSUBFAM(), ventadetalle.getCliente().getIdcli());
            int stock = ventadet.getSubfamilia().getSTOCKSUBFAM();
            if (StockS.validaStock(stock, ventadetalle.getCANTVENDET())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No hay suficiente stock"));
            } else {
                ventadet.setCANTVENDET(this.ventadetalle.getCANTVENDET());
                ventadet.setSubtotal(ventadet.getCANTVENDET() * ventadet.getSubfamilia().getPRESUBFAM());

                this.listadoVentaDetalle.add(ventadet);
                sumar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarFila(VentaDetalle v) {

        listadoVentaDetalle.remove(v);
        ventadetalle = new VentaDetalle();
        sumar();

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado", "Eliminado con éxito"));
    }

    public void REPORTE_PDF_ADQUISICION(String CodigoUsuario) throws Exception {

        VentaDetalleImpl ProductoImpl = new VentaDetalleImpl();
        try {
            Map<String, Object> parameters = new HashMap();
            parameters.put(null, CodigoUsuario); //Insertamos un parametro
            ProductoImpl.REPORTE_PDF_PRODUCTO(parameters); //Pido exportar Reporte con los parametros
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() {
        try {
            vendidos = dao.listar();

        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }

    public void sumar() {
        double precioTotal = 0;
        for (VentaDetalle ventaDetalle : listadoVentaDetalle) {
            precioTotal += ventaDetalle.getSubtotal();
        }
        System.out.println(precioTotal);
        ventadetalle.setTotal(precioTotal);
    }

}
