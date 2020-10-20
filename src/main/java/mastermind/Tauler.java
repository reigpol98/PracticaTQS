package mastermind;

public class Tauler {
	
	static int fila = 10;
	static int columna = 10;
	char[][] tauler;
	char buit = 0;
	
	
	public Tauler() {
		
		tauler = new char[fila][columna];
	}
	
	
	/**
	 * Inicializa el tablero a buit = 0
	 */
	public void InicialitzarTauler() {
		
		for (int i=0; i<fila; i++) {
			for (int j=0; j<columna;j++) {
			
				setCasella(i,j,buit);
			}
		}
		
	}
	
	
	
	public void setCasella(int i, int j, char buit ) {
		
		tauler[i][j] = buit;
	
	}	
	
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}




}