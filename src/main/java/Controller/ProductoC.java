package Controller;

import dao.ProductoImpl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Producto;

@Named(value = "productoC")
@SessionScoped
public class ProductoC implements Serializable {

    private Producto producto;
    private ProductoImpl dao;
    private List<Producto> lstProducto;
    private int estado = 1;

    public ProductoC() {
        producto = new Producto();
        dao = new ProductoImpl();
    }

    public void registrar() throws Exception {
        try {
            if (!dao.existe(producto, lstProducto)) {
                dao.guardar(producto);
                listar();
                limpiar();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado", "Registrado con éxito"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO", "¡El producto ya se registro!"));
            }
        } catch (Exception e) {
            LogManager lgmngr = LogManager.getLogManager();
            Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
            log.log(Level.INFO, "Error en ClienteC/registrar: {0}", e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(producto);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificado", "Registrado con éxito"));
        } catch (Exception e) {
            LogManager lgmngr = LogManager.getLogManager();
            Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
            log.log(Level.INFO, "Error en modificar ProductoC: {0}", e.getMessage());
        }
    }

    public void eliminar() throws Exception {
        try {
            dao.eliminar(producto);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Eliminado", "Eliminado con éxito"));
        } catch (Exception e) {
            LogManager lgmngr = LogManager.getLogManager();
            Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
            log.log(Level.INFO, "Error en eliminar ProductoC: {0}", e.getMessage());
        }
    }

    public void cambiarestado() throws Exception {
        try {
            dao.cambiarEstado(producto);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Restaurado", "Restaurado con éxito"));
        } catch (Exception e) {
            LogManager lgmngr = LogManager.getLogManager();
            Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
            log.log(Level.INFO, "Error en ProductoC/Restaurar: {0}", e.getMessage());
        }
    }

    public void listar() throws Exception {
        try {
            lstProducto = dao.listar(estado);
        } catch (Exception e) {
            LogManager lgmngr = LogManager.getLogManager();
            Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
            log.log(Level.INFO, "Error en listar ProductoC: {0}", e.getMessage());
        }
    }

    public void limpiar() throws Exception {
        try {
            producto = new Producto();
        } catch (Exception e) {
            LogManager lgmngr = LogManager.getLogManager();
            Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
            log.log(Level.INFO, "Error en  ProductoC/limpiar: {0}", e.getMessage());
        }
    }

    public void REPORTE_PDF_ADQUISICION(String CodigoUsuario) throws Exception {

        ProductoImpl ProductoImpl = new ProductoImpl();
        try {
            Map<String, Object> parameters = new HashMap();
            parameters.put(null, CodigoUsuario); //Insertamos un parametro
            ProductoImpl.REPORTE_PDF_PRODUCTO(parameters); //Pido exportar Reporte con los parametros
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ProductoImpl getDao() {
        return dao;
    }

    public void setDao(ProductoImpl dao) {
        this.dao = dao;
    }

    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
}
