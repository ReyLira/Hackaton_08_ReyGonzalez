package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Familia;
import modelo.Subfamilia;

public class SubfamiliaImpl extends Conexion implements ICRUD<Subfamilia> {

    @Override
    public void registrar(Subfamilia subfam) throws Exception {
        String sql = "INSERT INTO SUBFAMILIA (NOMSUBFAM,DESSUBFAM,STOCKSUBFAM,PRESUBFAM,IDFAM,IDSUR) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pr = this.conectar().prepareStatement(sql);
            pr.setString(1, subfam.getNOMSUBFAM());
            pr.setString(2, subfam.getDESSUBFAM());
            pr.setInt(3, subfam.getSTOCKSUBFAM());
            pr.setDouble(4, subfam.getPRESUBFAM());
            pr.setInt(5, subfam.getFamilia().getIDFAM());
            pr.setInt(6, subfam.getSucursal().getIDSUR());
            pr.executeUpdate();
            pr.close();
        } catch (Exception e) {
            System.out.println("Error al registar ProductosImpl" + e.getMessage());
        } finally {
            this.cerrar();
        }

    }

    @Override
    public void modificar(Subfamilia subfam) throws Exception {
        String sql = "UPDATE SUBFAMILIA SET NOMSUBFAM=?,STOCKSUBFAM=?,PRESUBFAM=?,DESSUBFAM=?,IDFAM=?,IDSUR WHERE IDSUBFAM=?";
        try {
            PreparedStatement pr = this.conectar().prepareStatement(sql);
            pr.setString(1, subfam.getNOMSUBFAM());
            pr.setInt(2, subfam.getSTOCKSUBFAM());
            pr.setDouble(3, subfam.getPRESUBFAM());
            pr.setString(4, subfam.getDESSUBFAM());
            pr.setInt(5, subfam.getFamilia().getIDFAM());
            pr.setInt(6, subfam.getSucursal().getIDSUR());
            pr.setInt(7, subfam.getIDSUBFAM());
            pr.executeUpdate();
            pr.close();
        } catch (Exception e) {
            System.out.println("Error en modificar en los campos ProductosImpl" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Subfamilia subfam) throws Exception {
        String sql = "delete from SUBFAMILIA SET  WHERE IDSUBFAM=?";

        try {
            PreparedStatement pr = this.conectar().prepareStatement(sql);
            pr.setInt(1, subfam.getIDSUBFAM());
            pr.executeUpdate();
            pr.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar el ProductosImpl" + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void cambiarEstado(Subfamilia obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Subfamilia> listar() throws Exception {
        List<Subfamilia> listado = new ArrayList<>();
        Subfamilia subfamilia;
        String sql = "	SELECT IDSUBFAM,NOMSUBFAM, STOCKSUBFAM, PRESUBFAM,DESSUBFAM,FAMILIA.IDFAM,FAMILIA.NOMFAM,FAMILIA.DESFAM FROM SUBFAMILIA  "
                + "INNER JOIN FAMILIA\n"
                + "ON FAMILIA.IDFAM = SUBFAMILIA.IDFAM\n"
                + "ORDER BY IDSUBFAM desc";

        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                subfamilia = new Subfamilia();
                subfamilia.setIDSUBFAM(rs.getInt("IDSUBFAM"));
                subfamilia.setNOMSUBFAM(rs.getString("NOMSUBFAM"));
                subfamilia.setSTOCKSUBFAM(rs.getInt("STOCKSUBFAM"));
                subfamilia.setPRESUBFAM(rs.getDouble("PRESUBFAM"));
                subfamilia.setDESSUBFAM(rs.getString("DESSUBFAM"));
                Familia familia = new Familia();
                familia.setIDFAM(rs.getInt("IDFAM"));
                familia.setNOMFAM(rs.getString("NOMFAM"));
                familia.setDESFAM(rs.getString("DESFAM"));
                subfamilia.setFamilia(familia);
                listado.add(subfamilia);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error al listar ProductosImpl" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }

    @Override
    public List<Subfamilia> listarTodos(char estado) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String obtenerIDFAM(String cadenacat) throws SQLException, Exception {
        String sql = "SELECT IDFAM FROM dbo.FAMILIA WHERE (NOMFAM)= '?' OR IDFAM ='?'";
        try {
            PreparedStatement pr = this.conectar().prepareCall(sql);
            pr.setString(1, cadenacat);
            pr.setString(2, cadenacat);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                return rs.getString("IDFAM");

            }
            return rs.getString("IDMAR");
        } catch (Exception e) {
            System.out.println("Error al obtenerID de la Familia" + e.getMessage());
            throw e;
        }
    }

    public List<Familia> listFam() throws Exception {
        List<Familia> lista;
        ResultSet rs;
        Familia familia;
        try {
            familia = new Familia();
            String sql = "SELECT IDFAM,NOMFAM,DESFAM FROM FAMILIA";
            PreparedStatement ct = this.conectar().prepareStatement(sql);
            rs = ct.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                familia = new Familia(rs.getInt(1), rs.getString(2), rs.getString(3));
                lista.add(familia);

            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public List<Familia> listSur() throws Exception {
        List<Familia> lista;
        ResultSet rs;
        Familia familia;
        try {
            familia = new Familia();
            String sql = "SELECT IDSUR,NOMSUR,CODUBI FROM SUCURSAL";
            PreparedStatement ct = this.conectar().prepareStatement(sql);
            rs = ct.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                familia = new Familia(rs.getInt(1), rs.getString(2), rs.getString(3));
                lista.add(familia);

            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public String obtenerIDSUR(String cadenacat) throws SQLException, Exception {
        String sql = "SELECT IDSUR FROM dbo.SUCURSAL WHERE (NOMSUR)= '?' OR IDSUR ='?'";
        try {
            PreparedStatement pr = this.conectar().prepareCall(sql);
            pr.setString(1, cadenacat);
            pr.setString(2, cadenacat);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                return rs.getString("IDSUR");

            }
            return rs.getString("IDSUR");
        } catch (Exception e) {
            System.out.println("Error al obtenerID de la SUCURSAL" + e.getMessage());
            throw e;
        }
    }
}
