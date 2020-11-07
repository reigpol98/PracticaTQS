package Controlador;

import Modelo.Juego;
import Vista.Teclado;
import Vista.Tablero;


public class Main {
	
	public static void main(String[] args) {

		Juego j = new Juego();
		Tablero t = new Tablero();
		Teclado e = new Teclado();
		
		j.InicializarTablero();
		t.DibujaTablero(j.getTablero());
		e.IntroducirColumna();
		e.IntroducirLetra();
		
		
	}

	
	

}