package mastermind;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import Modelo.Juego;
import Modelo.MockTeclado;

/**
 * Classe que implementa los Test de la classe Teclado().
 * @author Victor-1456556
 */

public class TecladoTest {
	
	Juego juegoTest = new Juego();
	MockTeclado MockTeclado = new MockTeclado();
	
	/**
	 * Test: IntroducirColumna
	 * 
	 * Tipo: MockObject()
	 * 
	 * Explicacion: Comprueba que la columna que nos retorna el Mock (simulacion como si fuera el usuario) es correcta.
	 */
	@Test public void IntroducirColumnaTest() {	
		
		//Necesario para el Test del main
		int columna = MockTeclado.IntroducirColumna();		
		assertEquals(columna,-1);
		columna = MockTeclado.IntroducirColumna();		
		assertEquals(columna,1);
		columna = MockTeclado.IntroducirColumna();		
		assertEquals(columna,2);
		columna = MockTeclado.IntroducirColumna();		
		assertEquals(columna,3);
		
		for (int i=1; i<6; i++) {
			
			columna = MockTeclado.IntroducirColumna();		
			assertEquals(columna,i);			
		}		
	}
	
	
	/**
	 * Test: IntroducirLetra
	 * 
	 * Tipo: MockObject()
	 * 
	 * Explicacion: Comprueba que la letra que nos retorna el Mock (simulacion como si fuera el usuario) es correcta.
	 */
	@Test public void IntroducirLetraTest() {	
		
		//Necesario para el Test del main
		String letra = MockTeclado.IntroducirLetra();
		assertEquals(letra,"H");
		letra = MockTeclado.IntroducirLetra();
		assertEquals(letra,"A");		
		
		for (int i=0; i<5; i++) {
			
			int codigAscii = (int)Math.floor(65+i);
			String compruebaLetra = Character.toString(codigAscii);	
			letra = MockTeclado.IntroducirLetra();		
			assertEquals(letra,compruebaLetra);
			
		}	
	}
	
}
