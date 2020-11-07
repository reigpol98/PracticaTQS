package mastermind;

public class Tauler {
	
	static int fila = 10;
	static int columna = 10;
	String[][] tauler;
	String buit = "0";
	
	/**
	 * Constructor
	 */
	public Tauler() {
		
		tauler = new String[fila][columna];
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
	
	
	
	public void setCasella(int i, int j, String buit ) {
		
		tauler[i][j] = buit;
	
	}
	
	public String getCasella(int i, int j) {
		
		return tauler[i][j];
	}
	
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}




}