package mastermind;
import Modelo.Juego;
import Modelo.MockTeclado;
import org.junit.Test;
import Controlador.Main;
import Vista.Teclado;

/**
 * Classe que implementa los Test del Main().
 * @author Victor
 */
public class MainTest {
	
	
	/**
	 * Test: BucleJuego()
	 * 
	 * Tipo: Caja Blanca (Path Coverage)
	 * 
	 * Explicacion: Se verifican que se pasa por todos los caminos del metodo. 
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