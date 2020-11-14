package Vista;

import java.util.Scanner;
/**
 * Classe que implementa los metodos para la intereccion con el usuario.
 * @author Victor
 *
 */
public class Teclado {
	
	/**
	 * Atributo
	 */
	static Scanner sn = new Scanner(System.in);	
	
	/**
	 * Constructor
	 */
	public Teclado() {		
		
	}
	
	/**
	 * Printa por pantalla el mensaje de introducir Columna y espera a que el usuario la introduzca.
	 * @return
	 */
	public int IntroducirColumna() {
		
	
		System.out.print("\n Introduce una columna 1-5:");		
		int columna = sn.nextInt();	
		return columna;
	}
	
	/**
	 * Printa por pantalla el mensaje de introducir Letra y espera a que el usuario la introduzca.
	 * @return
	 */
	public String IntroducirLetra() {
		
		System.out.print("\n Introduce una Letra:");
		String letra = sn.next();			
		return letra;	
	}
	
}