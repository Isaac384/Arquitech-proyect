package negocio;
import java.sql.*;
import java.util.Scanner;
import datos.crud;

public class operaciones{
	crud crud = new crud();
	Scanner leer = new Scanner(System.in);

	public void insertar(){
		System.out.println("Ingresa los datos a continuaci\u00f3n\n\nAlumno: ");
		String msg = leer.nextLine();
		crud.agregar(msg);
	}

	public void consultar(){
		crud.mostrar();
		}

	public void actualizar(){
		crud.mostrar();
		System.out.println("Nuevo nombre: ");
		String msg = leer.nextLine();
		System.out.println("Qu\u00e9 registro deseas actualizar: ");
		int num = leer.nextInt();
		crud.modificar(msg,num);
	}

	public void eliminar(){
		crud.mostrar();
		System.out.println("Qu\u00e9 registro deseas eliminar: ");
		int num = leer.nextInt();
		crud.borrar(num);
		

	}


}