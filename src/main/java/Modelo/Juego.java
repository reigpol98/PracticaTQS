package Modelo;

/**
 * Classe en la que se comprenden todos los metodos y atributos para desarrollar el computo del juego. 
 * @author Victor-1456556
 *
 */

public class Juego {
	
	/**
	 * Atributos
	 */
	public static int fila = 10;
	public static int columna = 10;
	public int longitudCodigoSecreto = 5;
	public static int longitudCodigo = 7;	
	public String[][] tablero;
	public String codigo[];
	public String codigoSecreto[];
	public String codigoPista[];
	public String vacio = "-";
	public String acierto = "O";
	public String casi_acierto = "X";
	public String pista = "*";
	public boolean letra_correcto = false;	
	

	/**
	 * Contructor de la classe
	 */
	public Juego() {
		
		tablero = new String[fila][columna];
		codigo = new String[longitudCodigo];
		codigoSecreto = new String[longitudCodigoSecreto];
		codigoPista = new String[longitudCodigoSecreto];		
	}	
	
	/**
	 * Inicializa el tablero a vacio = "-"
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
	 * Codigo = {A,B,C,D,E,F,G}	 
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
	 * Verifca que la columna introducida sea entre los limites [0-4]	  	  
	 * @return
	 */
	public boolean VerificaLimitesColumna(int columna) {		
		
		if (columna>-1 && columna<5) {		
			
			return true;
		}
		
			return false;		
		}
	
	
	/**
	 * Retorna True si la posicion esta ocupada i False si esta vacia	
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
	 * {A,B,C,D,E,F}	 	  
	 * @param letra
	 * @return
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
	 * @param fila
	 */
	public void GenerarPista(int fila) {
		
		for (int i=0; i<longitudCodigoSecreto; i++) {	
			codigoPista[i] = vacio;
		}
		
		for (int i=0; i<longitudCodigoSecreto; i++) {		
			
			if (LetraPosicionCorrecto(fila, i)) {
				
				setCasilla(fila, i+longitudCodigoSecreto, acierto);				
			}			
		}
		
		for (int i=0; i<longitudCodigoSecreto; i++) {	
			
			if (LetraCasiCorrecto(fila, i)) {
				
				setCasilla(fila, i+longitudCodigoSecreto, casi_acierto);				
			}			
		}		
	}	
	
	/**
	 * Retorna True si la posicion en la que se ha introducido la letra coincide con la posicion de la letra del codigo secreto. 
	 * Por lo contrario, retorna False
	 * @param fila
	 * @param columna
	 * @return
	 */	 
	public boolean LetraPosicionCorrecto(int fila, int columna) {
		
		boolean letraPosicion_correcto = false;	
		String letra = getCasilla(fila,columna);
			
		if (codigoSecreto[columna].equals(letra))  {
				
				letraPosicion_correcto = true;	
				codigoPista[columna] = pista;
		}		
		return letraPosicion_correcto;		
	}	
	
	/**
	 * Retorna True si la letra introducida esta en el CodigoSecreto pero en diferente posicion. Por lo contrario, retorna False.
	 * @param fila
	 * @param columna
	 * @return
	 */
	public boolean LetraCasiCorrecto(int fila, int columna) {	
			
		String letra = getCasilla(fila,columna);
		int i = 0;		
		while((i<longitudCodigoSecreto) && (!letra_correcto))
		{
			
			if ((codigoSecreto[i].equals(letra)) && (!getCasilla(fila,columna+5).equals(acierto)) && (!codigoPista[i].equals(pista))) {				
				
				codigoPista[i] = pista;
				letra_correcto = true;			
			}
			
			i++;					
		}				
			
		return letra_correcto;			
			
		}		
	
	/**
	 * Verificamos si la Pista es toda aciertos ('O') para controlar el final de la partida.
	 * @param fila
	 * @return
	 */
	public boolean FinalPartida(int fila) {
		
		int aux=0;
		boolean fin = false;	
		
		for (int i = 0; i<longitudCodigoSecreto; i++) {		
			
			if (getCasilla(fila,i+longitudCodigoSecreto).equals(acierto))  {			
				
				if (aux==4) {
				fin = true;	
				}
				aux++;			
			}
		}
		
		return fin;		
	}	
	
	/**
	 *  
	 * Getters y Setters 
	 * 
	 */	
	public void setCodigoSecreto( int i,String  letra) {
		
	 codigoSecreto[i]= letra;
	 System.out.print("CHIVATO: "+codigoSecreto[i]);
	 
	}
	
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
