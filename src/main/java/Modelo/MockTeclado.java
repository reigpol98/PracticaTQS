package Modelo;
import java.util.ArrayList;
import java.util.Stack;

import Vista.Teclado;



/**
 * Classe que implementa la simulacion de los caracteres port teclado
 * @author Victor
 *
 */
public class MockTeclado extends Teclado {

	private int i = 0;
	private int columnas[] = {1,2};
	
	public int IntroducirColumna() {
		
		
		int columna = columnas[i];
		i++;
		if (i>1) {i=0;}
		return columna;
		
		
	}		
		
}
	
	
	

