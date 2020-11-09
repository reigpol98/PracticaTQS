package Modelo;

public class Juego {
	
	public static int fila = 10;
	public static int columna = 10;
	public static int longitudCodigoSecreto = 5;
	public static int longitudCodigo = 7;	
	public String[][] tablero;
	public String codigo[];
	public String codigoSecreto[];
	String vacio = "-";
	String acierto = "O";
	String casi_acierto = "X";

	public Juego() {
		
		tablero = new String[fila][columna];
		codigo = new String[longitudCodigo];
		codigoSecreto = new String[longitudCodigoSecreto];
		
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
		
		
		for (int i=0; i<longitudCodigoSecreto; i++){ 
			
			 char codigAscii =  (char) Math.floor(Math.random()*(72 - 65)+65); 
			 String codiAscii = Character.toString(codigAscii);
			 codigoSecreto[i]= codiAscii;
			         
			} 
		return codigoSecreto; 
	}
	
	
	/**
	 * Genera las letras possibles que se podran introducir
	 * 
	 * Codigo = {A,B,C,D,E,F,G}
	 * 
	 * @return
	 */
	public String[] GenerarCodigoGama(){	        
		
		
		for (int i=0; i<longitudCodigo; i++) {
			
			 int codigAscii = (int)Math.floor(65+i);
			 String codiAscii = Character.toString(codigAscii);
			 codigo[i]= codiAscii;
			
			
		}
		  return codigo; 
	}
	
	/**
	 * Verifca que la columna introducida sea entre los limites 1-5
	 * 	  
	 * @return
	 */
	public boolean VerificaLimitesColumna(int columna) {		
		
		if (columna>-1 && columna<5) {
			
			
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
	public boolean VerificaLetra(String letra) {
		
		boolean letra_correcta = false;		
		
		for (int i=0; i<longitudCodigo; i++) {			
			
			if (codigo[i].equals(letra))  {
				
				letra_correcta = true;
				
			}	
		}
		
		return letra_correcta;		
	}
	
	
	/**
	 * Genera la Pista en funcion de codigo introducido en cada fila
	 * 
	 * @param fila
	 */
	public void GenerarPista(int fila) {
		
		for (int i=0; i<longitudCodigoSecreto; i++) {		
			
			if (LetraPosicionCorrecto(fila, i)) {
				
				setCasilla(fila, i+longitudCodigoSecreto, acierto);
				
			}
			
		}
		
		for (int i=0; i<longitudCodigo-1; i++) {		
			
			if (LetraCasiCorrecto(fila, i)) {
				
				setCasilla(fila, i+longitudCodigoSecreto, casi_acierto);
				
			}
			
		}
		
		
		
	}
	
	/**
	 * Verifica si la posicion en la que se ha introducido la letra coincide con la posicion y letra del codigo secreto.
	 * 
	 * @return
	 */
	public boolean LetraPosicionCorrecto(int fila, int columna) {
		
		boolean letraPosicion_correcto = false;	
		String letra = getCasilla(fila,columna);
			
			if (codigoSecreto[columna].equals(letra))  {
				
				letraPosicion_correcto = true;		
			
		}
		
		return letraPosicion_correcto;	
		
		
	}
	
	
	public boolean LetraCasiCorrecto(int fila, int columna) {
		
		boolean letra_correcto = false;	
		String letra = getCasilla(fila,columna);
		
		for (int i = 0; i<longitudCodigoSecreto; i++) {
			
			if ((codigoSecreto[i].equals(letra)) && (!getCasilla(fila,columna+5).equals(acierto)) ) {				
				
				letra_correcto = true;						
			}		
			
		}
		
		return letra_correcto;	
	}
	
	/**
	 * Verificamos si la Pista es toda aciertos ('O') para controlar el final de la partida
	 * @param fila
	 * @return
	 */
	public boolean FinalPartida(int fila) {
		
		
		boolean fin = false;	
		String letra = getCasilla(fila,columna);
		for (int i = 0; i<longitudCodigoSecreto; i++) {			
			if (codigoSecreto[columna+longitudCodigoSecreto].equals(acierto))  {
				
				fin = true;		
			
			}
		}
		
		return fin;	
		
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
