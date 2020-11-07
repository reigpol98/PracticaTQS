package Modelo;

public class Juego {
	
	public static int fila = 10;
	public static int columna = 10;
	public static int longitudCodigo = 7;
	public String[][] tablero;
	public String codigo[];
	String vacio = "0";

	public Juego() {
		
		tablero = new String[fila][columna];
		codigo = new String[longitudCodigo];
		
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
	
	/**
	 * Genera las letras possibles que se podran introducir
	 * 
	 * Codigo = {A,B,C,D,E,F}
	 * 
	 * @return codigo
	 */
	public String[] GenerarCodigoGama(){	        
		
		int inc = 0;
		for (int i=0; i<longitudCodigo; i++) {
			
			 int codigAscii = (int)Math.floor(65+inc);
			 String codiAscii = Character.toString(codigAscii);
			 codigo[i]= codiAscii;
			 inc ++;
			
		}
		  return codigo; 
	}
	
		
	
	public String getCodigo(int i) {
		
		String letra = codigo[i];	
		return letra;
		
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
