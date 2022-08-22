package controlador;

import dao.ClienteImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Cliente;
import modelo.Ubigeo;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.primefaces.component.export.ExcelOptions;
import org.primefaces.component.export.PDFOptions;
import org.primefaces.component.export.PDFOrientationType;

@Named(value = "ClienteC")
@SessionScoped
public class ClienteC implements Serializable {

    private Cliente cli;
    private Cliente climodificar;
    private ClienteImpl dao;
    private List<Cliente> listadoClientes;

    public ClienteC() {
        dao = new ClienteImpl();
        listadoClientes = new ArrayList<>();
        cli = new Cliente();
        climodificar = new Cliente();
    }

    public void obtenerCod() {
        System.out.println(cli.getUbigeo().getIdubi());
    }

    public void registrar() throws Exception {
        try {
            if (!dao.existe(cli, listadoClientes)) {
                cli.setNombre(caseMayuscula(cli.getNombre()));
                cli.setApellidos(caseMayuscula(cli.getApellidos()));
                dao.registrar(cli);
                limpiar();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
                listar();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "DNI duplicado"));
            }
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            cli.setNombre(caseMayuscula(cli.getNombre()));
            cli.setApellidos(caseMayuscula(cli.getApellidos()));
            dao.modificar(climodificar);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(Cliente cli) throws Exception {
        try {
            System.out.println(cli.getIdcli());
            dao.eliminar(cli);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }

    public void limpiar() throws Exception {
        try {
            cli = new Cliente();
        } catch (Exception e) {
            LogManager lgmngr = LogManager.getLogManager();
            Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
            log.log(Level.INFO, "Error en ClienteC/Limpiar: {0}", e.getMessage());
        }
    }

//    @SuppressWarnings("unchecked")
    public void listar() {
        try {
            listadoClientes = dao.listar();
            for (Cliente listadoCliente : listadoClientes) {
                System.out.println(listadoClientes);

            }
        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }

    public void REPORTE_PDF_ADQUISICION(String CodigoUsuario) throws Exception {

        ClienteImpl ProductoImpl = new ClienteImpl();
        try {
            Map<String, Object> parameters = new HashMap();
            parameters.put(null, CodigoUsuario); //Insertamos un parametro
            ProductoImpl.REPORTE_PDF_PRODUCTO(parameters); //Pido exportar Reporte con los parametros
        } catch (Exception e) {
            throw e;
        }
    }

    public String caseMayuscula(String camelcase) {
        char ch[] = camelcase.toCharArray();
        for (int i = 0; i < camelcase.length(); i++) {
            if (i == 0 && ch[i] != ' ' || ch[i] != ' ' && ch[i - 1] == ' ') {  // Si se encuentra el primer carácter de una palabra
                if (ch[i] >= 'a' && ch[i] <= 'z') {      // Si está en minúsculas
                    ch[i] = (char) (ch[i] - 'a' + 'A');  // Convertir en mayúsculas
                }
            } // Si aparte del primer carácter cualquiera está en mayúsculas
            else if (ch[i] >= 'A' && ch[i] <= 'Z') {     // Convertir en minúsculas
                ch[i] = (char) (ch[i] + 'a' - 'A');
            }
        }
        String st = new String(ch);
        camelcase = st;
        return camelcase;
    }

    @PostConstruct
    public void construir() {
        listar();
        listUbi();
    }

    public static void main(String[] args) {
        ClienteC C = new ClienteC();
        C.listar();
    }
    // métodos generados

    public ClienteImpl getDao() {
        return dao;
    }

    public void setDao(ClienteImpl dao) {
        this.dao = dao;
    }

    public List<Cliente> getListadoCli() {
        return listadoClientes;
    }

    public void setListadoCli(List<Cliente> listaClientes) {
        this.listadoClientes = listadoClientes;
    }
    private List<Ubigeo> LstUbi;
    private String ubi;

    public List<Ubigeo> getLstUbi() {
        return LstUbi;
    }

    public void setLstUbi(List<Ubigeo> LstUbi) {
        this.LstUbi = LstUbi;
    }

    public String getUbi() {
        return ubi;
    }

    public void setUbi(String Ubi) {
        this.ubi = Ubi;
    }

    public void listUbi() {
        try {
            LstUbi = dao.listUbi();

        } catch (Exception e) {
            ;
        }
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Cliente getClimodificar() {
        return climodificar;
    }

    public void setClimodificar(Cliente climodificar) {
        this.climodificar = climodificar;
    }

    public void customizationOptions() {
        ExcelOptions xls = new ExcelOptions();
        xls.setFacetBgColor("#19C7FF");
        xls.setFacetFontSize("10");
        xls.setFacetFontColor("#FFFFFF");
        xls.setFacetFontStyle("BOLD");
        xls.setCellFontColor("#000000");
        xls.setCellFontSize("8");
        xls.setFontName("Verdana");

        PDFOptions pdf = new PDFOptions();
        pdf.setFacetBgColor("#19C7FF");
        pdf.setFacetFontColor("#000000");
        pdf.setFacetFontStyle("BOLD");
        pdf.setCellFontSize("12");
        pdf.setFontName("Courier");
        pdf.setOrientation(PDFOrientationType.LANDSCAPE);
    }
}
