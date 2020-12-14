package Controlador;
import Modelo.Aleatorio;
import Modelo.Juego;
import Vista.Teclado;
import Vista.Tablero;

/**
 * Classe Main: Es el Controlador que comunica la interaccion entre el moelo y la vista.
 */

public class Main {
		
	
	public static Juego j = new Juego();
	static Tablero t = new Tablero();
	static Aleatorio a = new Aleatorio();
	static Teclado e = new Teclado();			
	public static int control = 0;	
	public static	int fila = 9;
	public static int columna = 0;
	static String letra;
	public static boolean fin = false;
	
	public static void main(String[] args) {
		
		InicializarJuego();
		BucleJuego();
		
	}
	
	/**
	 * Inicializa el Tablero, Genera el CodigoGama y el CodigoSecreto
	 */
	public static void InicializarJuego() {
		
		j.InicializarTablero();
		j.GenerarCodigoGama();
		for (int i=0; i<5; i++) {
		String letra = a.GenerarLetrasAleatorias();
		j.setCodigoSecreto(i, letra);

		
		}	
	}
	
	/**
	 * Control del Juego
	 */
	public static void BucleJuego() {	
		
		while((fila>-1)&&(!fin)) { 								
			t.DibujaTablero(j.getTablero());
			columna = e.IntroducirColumna();			
			columna = columna-1;		
			
			if (j.VerificaLimitesColumna(columna)) {
				
				if (!j.VerificaPosicionOcupada(fila,columna)) {
				
					letra = e.IntroducirLetra();
					
					if (j.VerificaLetra(letra)) {
									
						j.setCasilla(fila, columna, letra);								
						control++;
						
					}else {
						
						System.out.print("\n Letra Incorrecta! Debe de ser {A,B,C,D,E,F,G} \n");
						
					}
				}else {
				
					System.out.print("\n Esta posicion ya esta Ocupada! \n");
				}
			
			}else {
				
				System.out.print("\n Columna incorrecta, debe ser entre 1-5 \n");
				
			}
				
			
			if (control==5) {
						
				j.GenerarPista(fila);
				fin = j.FinalPartida(fila);
				control = 0;
				fila = fila-1;			
						
			}		
			
		}
		t.DibujaTablero(j.getTablero());
		t.DibujaFinal(j.codigoSecreto,fin);
	}
		
	
	public static void setTeclat(Teclado tec) {e = tec;}	

}