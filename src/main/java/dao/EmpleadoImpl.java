package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

public class EmpleadoImpl extends Conexion implements ICRUD<Empleado> {

    @Override
    public void registrar(Empleado obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar(Empleado obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Empleado obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cambiarEstado(Empleado obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Empleado> listar() throws Exception {
        List<Empleado> listado = null;
        Empleado emp;
        String sql = "SELECT IDEMP, NOMEMP,APEEMP,DNIEMP,TELFEMP,ESTEMP FROM EMPLEADO \n"
                + "WHERE ESTEMP ='A'";
        try {
            listado = new ArrayList<>();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                emp = new Empleado();
                emp.setIDEMP(rs.getInt("IDEMP"));
                emp.setNOMEMP(rs.getString("NOMEMP"));
                emp.setAPEEMP(rs.getString("APEEMP"));
                emp.setDNIEMP(rs.getString("DNIEMP"));
                emp.setTELFEMP(rs.getString("TELFEMP"));
                emp.setESTEMP(rs.getString("ESTEMP"));
                listado.add(emp);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error al listar Todos" + e.getMessage());
        } finally {
            this.cerrar();
        }
        return listado;
    }

    @Override
    public List<Empleado> listarTodos(char estado) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
