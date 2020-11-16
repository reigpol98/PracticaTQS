package Modelo;
import Vista.Teclado;

/**
 * MockObject de la classe de Teclado. 
 * Simula la intereccion del usuario a la hora de introducir Columnas y Letras.
 * Mediante estas dos funciones se controlan los tests de las funciones que usan la interecion con el usuario.
 * @author Victor-1456556
 *
 */

public class MockTeclado extends Teclado {

	private int i = 0;
	private int j = 0;
	private int columnas[] = {-1,1,2,3,1,2,3,4,5};
	private String letras[] = {"H","A","A","B","C","D","E","F","G"};
	
	public int IntroducirColumna() {		
		
		int columna = columnas[i];
		i++;				
		return columna;		
	}			
	
	
	public String IntroducirLetra() {
		
		String letra = letras[j];
		j++;		
		return letra;
		
		
	}		
}
	
	
	

