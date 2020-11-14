package mastermind;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Juego;
import Modelo.MockTeclado;

public class TecladoTest {

	
	Juego juegoTest = new Juego();
	MockTeclado MockTeclado = new MockTeclado();
	
	
	@Test public void IntroducirColumnaTest() {		
		
	
		int columna = MockTeclado.IntroducirColumna();		
		assertEquals(columna,-1);
		columna = MockTeclado.IntroducirColumna();		
		assertEquals(columna,1);
		columna = MockTeclado.IntroducirColumna();		
		assertEquals(columna,2);
		columna = MockTeclado.IntroducirColumna();		
		assertEquals(columna,3);
		
	
	}
	
	
	
	
	@Test public void IntroducirLetraTest() {	
		
		
		String letra = MockTeclado.IntroducirLetra();
		assertEquals(letra,"H");
		letra = MockTeclado.IntroducirLetra();
		assertEquals(letra,"A");
			
		
			
			

	

	
}
	
	
	
}
