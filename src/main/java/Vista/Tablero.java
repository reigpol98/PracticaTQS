package Vista;


/**
 * Classe que imlpementa los Prints para dibujar el Tablero por pantalla.
 * @author Victor
 */
public class Tablero {
	
	/**
	 * Atributos
	 */
	static int fila = 10;
	static int columna = 10;
	
	/**
	 * Constructor
	 */
	public Tablero() {	}	
	
	/**
	 * Printa el tablero en la pantalla 
	 */
	public void DibujaTablero(String tauler[][]) {
		
		System.out.print("\n");
		System.out.print("| 1 | 2 | 3 | 4 | 5 ||| A | B | C | D | E |\n");
		System.out.print("------------------------------------------- \n");	
		
		for (int i = 0; i < fila; i++) {				
			
			for (int j = 0; j < columna; j++) {									
		
				
				System.out.print("|" + " " + tauler[i][j] + " ");
				
				if (j==(columna/2)-1)
				{					
					System.out.print("|" + "|" );					
				}
				
				if(j==columna-1) {
					System.out.print("|");
					System.out.print("\n+---+---+---+---+---+++---+---+---+---+---+");					
				}
			}
			
			System.out.print("\n");			
		}		
		System.out.print("\n Letras = {A,B,C,D,E,F,G} \n");	
	}
}