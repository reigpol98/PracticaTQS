package mastermind;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaulerTest {
	
	
	Tauler taulerTest = new Tauler();
	
	/*
	 * Test de la funcion Tauler() (Constructor)
	 * 
	 * Test de caja negra para comprovar que la matriz se ha creado correctamente
	 * comprobando sus limites con los getters de fila y columna para ver si se ha 
	 * creado siguiendo las dimensionnes indicadas (fila=10 y columnma =10).
	 * 
	 */
	@Test public void ConstructorTaulerTest() {
		
		assertNotEquals(null,taulerTest.tauler);
		assertEquals(10, taulerTest.getFila());
		assertEquals(10, taulerTest.getColumna());
		assertNotEquals(9, taulerTest.getFila());
		assertNotEquals(9, taulerTest.getColumna());
		assertNotEquals(11, taulerTest.getFila());
		assertNotEquals(11, taulerTest.getColumna());
		 
		 
	 }
	
	/*
	 * Test de la funcion InicializarTauler()
	 * 
	 * Test de caja negra que comprueba si se ha inicializado correctamente la matriz (Tauler).
	 * 
	 */
	@Test public void InicialitzarTaulerTest() {	
				
		taulerTest.InicialitzarTauler();
		
		for (int i=0; i<taulerTest.fila; i++) {
			for (int j=0; j<taulerTest.columna;j++) {
				
				assertNotEquals(null,taulerTest.tauler[i][j]);
				assertNotEquals(i+1,taulerTest.tauler[i][j]);
				assertNotEquals(i+10,taulerTest.tauler[i][j]);
				assertNotEquals(i+20,taulerTest.tauler[i][j]);
				assertNotEquals(i+30,taulerTest.tauler[i][j]);
				assertNotEquals(i+50,taulerTest.tauler[i][j]);
				assertNotEquals(i+60,taulerTest.tauler[i][j]);
				assertNotEquals(i+70,taulerTest.tauler[i][j]);
				assertNotEquals(i+80,taulerTest.tauler[i][j]);
				assertNotEquals(i+90,taulerTest.tauler[i][j]);				
				assertEquals(0,taulerTest.tauler[i][j]);
			}
		}
				
				
	}		
			
			
		
	
	


}