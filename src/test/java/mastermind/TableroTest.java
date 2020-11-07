package mastermind;

import org.junit.Test;
import static org.junit.Assert.*;

public class TableroTest {
	
	
	Tablero tableroTest = new Tablero();
	
	/*
	 * Test Tauler() (Constructor)
	 * 
	 * Tipo: Caja negra
	 * 
	 * Explicacion: Test de caja negra para comprovar que la matriz se ha creado correctamente
	 * comprobando sus limites con los getters de fila y columna para ver si se ha 
	 * creado siguiendo las dimensionnes indicadas.
	 * 
	 * Valores Frontera  (fila=10 y columna=10)
	 * 
	 */
	@Test public void ConstructorTableroTest() {
		
		//Valores Frontera
		assertEquals(10, tableroTest.getFila());
		assertEquals(10, tableroTest.getColumna());
		
		//Valores Limite(exteriores a la frontera)
		assertNotEquals(null,tableroTest.tablero);
		assertNotEquals(11, tableroTest.getFila());
		assertNotEquals(11, tableroTest.getColumna());
		
		//Valores Limite(interiores a la frontera)		
		assertNotEquals(9, tableroTest.getFila());
		assertNotEquals(9, tableroTest.getColumna());
		assertNotEquals(8, tableroTest.getFila());
		assertNotEquals(8, tableroTest.getColumna());
		assertNotEquals(7, tableroTest.getFila());
		assertNotEquals(7, tableroTest.getColumna());
		assertNotEquals(6, tableroTest.getFila());
		assertNotEquals(6, tableroTest.getColumna());
		assertNotEquals(5, tableroTest.getFila());
		assertNotEquals(5, tableroTest.getColumna());
		assertNotEquals(4, tableroTest.getFila());
		assertNotEquals(4, tableroTest.getColumna());
		assertNotEquals(3, tableroTest.getFila());
		assertNotEquals(3, tableroTest.getColumna());
		assertNotEquals(2, tableroTest.getFila());
		assertNotEquals(2, tableroTest.getColumna());
		assertNotEquals(1, tableroTest.getFila());
		assertNotEquals(1, tableroTest.getColumna());		
		 
		 
	 }
	
	/*
	 * Test: InicializarTauler()
	 * 
	 * Tipo: Caja negra
	 * 
	 * Explicacion: Comprueba si se ha inicializado correctamente la matriz (Tauler).
	 * 
	 * Valor Frontera = "0"
	 * 
	 */
	@Test public void InicialitzarTableroTest() {	
				
		tableroTest.InicializarTablero();
		
		
		//Valores no validos
		for (int i=0; i<tableroTest.fila; i++) {
			for (int j=0; j<tableroTest.columna;j++) {				
				
				assertNotEquals(null,tableroTest.tablero[i][j]);
				assertNotEquals(0,tableroTest.tablero[i][j]);
				assertNotEquals(i+1,tableroTest.tablero[i][j]);
				assertNotEquals(i+10,tableroTest.tablero[i][j]);
				assertNotEquals(i+20,tableroTest.tablero[i][j]);
				assertNotEquals(i+30,tableroTest.tablero[i][j]);
				assertNotEquals(i+50,tableroTest.tablero[i][j]);
				assertNotEquals(i+60,tableroTest.tablero[i][j]);
				assertNotEquals(i+70,tableroTest.tablero[i][j]);
				assertNotEquals(i+80,tableroTest.tablero[i][j]);
				assertNotEquals(i+90,tableroTest.tablero[i][j]);
								
			}
		}
		
		
		//Valor Frontera
		for (int i=0; i<tableroTest.fila; i++) {
			for (int j=0; j<tableroTest.columna;j++) {					
				
				assertEquals("0",tableroTest.tablero[i][j]);
				
			}
		}
		
		//Valores Limite (exteriores a la frontera)
		for (int i=0; i<tableroTest.fila; i++) {
			for (int j=0; j<tableroTest.columna;j++) {					
						
				assertNotEquals("-1",tableroTest.tablero[i][j]);
				assertNotEquals("1",tableroTest.tablero[i][j]);
						
			}
		}
		
				
				
	}
	
	/**
	 * Test: getCasella() y setCasella()
	 * 
	 * Tipo: Caja negra
	 * 
	 * Explicacion: 
	 * 
	 */
	@Test public void SetGetCasillaTest() {
		
		//Valores
		for (int i=0; i<tableroTest.fila; i++) {
			for (int j=0; j<tableroTest.columna;j++) {				
				
				int codigAscii = (int)Math.floor(65+i);
				String caracter = Character.toString(codigAscii);				
				
				tableroTest.setCasilla(i, j,caracter);
				assertEquals(tableroTest.getCasilla(i,j),caracter);				
				
				
			}
			
		}
	}
	
		
		
			
		
	
	


}