package Modelo;


import Vista.Teclado;



/**
 * Classe que implementa la simulacion de los caracteres port teclado
 * @author Victor
 *
 */
public class MockTeclado extends Teclado {

	private int i = 0;
	private int j = 0;
	private int columnas[] = {-1,1,2,3};
	private String letras[] = {"H","A"};
	
	public int IntroducirColumna() {		
		
		int columna = columnas[i];
		i++;
		if (i>4) {
			i=0;
		}		
		return columna;
		
		
	}		
		
	
	
	public String IntroducirLetra() {
		
		
		String letra = letras[j];
		j++;
		if (j>6) {
			j=0;
		}
		return letra;
		
		
	}		
}
	
	
	

