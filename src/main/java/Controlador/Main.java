package Controlador;


import Modelo.Juego;
import Vista.Teclado;
import Vista.Tablero;


public class Main {
		
	public Juego j = new Juego();
	Tablero t = new Tablero();
	static Teclado e = new Teclado();
			
			
	public int control = 0;	
	public	int fila = 9;
	public int columna = 0;
	String letra;
	public static void setTeclat(Teclado tec) {e = tec;}	
	
	
	public void InicializarJuego() {
		
		j.InicializarTablero();
		j.GenerarCodigoGama();
		j.GenerarCodigoSecreto();
	
	}
	
	public void BucleJuego() {
		
		//System.out.print(GamaColor);
		
		
		while(fila>-1) {
								
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
						
						System.out.print("\n Color Incorrecto! Debe de ser{A,B,C,D,E,F,G} \n");
						
					}
				}else {
				
					System.out.print("\n Esta posicion ya esta Ocupada! \n");
				}
			
			}else {
				
				System.out.print("\n Columna incorrecta, debe ser entre 1-5 \n");
				
			}
				
			
			if (control==5) {
						
				j.GenerarPista(fila);					
				control = 0;
				fila = fila-1;			
						
			}		
			
		}
		
		
	}	

}