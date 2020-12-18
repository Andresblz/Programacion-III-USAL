package view;

import controller.Controller;
import static com.coti.tools.Esdia.*;

public class View {
	private final Controller c = new Controller();
	
	public void runMenu(String menu) {
		String option;
		boolean salir = false;
		String[] avaibleOptions = {"1", "2", "q"};
		do {
			option = readString(menu, avaibleOptions);
			switch(option) {
				case "1":
					this.darValores();
					break;
				case "2":
					this.mostrarListado();
					break;
				case "q":
				case "Q":
					salir = yesOrNo("Desea realmente salir de la aplicación? ");
					break;
				default:
					System.out.printf("\nERROR: Escoga una opción válida (1, 2, q).");
					break;
			}
		} while(!salir);
	}
	
	public void darValores() {
		c.darValores();
		System.out.printf("\n Se han almacenado %d valores en la lista", c.getNumFacturas());
	}
	
	public void mostrarListado() {
		String[] listado = c.obtenerListado();
		if(null == listado) {
			System.err.printf("\nERROR: no fue posible obtener el listado");
			return;
		}
		
		System.out.printf("\nLISTADO DE FACTURAS\n");
		for(String s : listado) {
			System.out.printf("%s\n", s);
		}
		System.out.printf("\n");
	}
}
