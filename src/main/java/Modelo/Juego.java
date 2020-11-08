package Modelo;

public class Juego {
	
	public static int fila = 10;
	public static int columna = 10;
	public static int longitudCodigo = 6;
	public String[][] tablero;
	public String codigo[];
	public String codigoSecreto[];
	String vacio = "0";

	public Juego() {
		
		tablero = new String[fila][columna];
		codigo = new String[longitudCodigo];
		codigoSecreto = new String[longitudCodigo];
		
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
	 * Genera aleatoriamente el CodigoSecreto mediante el codigo Ascii (65=A,66=B,67=C,68=D,69=E,70=F)
	 * 
	 * @return
	 */
	public String[] GenerarCodigoSecreto(){	        
		
		
		for (int i=0; i<longitudCodigo; i++){ 
			
			 char codigAscii =  (char) Math.floor(Math.random()*(71 - 65)+65); 
			 String codiAscii = Character.toString(codigAscii);
			 codigoSecreto[i]= codiAscii;
			         
			} 
		return codigoSecreto; 
	}
	
	
	/**
	 * Genera las letras possibles que se podran introducir
	 * 
	 * Codigo = {A,B,C,D,E,F}
	 * 
	 * @return
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
	
	/**
	 * Verifca que la columna introducida sea entre los limites 1-5
	 * 	  
	 * @return
	 */
	public boolean VerificaLimitesColumna(int columna) {		
		
		if (columna>0 && columna<6) {
			
			
			return true;
		}
			
			return false;
		
	}
	
	/**
	 * Verifica que la columna introducida por el usuario este libre
	 * 
	 * @param fila
	 * @param columna
	 * @return
	 */
	public boolean VerificaPosicionOcupada(int fila, int columna) {	
			
		if (getCasilla(fila, columna).equals(vacio)) {
			
			return false;
			
		}else {
			
			return true;
			
		}			
	
	}	
	
	
	/**
	 * Verifica si la letra introducida es correcta (Mayusculas)
	 * 
	 * {A,B,C,D,E,F}
	 *  
	 *  @return
	 */
	public Boolean VerificaLetra(String letra) {
		
		boolean letra_correcta = false;		
		
		for (int i=0; i<longitudCodigo; i++) {			
			
			if (codigo[i].equals(letra))  {
				
				letra_correcta = true;
				
			}	
		}
		
		return letra_correcta;		
	}
	
	
	
	/**
	 * 
	 * Getters y Setters 
	 * 
	 */
	
	public String getCodigoSecreto(int i) {
		
		String letra = codigoSecreto[i];	
		return letra;
		
	}
	
	public String getCodigo(int i) {
		
		String letra = codigo[i];	
		return letra;
		
	}
	
	public String[][] getTablero() {
		
		return tablero;
		
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
