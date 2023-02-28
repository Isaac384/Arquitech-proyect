package datos;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class usuario {
    public void crearUser() {
    String url = "jdbc:mysql://localhost:3306/isaacbd";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();

            String sql = "CREATE USER 'pedro'@'%' IDENTIFIED BY '123'";
            stmt.executeUpdate(sql);

           String sql1 = "CREATE USER 'isaac'@'%' IDENTIFIED BY '123'";
            stmt.executeUpdate(sql1);

            System.out.println("Usuarios creados correctamente.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }    
    }
    public void crearProce(){
        String url = "jdbc:mysql://localhost:3306/isaacbd";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();

            String sql = "GRANT EXECUTE ON PROCEDURE isaacbd.sp_cre_isaacbd TO 'pedro'@'%'";
            stmt.executeUpdate(sql);

            String sql2 = "GRANT EXECUTE ON PROCEDURE isaacbd.sp_upd_isaacbd TO 'pedro'@'%'";
            stmt.executeUpdate(sql2);

            String sql3 = "GRANT EXECUTE ON PROCEDURE isaacbd.sp_del_isaacbd TO 'pedro'@'%'";
            stmt.executeUpdate(sql3);

            String sql4 = "GRANT SELECT ON isaacbd.vc_tab TO 'pedro'@'%'";
            stmt.executeUpdate(sql4);

            String sql5 = "GRANT ALL PRIVILEGES ON isaacbd.* TO 'isaac'@'%'";
	    stmt.executeUpdate(sql5);

            System.out.println("Permisos otorgados correctamente.\n\n");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
