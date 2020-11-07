package mastermind;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaulerTest {
	
	
	Tauler taulerTest = new Tauler();
	
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
	@Test public void ConstructorTaulerTest() {
		
		//Valores Frontera
		assertEquals(10, taulerTest.getFila());
		assertEquals(10, taulerTest.getColumna());
		
		//Valores Limite(exteriores a la frontera)
		assertNotEquals(null,taulerTest.tauler);
		assertNotEquals(11, taulerTest.getFila());
		assertNotEquals(11, taulerTest.getColumna());
		
		//Valores Limite(interiores a la frontera)		
		assertNotEquals(9, taulerTest.getFila());
		assertNotEquals(9, taulerTest.getColumna());
		assertNotEquals(8, taulerTest.getFila());
		assertNotEquals(8, taulerTest.getColumna());
		assertNotEquals(7, taulerTest.getFila());
		assertNotEquals(7, taulerTest.getColumna());
		assertNotEquals(6, taulerTest.getFila());
		assertNotEquals(6, taulerTest.getColumna());
		assertNotEquals(5, taulerTest.getFila());
		assertNotEquals(5, taulerTest.getColumna());
		assertNotEquals(4, taulerTest.getFila());
		assertNotEquals(4, taulerTest.getColumna());
		assertNotEquals(3, taulerTest.getFila());
		assertNotEquals(3, taulerTest.getColumna());
		assertNotEquals(2, taulerTest.getFila());
		assertNotEquals(2, taulerTest.getColumna());
		assertNotEquals(1, taulerTest.getFila());
		assertNotEquals(1, taulerTest.getColumna());		
		 
		 
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
	@Test public void InicialitzarTaulerTest() {	
				
		taulerTest.InicialitzarTauler();
		
		
		//Valores no validos
		for (int i=0; i<taulerTest.fila; i++) {
			for (int j=0; j<taulerTest.columna;j++) {				
				
				assertNotEquals(null,taulerTest.tauler[i][j]);
				assertNotEquals(0,taulerTest.tauler[i][j]);
				assertNotEquals(i+1,taulerTest.tauler[i][j]);
				assertNotEquals(i+10,taulerTest.tauler[i][j]);
				assertNotEquals(i+20,taulerTest.tauler[i][j]);
				assertNotEquals(i+30,taulerTest.tauler[i][j]);
				assertNotEquals(i+50,taulerTest.tauler[i][j]);
				assertNotEquals(i+60,taulerTest.tauler[i][j]);
				assertNotEquals(i+70,taulerTest.tauler[i][j]);
				assertNotEquals(i+80,taulerTest.tauler[i][j]);
				assertNotEquals(i+90,taulerTest.tauler[i][j]);
				
				
			}
		}
		
		
		//Valor Frontera
		for (int i=0; i<taulerTest.fila; i++) {
			for (int j=0; j<taulerTest.columna;j++) {					
				
				assertEquals("0",taulerTest.tauler[i][j]);
				
			}
		}
		
		//Valores Limite (exteriores a la frontera)
		for (int i=0; i<taulerTest.fila; i++) {
			for (int j=0; j<taulerTest.columna;j++) {					
						
				assertEquals("-1",taulerTest.tauler[i][j]);
				assertEquals("1",taulerTest.tauler[i][j]);
						
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
	@Test public void SetGetCasella() {
		

		for (int i=0; i<taulerTest.fila; i++) {
			for (int j=0; j<taulerTest.columna;j++) {				
				
				char suma = (char) (j+0);
				char deu = (char) (j+10);
				char vint = (char) (j+20);
				char trenta = (char) (j+30);				
				char quaranta = (char) (j+40);
				char cinquanta = (char) (j+50);
				
				
				taulerTest.setCasella(i, j,suma);
				assertEquals(taulerTest.getCasella(i,j),suma);				
				taulerTest.setCasella(i, j,deu);
				assertEquals(taulerTest.getCasella(i,j),deu);				
				taulerTest.setCasella(i, j,vint);
				assertEquals(taulerTest.getCasella(i,j),vint);				
				taulerTest.setCasella(i, j,trenta);
				assertEquals(taulerTest.getCasella(i,j),trenta);				
				taulerTest.setCasella(i, j,quaranta);
				assertEquals(taulerTest.getCasella(i,j),quaranta);				
				taulerTest.setCasella(i, j,cinquanta);
				assertEquals(taulerTest.getCasella(i,j),cinquanta);
				
				
				
			}
			
		}
	}
	
		
		
			
		
	
	


}