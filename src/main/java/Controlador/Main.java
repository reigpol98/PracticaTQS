package Controlador;

import Modelo.Juego;
import Vista.Tablero;


public class Main {
	
	public static void main(String[] args) {

		Juego j = new Juego();
		Tablero t = new Tablero();
		
		j.InicializarTablero();
		t.DibujaTablero(j.getTablero());
		
	}

	
	

}