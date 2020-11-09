package mastermind;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Juego;
import Modelo.MockTeclado;

public class TecladoTest {

	
	Juego juegoTest = new Juego();
	
	@Test public void IntroducirColumnaTest() {		
		
		MockTeclado teclado = new MockTeclado();
		int columna_1 = teclado.IntroducirColumna();		
		assertEquals(columna_1,1);
		int columna_2 = teclado.IntroducirColumna();		
		assertEquals(columna_2,2);
		
		
	}
	
	
	
}
