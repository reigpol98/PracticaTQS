package Modelo;

/**
 * MockObject de la classe Aleatorio. Simula la generacion de letras alatorias.
 * Mediante esta funcion se controla el test de las funciones que usan letras aleatorias.
 * @author Victor-1456556
 */

public class MockAleatorio extends Aleatorio {
	
	private int i = 0;
	private String LetrasAleatorias[] = {"A","B","C","D","E","F","G","B","D","E","G","A","C"};
	
	public String GenerarLetrasAleatorias() {	
		
		String letra = LetrasAleatorias[i];
		i++;		
		return letra;		
		
		
	}
	
	
	
}
