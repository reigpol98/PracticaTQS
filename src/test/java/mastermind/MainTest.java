package mastermind;

import org.junit.Test;

import Controlador.Main;

public class MainTest {
	
	
	/**
	 * Test: FinPartida()
	 * 
	 * Tipo: Caja Blanca (Loop Testing)
	 * 
	 * 
	 */
	@Test public void GenerarPistaTest() {
		
		
		Main mainTest = new Main();
		
		
		mainTest.fila = 0;
		mainTest.BucleJuego();
		mainTest.fila = -1;
		mainTest.BucleJuego();
		
		
	
		
	}
		

}
