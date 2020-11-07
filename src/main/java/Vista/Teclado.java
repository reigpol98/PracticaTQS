package Vista;

import java.util.Scanner;

public class Teclado {

	static Scanner sn = new Scanner(System.in);	
	
	public Teclado() {		
		
	}
	
	public int IntroducirColumna() {
		
		System.out.print("\n Introduce una columna 1-5:");		
		int columna = sn.nextInt();	
		return columna;
	}
	
	
	
}
