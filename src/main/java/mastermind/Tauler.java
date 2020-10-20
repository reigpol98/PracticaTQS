package mastermind;

public class Tauler {
	
	static int fila = 10;
	static int columna = 10;
	char[][] tauler;
	
	
	public Tauler() {
		
		tauler = new char[fila][columna];
	}
	
	
	public void InicialitzarTauler() {
		
		tauler[0][0] = 0;
		
	}
	
	
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}




}