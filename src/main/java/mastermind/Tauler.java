package mastermind;

public class Tauler {
	
	static int fila = 10;
	static int columna = 10;
	String tauler[][];
	
	public Tauler() {
		
		tauler = new String[fila][columna];
	}

	
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}




}
