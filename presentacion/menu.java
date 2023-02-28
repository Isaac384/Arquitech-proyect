package presentacion;
import java.util.Scanner;
import datos.*;
import datos.crear;
import negocio.operaciones;
public class menu{

	public void mostrarMenu(){
		Scanner leer = new Scanner(System.in);
		System.out.println("////////////!BIENVENIDO!////////////\n\n ---------- Programa para guardar nombres de alumnos ----------\n\n");
		System.out.println("Ingresa el usuario: ");
   		String user = leer.nextLine();
   		System.out.println("Ingresa la contrase\u00f1a: ");
   		String password = leer.nextLine();
		
		if (user.equals("pedro") && password.equals("123")){
		int num = 0;
		while (num != 5){
			System.out.println("\n---------- Selecciona una opci\u00f3n ----------\n 1.Insertar nombre\n 2.Mostrar nombres\n 3.Editar nombre\n 4.Eliminar nombre\n 5.Salir\n");
			num = leer.nextInt();
			switch (num)
			{
				case 1:
				operaciones uno = new operaciones();
				uno.insertar();
				break;
				case 2:
				operaciones dos = new operaciones();
				dos.consultar();
				break;
				case 3:
				operaciones tres = new operaciones();
				tres.actualizar();
				break;
				case 4:
				operaciones cuatro = new operaciones();
				cuatro.eliminar();
				break;
				case 5:
				System.out.println("Gracias");
				System.out.println("Nos vemos ");
				break;
				default:
				System.out.println("//////////////////////////////////////////////////////////\n//\t\t\tAVISO!\t\t\t\t//\n//\t\tEsta opcion no esta disponible\t\t//\n//\tPorfavor de seleccionar un opcion valida\t//\n//////////////////////////////////////////////////////////\n");
				break;
			}
		}
		}else{
			System.out.println("//////////////////////////////////////////////////////////\n//\t\t\tAVISO!\t\t\t\t//\n//\tContrase\u00f1a o usuario incorrecto\t\t//\n//\t\t    Acceso denegado\t\t\t//\n//////////////////////////////////////////////////////////\n");
		}	

	}
}