package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    public static Connection cnx = null;

    public static Connection conectar() throws Exception {
        try {
            String user = "sa";
            String pwd = "@abc123@";
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost;databaseName=dbPizzaHut";
            Class.forName(driver).newInstance();
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión, revisa");
            System.out.println("Error de conexion " + e.getMessage());
        }
        return cnx;
    }

    public void cerrar() throws Exception {
        if (cnx != null) {
            cnx.close();
        }
    }

    public static void main(String[] args) throws Exception {
        conectar();
        if (cnx != null) {
            System.out.println("Conexión Correcta");
        } else {
            System.out.println("Error Fallo en la Conexión");
        }
    }
}
