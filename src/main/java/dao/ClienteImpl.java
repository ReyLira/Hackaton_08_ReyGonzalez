package dao;

import static dao.Conexion.conectar;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.Ubigeo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ClienteImpl extends Conexion implements ICRUD<Cliente> {

    @Override
    public void registrar(Cliente cli) throws Exception {

        String sql = "insert into CLIENTE (NOMCLI,APECLI,DNICLI,TELFCLI,DIRECCLI,CODUBI,ESTCLI) values (?,?,?,?,?,?,'A')";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellidos());
            ps.setInt(3, cli.getDni());
            ps.setString(4, cli.getCelular());
            ps.setString(5, cli.getDireccion());
            ps.setString(6, cli.getUbigeo().getIdubi());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Cliente: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    // @Override
    public void modificar(Cliente cli) throws Exception {
        String sql = "update CLIENTE set NOMCLI=?,APECLI=?,DNICLI=?,TELFCLI=?,DIRECCLI=?,CODUBI=?  where IDCLI=? ";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellidos());
            ps.setInt(3, cli.getDni());
            ps.setString(4, cli.getCelular());
            ps.setString(5, cli.getDireccion());
            ps.setString(6, cli.getUbigeo().getIdubi());

            ps.setInt(7, cli.getIdcli());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al Modificar ClienteImpl: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Cliente cli) throws Exception {
        String sql = "UPDATE CLIENTE SET ESTCLI='I' WHERE IDCLI=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, cli.getIdcli());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminarD" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List listar() throws Exception {
        List<Cliente> listado = null;
        Cliente cli;
        String sql = "select IDCLI,NOMCLI,APECLI,DNICLI,TELFCLI,DIRECCLI,UBIGEO.CODUBI,\n"
                + "                UBIGEO.DEPUBI,UBIGEO.PROUBI,UBIGEO.DISUBI, ESTCLI from CLIENTE\n"
                + "                INNER JOIN UBIGEO\n"
                + "                ON UBIGEO.CODUBI = CLIENTE.CODUBI "
                + "where ESTCLI='A'"
                + "order by IDCLI desc";
        //"select c.CODPER,c.NOMPER,c.APEPER,c.DNIPER,c.CELPER,c.DIRECPER";
        // + " from Cliente c INNER JOIN Ubigeo u ON c.CODUBI=u.CODUBI";

        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cli = new Cliente();
                cli.setIdcli(rs.getInt("IDCLI"));
                cli.setNombre(rs.getString("NOMCLI"));
                cli.setApellidos(rs.getString("APECLI"));
                cli.setDni(rs.getInt("DNICLI"));
                cli.setCelular(rs.getString("TELFCLI"));
                cli.setDireccion(rs.getString("DIRECCLI"));
                Ubigeo ubigeo = new Ubigeo();
                ubigeo.setIdubi(rs.getString("CODUBI"));
                ubigeo.setDepubi(rs.getString("DEPUBI"));
                ubigeo.setProubi(rs.getString("PROUBI"));
                ubigeo.setDisubi(rs.getString("DISUBI"));
                cli.setUbigeo(ubigeo);
                cli.setEstado(rs.getString("ESTCLI"));
                listado.add(cli);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error en listarTodosD: " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }

    @Override
    public void cambiarEstado(Cliente obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> listarTodos(char estado) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Ubigeo> listUbi() throws Exception {
        List<Ubigeo> lista;
        ResultSet rs;
        Ubigeo ubigeo;
        try {
            ubigeo = new Ubigeo();
            String sql = "SELECT CODUBI,DEPUBI,PROUBI,DISUBI FROM UBIGEO";
            PreparedStatement pr = this.conectar().prepareStatement(sql);
            rs = pr.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                ubigeo = new Ubigeo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                lista.add(ubigeo);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public boolean existe(Cliente modelo, List<Cliente> listaModelo) {
        for (Cliente cli : listaModelo) {
// 	65789012  ---->	65789011, 65789032, 65789012  
            if (modelo.getDni().equals(cli.getDni())) {
                return true;
            }
        }
        return false;
    }

    public void REPORTE_PDF_PRODUCTO(Map parameters) throws JRException, IOException, Exception {
        conectar();
//        System.out.println(parameters.get("NOMMAR"));
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/Clientes.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.conectar());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=Clientes.pdf");
        try ( ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

}
