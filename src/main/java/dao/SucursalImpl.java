package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Sucursal;
import modelo.Ubigeo;

public class SucursalImpl extends Conexion implements ICRUD<Sucursal> {

    @Override
    public void registrar(Sucursal obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(Sucursal obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Sucursal obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cambiarEstado(Sucursal obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Sucursal> listar() throws Exception {
        List<Sucursal> listado = null;
        Sucursal sucursal;
        String sql = "SELECT IDSUR,NOMSUR,UBIGEO.CODUBI,UBIGEO.DISUBI,UBIGEO.PROUBI,UBIGEO.DEPUBI FROM SUCURSAL inner join UBIGEO ON SUCURSAL.CODUBI=UBIGEO.CODUBI";
        try {
            listado = new ArrayList<>();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                sucursal = new Sucursal();
                sucursal.setIDSUR(rs.getInt("IDSUR"));
                sucursal.setNOMSUR(rs.getString("NOMSUR"));
                Ubigeo ubigeo = new Ubigeo();
                ubigeo.setIdubi(rs.getString("CODUBI"));
                ubigeo.setDepubi(rs.getString("DEPUBI"));
                ubigeo.setProubi(rs.getString("PROUBI"));
                ubigeo.setDisubi(rs.getString("DISUBI"));
                sucursal.setUbigeo(ubigeo);
                listado.add(sucursal);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en ListarTodosD" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }

    @Override
    public List<Sucursal> listarTodos(char estado) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
