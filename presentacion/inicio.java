package presentacion;
import presentacion.*;
import datos.crear;
import datos.usuario;

public class inicio{
   public static void main(String []args){
   	
		crear creater = new crear();
		
		menu padre = new menu();

		creater.instaciar();
		
		padre.mostrarMenu();
	
  }
}