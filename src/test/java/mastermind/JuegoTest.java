package mastermind;
import Modelo.Juego;
import org.junit.Test;
import static org.junit.Assert.*;

public class JuegoTest {
	
	
	Juego juegoTest = new Juego();
	
	
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
		assertEquals(10, juegoTest.getFila());
		assertEquals(10, juegoTest.getColumna());
		
		//Valores Limite(exteriores a la frontera)
		assertNotEquals(null,juegoTest.tablero);
		assertNotEquals(11, juegoTest.getFila());
		assertNotEquals(11, juegoTest.getColumna());
		
		//Valores Limite(interiores a la frontera)		
		assertNotEquals(9, juegoTest.getFila());
		assertNotEquals(9, juegoTest.getColumna());
		assertNotEquals(8, juegoTest.getFila());
		assertNotEquals(8, juegoTest.getColumna());
		assertNotEquals(7, juegoTest.getFila());
		assertNotEquals(7, juegoTest.getColumna());
		assertNotEquals(6, juegoTest.getFila());
		assertNotEquals(6, juegoTest.getColumna());
		assertNotEquals(5, juegoTest.getFila());
		assertNotEquals(5, juegoTest.getColumna());
		assertNotEquals(4, juegoTest.getFila());
		assertNotEquals(4, juegoTest.getColumna());
		assertNotEquals(3, juegoTest.getFila());
		assertNotEquals(3, juegoTest.getColumna());
		assertNotEquals(2, juegoTest.getFila());
		assertNotEquals(2, juegoTest.getColumna());
		assertNotEquals(1, juegoTest.getFila());
		assertNotEquals(1, juegoTest.getColumna());		
		 
		 
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
				
		juegoTest.InicializarTablero();
		
		
		//Valores no validos
		for (int i=0; i<juegoTest.fila; i++) {
			for (int j=0; j<juegoTest.columna;j++) {				
				
				assertNotEquals(null,juegoTest.tablero[i][j]);
				assertNotEquals(0,juegoTest.tablero[i][j]);
				assertNotEquals(i+1,juegoTest.tablero[i][j]);
				assertNotEquals(i+10,juegoTest.tablero[i][j]);
				assertNotEquals(i+20,juegoTest.tablero[i][j]);
				assertNotEquals(i+30,juegoTest.tablero[i][j]);
				assertNotEquals(i+50,juegoTest.tablero[i][j]);
				assertNotEquals(i+60,juegoTest.tablero[i][j]);
				assertNotEquals(i+70,juegoTest.tablero[i][j]);
				assertNotEquals(i+80,juegoTest.tablero[i][j]);
				assertNotEquals(i+90,juegoTest.tablero[i][j]);
								
			}
		}
		
		
		//Valor Frontera
		for (int i=0; i<juegoTest.fila; i++) {
			for (int j=0; j<juegoTest.columna;j++) {					
				
				assertEquals("0",juegoTest.tablero[i][j]);
				
			}
		}
		
		//Valores Limite (exteriores a la frontera)
		for (int i=0; i<juegoTest.fila; i++) {
			for (int j=0; j<juegoTest.columna;j++) {					
						
				assertNotEquals("-1",juegoTest.tablero[i][j]);
				assertNotEquals("1",juegoTest.tablero[i][j]);
						
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
		for (int i=0; i<juegoTest.fila; i++) {
			for (int j=0; j<juegoTest.columna;j++) {				
				
				int codigAscii = (int)Math.floor(65+i);
				String caracter = Character.toString(codigAscii);				
				
				juegoTest.setCasilla(i, j,caracter);
				assertEquals(juegoTest.getCasilla(i,j),caracter);				
				
				
			}
			
		}
	}
	
	/**
	 * Test: GenerarCodigoGama()
	 * 
	 * Tipo: Caja Negra
	 * 
	 * Explicacion
	 * 
	 * Valores Frontera: A y F
	 * Valores Exteriores a la Frontera: Cogemos letras mayusculas random de la F a la Z (72-90 codigoAscii)
	 * 									 Cogemos letras minuscuals random de la a a la z (97-122 codigoAscii)
	 * 									 Otros Caracteres random (32-64) / Otros Caracteres random (123-165)
	 */
	
	@Test public void GenerarCodigoGamaTest() {			
		
		juegoTest.GenerarCodigoGama();
		
		//Longitud Codigo = 7
		assertEquals(juegoTest.codigo.length,7);
		
		//Valores Frontera
		assertEquals(juegoTest.getCodigo(0),"A");
		assertEquals(juegoTest.getCodigo(5),"F");
		
		//Valores interiores a la frontera
		assertEquals(juegoTest.getCodigo(1),"B");
		assertEquals(juegoTest.getCodigo(4),"E");
		
		//Valores interiores
		assertEquals(juegoTest.getCodigo(2),"C");
		assertEquals(juegoTest.getCodigo(3),"D");
		
		
		//Valores exteriores a la frontera
		
		  //Letras Mayusculas
			for (int i=0; i<juegoTest.longitudCodigo; i++) {
				
				int inc = 0;
				int codigAscii = (int)Math.floor(72+inc);
				String codiAscii = Character.toString(codigAscii);
				assertNotEquals(juegoTest.getCodigo(i),codiAscii);
				inc ++;			
			}
			
		 //Letras Minusculas
				for (int i=0; i<juegoTest.longitudCodigo; i++) {
				
				int inc = 0;
				int codigAscii = (char) Math.floor(Math.random()*(97 - 122)+97); 
				String codiAscii = Character.toString(codigAscii);
				assertNotEquals(juegoTest.getCodigo(i),codiAscii);
				inc ++;			
			}
				
		 //Otros Caracteres
				for (int i=0; i<juegoTest.longitudCodigo; i++) {
				
				int inc = 0;
				int codigAscii = (char) Math.floor(Math.random()*(32 - 64)+32);
				String codiAscii = Character.toString(codigAscii);
				assertNotEquals(juegoTest.getCodigo(i),codiAscii);
				inc ++;			
			}
			
		  //Otros Caracteres				
				for (int i=0; i<juegoTest.longitudCodigo; i++) {
				
				int inc = 0;
				int codigAscii = (char) Math.floor(Math.random()*(123 - 165)+123);
				String codiAscii = Character.toString(codigAscii);
				assertNotEquals(juegoTest.getCodigo(i),codiAscii);
				inc ++;			
			}
	}
	
	
	/**
	 * Test: GenerarCodigoTest()
	 * 
	 * Tipo: Caja Negra
	 * 
	 * Explicacion: Al ser un codigo que se genera automaticamente comprobaremos que puede contener las letras permitidas
	 * 				y que no tiene ninguna letra no permitida	  
	 */
	@Test public void GenerarCodigoSecretoTest() {	
		
		String[] codigoSecretoTest = new String[juegoTest.longitudCodigo];
		codigoSecretoTest = juegoTest.GenerarCodigoSecreto();
		
		
		//Lomgitud CodigoSecreto = 7
		assertEquals(juegoTest.codigoSecreto.length,7);
		
		
		
		//Combinacion de valores que puede tener el codigo secreto {A,B,C,D,E,F}
		for (int i=0; i<juegoTest.longitudCodigo; i++) {					
			
			assertEquals(juegoTest.getCodigoSecreto(i),codigoSecretoTest[i]);			
			
		}
		
		
		//Letras Minusculas
		for (int i=0; i<juegoTest.longitudCodigo; i++) {
		
			int inc = 0;
			int codigAscii = (char) Math.floor(Math.random()*(97 - 122)+97); 
			String codiAscii = Character.toString(codigAscii);
			assertNotEquals(juegoTest.getCodigo(i),codiAscii);
			inc ++;			
	}
		
		//Otros Caracteres
		for (int i=0; i<juegoTest.longitudCodigo; i++) {
		
			int inc = 0;
			int codigAscii = (char) Math.floor(Math.random()*(32 - 64)+32);
			String codiAscii = Character.toString(codigAscii);
			assertNotEquals(juegoTest.getCodigo(i),codiAscii);
			inc ++;			
	}
	
		//Otros Caracteres				
		for (int i=0; i<juegoTest.longitudCodigo; i++) {
		
			int inc = 0;
			int codigAscii = (char) Math.floor(Math.random()*(123 - 165)+123);
			String codiAscii = Character.toString(codigAscii);
			assertNotEquals(juegoTest.getCodigo(i),codiAscii);
			inc ++;			
	}
		
		
		
	}
	
			
		
	
	


}