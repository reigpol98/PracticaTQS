package mastermind;

public class Tablero {
	
	static int fila = 10;
	static int columna = 10;
	String[][] tablero;
	String vacio = "0";
	
	/**
	 * Constructor
	 */
	public Tablero() {
		
		tablero = new String[fila][columna];
	}
	
	
	/**
	 * Inicializa el tablero a vacio = 0
	 */
	public void InicializarTablero() {
		
		for (int i=0; i<fila; i++) {
			for (int j=0; j<columna;j++) {
			
				setCasilla(i,j,vacio);
			}
		}
		
	}
	
		
	
	public void setCasilla(int i, int j, String vacio ) {
		
		tablero[i][j] = vacio;
	
	}
	
	public String getCasilla(int i, int j) {
		
		return tablero[i][j];
	}
	
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}




}