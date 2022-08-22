package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Ubigeo;

public class UbigeoImpl extends Conexion {

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

}
