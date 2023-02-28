package datos;
import java.sql.*;
import datos.usuario;

public class crear{
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "isaacbd";
    String driver = "com.mysql.cj.jdbc.Driver";
    String username = "root";
    String password = "";

  usuario us = new usuario();
    public void instaciar(){
    try{
      Class.forName(driver);
      Connection conn = DriverManager.getConnection(url, username, password);

      // Crear base de datos "isaacbd"
      String createDBQuery = "CREATE DATABASE " + dbName;
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(createDBQuery);

      // Seleccionar la base de datos "isaacbd"
      String useDBQuery = "USE " + dbName;
      stmt.executeUpdate(useDBQuery);

      // Crear tabla "alumno"
      String createTableQuery = "CREATE TABLE alumno (id INT AUTO_INCREMENT, mensaje VARCHAR(50), PRIMARY KEY (id))";
      stmt.executeUpdate(createTableQuery);

      // Agregar procedimiento almacenado "insertar_alumno"
      String storedProcedureQuery = "CREATE PROCEDURE sp_cre_isaacbd(in msg Varchar(50)) BEGIN INSERT INTO alumno(mensaje) VALUES(msg); END;";
      stmt.executeUpdate(storedProcedureQuery);

      // Agregar procidimiento almacenado "actualizar_alumno"
      String storedProcedureQuery2 = "CREATE PROCEDURE sp_upd_isaacbd(in num INT, in msg VARCHAR(50)) BEGIN UPDATE alumno SET mensaje = msg WHERE id = num; END;";
      stmt.executeUpdate(storedProcedureQuery2);

      // Agregar procidimiento almacenado "eliminar_alumno"
      String storedProcedureQuery3 = "CREATE PROCEDURE sp_del_isaacbd(in num INT) BEGIN DELETE FROM alumno WHERE id = num; END;";
      stmt.executeUpdate(storedProcedureQuery3);

      // Crear vista "vista_alumnos"
      String createViewQuery = "CREATE VIEW vc_tab AS SELECT * FROM alumno ";
      stmt.executeUpdate(createViewQuery);

      conn.close();
    }catch (Exception e) {
      e.printStackTrace();
    }
    us.crearUser();
    us.crearProce();
}


}
