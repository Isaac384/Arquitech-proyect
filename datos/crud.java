package datos;
import java.sql.*;
import java.util.Scanner;
public class crud{
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/isaacbd";
	String user = "root", password = "";
	Scanner leer = new Scanner(System.in);
	public void agregar(String msg){
		try{
			conn = DriverManager.getConnection(url,user,password);
			Statement sentencia = conn.createStatement();
			//sentencia.executeUpdate("INSERT INTO alumno VALUES(null,'"+ msg +"')");
			CallableStatement cs = conn.prepareCall("{call sp_cre_isaacbd(?)}");
			// Establecer el valor del parámetro
			cs.setString(1, msg);

			// Ejecutar el procedimiento almacenado
			cs.execute();

			System.out.println("\nRegistro insertado correctamente");
		}catch(SQLException e){
			System.out.println("Error "+e.getMessage());
		}

	}
	public void mostrar(){
		try{
			conn = DriverManager.getConnection(url,user,password);
			Statement sentencia = conn.createStatement();
			//String query = "SELECT * FROM alumno";
			// Crear una sentencia SQL para seleccionar los registros de la vista
			String sql = "SELECT * FROM vc_tab";

			// Crear un objeto Statement para ejecutar la sentencia SQL
			Statement statement = conn.createStatement();

			// Ejecutar la sentencia SQL y obtener un objeto ResultSet con los resultados
			ResultSet datos = statement.executeQuery(sql);

			//ResultSet datos = sentencia.executeQuery(query);
			System.out.println("---------- Los registros son los siguientes ----------");
			System.out.println("//////////////////////////////////////////////////////////\n//\t\t\tID\tDATOS\t\t\t//");
			while(datos.next()){
				int id_one = datos.getInt("id");
				String mensajes_one = datos.getString("mensaje");
				System.out.println("//\t\t\t"+id_one + "\t" + mensajes_one+"\t\t\t//");
			}
			System.out.println("//////////////////////////////////////////////////////////\n");
			
		}catch(SQLException e){
			System.out.println("Error "+e.getMessage());
		}

	}

	public void modificar(String msg, int num){
		try{
			conn = DriverManager.getConnection(url,user,password);
			Statement sentencia = conn.createStatement();
			//sentencia.executeUpdate("UPDATE alumno SET mensaje = '"+ msg +"' WHERE id = '"+ num +"' ");
			// Crear un objeto CallableStatement para llamar al procedimiento almacenado
			CallableStatement cs = conn.prepareCall("{call sp_upd_isaacbd(?, ?)}");

			// Establecer los valores de los parámetros
			cs.setInt(1, num);
			cs.setString(2, msg);

			// Ejecutar el procedimiento almacenado
			cs.execute();
			System.out.println("\nRegistro modificado correctamente");
		}catch(SQLException e){
			System.out.println("Error "+e.getMessage());
		}

	}

	public void borrar(int num){
		
		try{
			conn = DriverManager.getConnection(url,user,password);
			Statement sentencia = conn.createStatement();
			//sentencia.executeUpdate("DELETE FROM alumno WHERE id = '"+ num +"'");
			// Crear un objeto CallableStatement para llamar al procedimiento almacenado
			CallableStatement cs = conn.prepareCall("{call sp_del_isaacbd(?)}");

			// Establecer los valores de los parámetros
			cs.setInt(1, num);

			// Ejecutar el procedimiento almacenado
			cs.execute();

			System.out.println("\nRegistro eliminado correctamente");
		}catch(SQLException e){
			System.out.println("Error "+e.getMessage());
		}

	}
}