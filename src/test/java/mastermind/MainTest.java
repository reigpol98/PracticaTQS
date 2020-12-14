package mastermind;

import Modelo.Juego;
import Modelo.MockTeclado;
import org.junit.Test;
import Controlador.Main;

/**
 * Classe que implementa los Test de la classe Main().
 * 
 * @author Victor-1456556
 */
public class MainTest {

	/**
	 * Test: BucleJuego()
	 * 
	 * Tipo: Caja Blanca (Path Coverage)
	 * 
	 * Explicacion: Se verifican que se pasa por todos los caminos del metodo.
	 */
	@Test
	public void BucleJuegoTest() {

		Main mainTest = new Main();
		Juego juegoTest = new Juego();
		TecladoTest tecladoTest = new TecladoTest();
		MockTeclado MockTeclado = new MockTeclado();

		// 1er IF (False) 4rto IF (True)
		mainTest.fila = 0;
		mainTest.control = 5;
		((Main) mainTest).setTeclat(MockTeclado);
		mainTest.InicializarJuego();
		
		// Final partida Ganador
		mainTest.j.setCodigoSecreto(0, "A");
		mainTest.j.setCodigoSecreto(1, "B");
		mainTest.j.setCodigoSecreto(2, "C");
		mainTest.j.setCodigoSecreto(3, "D");
		mainTest.j.setCodigoSecreto(4, "E");
		mainTest.fila = 9;
		mainTest.control = 0;
		((Main) mainTest).setTeclat(MockTeclado);
		mainTest.BucleJuego();
		
		mainTest.BucleJuego();

		// 1er IF (True) 2n IF (False) 4IF (True)
		mainTest.fila = 0;
		mainTest.control = 5;
		((Main) mainTest).setTeclat(MockTeclado);
		// mainTest.j.setCasilla(0, 0, "A");
		mainTest.BucleJuego();

		// 1er IF (True) 2n IF (True) 3IF (False) 4IF (True)
		mainTest.fila = 0;
		mainTest.control = 5;
		((Main) mainTest).setTeclat(MockTeclado);
		mainTest.BucleJuego();

		// 1er IF (True) 2n IF (True) 3IF (True) 4IF (True)
		mainTest.fila = 0;
		mainTest.control = 4;
		((Main) mainTest).setTeclat(MockTeclado);
		mainTest.BucleJuego();
		
		
		
		MockTeclado MockTeclado1 = new MockTeclado();
		// 1er IF (True) 2n IF (False) 4IF (True)
				mainTest.fila = 0;
				mainTest.control = 5;
				((Main) mainTest).setTeclat(MockTeclado1);
				// mainTest.j.setCasilla(0, 0, "A");
				mainTest.BucleJuego();

				// 1er IF (True) 2n IF (True) 3IF (False) 4IF (True)
				mainTest.fila = 0;
				mainTest.control = 5;
				((Main) mainTest).setTeclat(MockTeclado1);
				mainTest.BucleJuego();

				// 1er IF (True) 2n IF (True) 3IF (True) 4IF (True)
				mainTest.fila = 0;
				mainTest.control = 4;
				((Main) mainTest).setTeclat(MockTeclado1);
				mainTest.BucleJuego();

		
	}

}