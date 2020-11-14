package mastermind;
import Modelo.Juego;
import Modelo.MockTeclado;

import org.junit.Test;

import Controlador.Main;
import Vista.Teclado;
public class MainTest {
	
	
	/**
	 * Test: FinPartida()
	 * 
	 * Tipo: Caja Blanca (Loop Testing)
	 * 
	 * 
	 */
	@Test public void BucleJuegoTest() {
		
		
		Main mainTest = new Main();
		Juego juegoTest = new Juego();
		TecladoTest tecladoTest = new TecladoTest();
		MockTeclado MockTeclado = new MockTeclado();
		
		//1er IF (False) 4rto IF (True)
		mainTest.fila = 0;
		mainTest.control = 5;		
		((Main) mainTest).setTeclat(MockTeclado);
		mainTest.InicializarJuego();
		mainTest.BucleJuego();
		
		
		//1er IF (True) 2n IF (False) 4IF (True)		
		mainTest.fila = 0;
		mainTest.control = 5;
		((Main) mainTest).setTeclat(MockTeclado);
		mainTest.j.setCasilla(0, 0, "A");
		mainTest.BucleJuego();
		
		//1er IF (True) 2n IF (True)  3IF (False) 4IF (True)		
		mainTest.fila = 0;
		mainTest.control = 5;
		((Main) mainTest).setTeclat(MockTeclado);		
		mainTest.BucleJuego();
		
		
		//1er IF (True) 2n IF (True) 3IF (True)	4IF (True)	
		mainTest.fila = 0;
		mainTest.control = 4;
		((Main) mainTest).setTeclat(MockTeclado);		
		mainTest.BucleJuego();
		
	
		
		
		
	
		
	}
		

}
