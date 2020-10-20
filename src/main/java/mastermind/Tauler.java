package mastermind;

public class Tauler {
	
	static int fila = 10;
	static int columna = 10;
	char[][] tauler;
	
	
	public Tauler() {
		
		tauler = new char[fila][columna];
	}
	
	
	/**
	 * Inicializa el tablero a 0
	 */
	public void InicialitzarTauler() {
		
		for (int i=0; i<fila; i++) {
			for (int j=0; j<columna;j++) {
			
				tauler[i][j] = 0;
			}
		}
		
	}
	
	
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}




}