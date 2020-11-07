package Vista;

public class Tablero {
	
	static int fila = 10;
	static int columna = 10;

	
	/**
	 * Constructor
	 */
	public Tablero() {
		
		
				
	}
	
	
	/**
	 * (VISTA)
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
		
		System.out.print("\n Colores = {A,B,C,D,E,F} \n");	
	}
	
	



}