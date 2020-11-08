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
		
		//Longitud Codigo = 6
		assertEquals(juegoTest.codigo.length,6);
		
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
		
		
		
		
		//Lomgitud CodigoSecreto = 6
		assertEquals(juegoTest.codigoSecreto.length,6);
		
		
		
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
	
	
	/**
	 * Test: VerificaLimitesColumna()
	 * 
	 * Tipo: Caja Negra
	 * 
	 * Explicacion: Verificamos que la funcion nos debuelve true cuando el valor introducido esta entre [1-5]
	 * 
	 * 
	 */
	@Test public void VerificaLimitesColumnaTest() {
		
		
		//Valores Frontera
		assertTrue(juegoTest.VerificaLimitesColumna(1));
		assertTrue(juegoTest.VerificaLimitesColumna(5));
		
		//Valor Interior
		assertTrue(juegoTest.VerificaLimitesColumna(3));
		
		//Valores Limite Interiores a la Frontera
		assertTrue(juegoTest.VerificaLimitesColumna(2));		
		assertTrue(juegoTest.VerificaLimitesColumna(4));
		
		//Valores Limite Exteriores a la Frontera
		assertFalse(juegoTest.VerificaLimitesColumna(0));
		assertFalse(juegoTest.VerificaLimitesColumna(-1));
		assertFalse(juegoTest.VerificaLimitesColumna(-2));
		assertFalse(juegoTest.VerificaLimitesColumna(-3));
		assertFalse(juegoTest.VerificaLimitesColumna(-4));
		assertFalse(juegoTest.VerificaLimitesColumna(-5));
		assertFalse(juegoTest.VerificaLimitesColumna(-6));
		assertFalse(juegoTest.VerificaLimitesColumna(-7));
		assertFalse(juegoTest.VerificaLimitesColumna(-8));
		assertFalse(juegoTest.VerificaLimitesColumna(-9));
		assertFalse(juegoTest.VerificaLimitesColumna(-10));
		assertFalse(juegoTest.VerificaLimitesColumna(6));
		assertFalse(juegoTest.VerificaLimitesColumna(7));
		assertFalse(juegoTest.VerificaLimitesColumna(8));
		assertFalse(juegoTest.VerificaLimitesColumna(9));
		assertFalse(juegoTest.VerificaLimitesColumna(10));
		assertFalse(juegoTest.VerificaLimitesColumna(11));
		assertFalse(juegoTest.VerificaLimitesColumna(12));
		assertFalse(juegoTest.VerificaLimitesColumna(13));
		assertFalse(juegoTest.VerificaLimitesColumna(14));
		assertFalse(juegoTest.VerificaLimitesColumna(15));		
		
		
		
	}
	
	/**
	 * Test: VerificaLetra()
	 * 
	 * Tipo: Caja Negra
	 * 
	 * Explicacion: Comprobamos que las letras introducidas sean las permitidas {A,B,C,D,E,F}
	 * 
	 * 
	 */
	@Test public void VerificaLetraTest() {
		
		juegoTest.GenerarCodigoGama();
		
		//Valores Frontera (A,F)
		assertTrue(juegoTest.VerificaLetra("A"));
		assertTrue(juegoTest.VerificaLetra("F"));
		
		//Valores Limite Interiores a la Frontera
		assertTrue(juegoTest.VerificaLetra("B"));		
		assertTrue(juegoTest.VerificaLetra("E"));
		
		//Valores Interiores a la Frontera
		assertTrue(juegoTest.VerificaLetra("C"));
		assertTrue(juegoTest.VerificaLetra("D"));
		
		
		//Valores Exterires a la Frontera
		
		//Letras Mayusculas (G-Z) (71-90)
		for (int i=0; i<20; i++) {			
			
			int codigAscii = (int)Math.floor(71+i);
			String codiAscii = Character.toString(codigAscii);
			assertFalse(juegoTest.VerificaLetra(codiAscii));
				
		}
		
		//Letras Minusculas (a-z) (97-122)
		for (int i=0; i<26; i++) {			
					
			int codigAscii = (int)Math.floor(97+i);
			String codiAscii = Character.toString(codigAscii);
			assertFalse(juegoTest.VerificaLetra(codiAscii));
						
		}		
		
		
		//Letras Mayusculas (espacio-@) (32-64)
		for (int i=0; i<32; i++) {			
					
			int codigAscii = (int)Math.floor(32+i);
			String codiAscii = Character.toString(codigAscii);
			assertFalse(juegoTest.VerificaLetra(codiAscii));
						
		}	
		

		//Letras Mayusculas (espacio-@) (123-255) ({-nbsp)
		for (int i=0; i<134; i++) {			
					
			int codigAscii = (int)Math.floor(123+i);
			String codiAscii = Character.toString(codigAscii);
			assertFalse(juegoTest.VerificaLetra(codiAscii));
						
		}
		
		
		
	}
	
	/**
	 * Test: VerificaPosicionOcupada()
	 * 
	 * Tipo: Caja Negra
	 * 
	 * Verificamos que todas las posiciones esten libres.
	 * Luego rellenamos todo el tablero y comporbamos que estas esten ocupadas.
	 * 
	 */
	@Test public void VerificaPosicionOcupadaTest() {
		
		juegoTest.InicializarTablero();
		
		String letra = "A";
		
		//Ninguna posicion esta Ocupada
		//Fila 9
		assertFalse(juegoTest.VerificaPosicionOcupada(9, 0));
		assertFalse(juegoTest.VerificaPosicionOcupada(9, 1));
		assertFalse(juegoTest.VerificaPosicionOcupada(9, 2));
		assertFalse(juegoTest.VerificaPosicionOcupada(9, 3));
		assertFalse(juegoTest.VerificaPosicionOcupada(9, 4));
		
		//Fila 8
		assertFalse(juegoTest.VerificaPosicionOcupada(8, 0));
		assertFalse(juegoTest.VerificaPosicionOcupada(8, 1));
		assertFalse(juegoTest.VerificaPosicionOcupada(8, 2));
		assertFalse(juegoTest.VerificaPosicionOcupada(8, 3));
		assertFalse(juegoTest.VerificaPosicionOcupada(8, 4));
		
		//Fila 7
		assertFalse(juegoTest.VerificaPosicionOcupada(7, 0));
		assertFalse(juegoTest.VerificaPosicionOcupada(7, 1));
		assertFalse(juegoTest.VerificaPosicionOcupada(7, 2));
		assertFalse(juegoTest.VerificaPosicionOcupada(7, 3));
		assertFalse(juegoTest.VerificaPosicionOcupada(7, 4));
		
		//Fila6
		assertFalse(juegoTest.VerificaPosicionOcupada(6, 0));
		assertFalse(juegoTest.VerificaPosicionOcupada(6, 1));
		assertFalse(juegoTest.VerificaPosicionOcupada(6, 2));
		assertFalse(juegoTest.VerificaPosicionOcupada(6, 3));
		assertFalse(juegoTest.VerificaPosicionOcupada(6, 4));
		
		//Fila5
		assertFalse(juegoTest.VerificaPosicionOcupada(5, 0));
		assertFalse(juegoTest.VerificaPosicionOcupada(5, 1));
		assertFalse(juegoTest.VerificaPosicionOcupada(5, 2));
		assertFalse(juegoTest.VerificaPosicionOcupada(5, 3));
		assertFalse(juegoTest.VerificaPosicionOcupada(5, 4));
		
		//Fila4
		assertFalse(juegoTest.VerificaPosicionOcupada(4, 0));
		assertFalse(juegoTest.VerificaPosicionOcupada(4, 1));
		assertFalse(juegoTest.VerificaPosicionOcupada(4, 2));
		assertFalse(juegoTest.VerificaPosicionOcupada(4, 3));
		assertFalse(juegoTest.VerificaPosicionOcupada(4, 4));
		
		//Fila3
		assertFalse(juegoTest.VerificaPosicionOcupada(3, 0));
		assertFalse(juegoTest.VerificaPosicionOcupada(3, 1));
		assertFalse(juegoTest.VerificaPosicionOcupada(3, 2));
		assertFalse(juegoTest.VerificaPosicionOcupada(3, 3));
		assertFalse(juegoTest.VerificaPosicionOcupada(3, 4));
		
		//Fila2
		assertFalse(juegoTest.VerificaPosicionOcupada(2, 0));
		assertFalse(juegoTest.VerificaPosicionOcupada(2, 1));
		assertFalse(juegoTest.VerificaPosicionOcupada(2, 2));
		assertFalse(juegoTest.VerificaPosicionOcupada(2, 3));
		assertFalse(juegoTest.VerificaPosicionOcupada(2, 4));
		
		//Fila1
		assertFalse(juegoTest.VerificaPosicionOcupada(1, 0));
		assertFalse(juegoTest.VerificaPosicionOcupada(1, 1));
		assertFalse(juegoTest.VerificaPosicionOcupada(1, 2));
		assertFalse(juegoTest.VerificaPosicionOcupada(1, 3));
		assertFalse(juegoTest.VerificaPosicionOcupada(1, 4));
		
		//Fila0
		assertFalse(juegoTest.VerificaPosicionOcupada(0, 0));
		assertFalse(juegoTest.VerificaPosicionOcupada(0, 1));
		assertFalse(juegoTest.VerificaPosicionOcupada(0, 2));
		assertFalse(juegoTest.VerificaPosicionOcupada(0, 3));
		assertFalse(juegoTest.VerificaPosicionOcupada(0, 4));
		
		
		//Ocupamos todas las posiciones
		//Fila 9
		juegoTest.setCasilla(9, 0, letra);
		juegoTest.setCasilla(9, 1, letra);
		juegoTest.setCasilla(9, 2, letra);
		juegoTest.setCasilla(9, 3, letra);
		juegoTest.setCasilla(9, 4, letra);
		//Fila 8
		juegoTest.setCasilla(8, 0, letra);
		juegoTest.setCasilla(8, 1, letra);
		juegoTest.setCasilla(8, 2, letra);
		juegoTest.setCasilla(8, 3, letra);
		juegoTest.setCasilla(8, 4, letra);
		//Fila 7
		juegoTest.setCasilla(7, 0, letra);
		juegoTest.setCasilla(7, 1, letra);
		juegoTest.setCasilla(7, 2, letra);
		juegoTest.setCasilla(7, 3, letra);
		juegoTest.setCasilla(7, 4, letra);
		//Fila 6
		juegoTest.setCasilla(6, 0, letra);
		juegoTest.setCasilla(6, 1, letra);
		juegoTest.setCasilla(6, 2, letra);
		juegoTest.setCasilla(6, 3, letra);
		juegoTest.setCasilla(6, 4, letra);
		//Fila 5
		juegoTest.setCasilla(5, 0, letra);
		juegoTest.setCasilla(5, 1, letra);
		juegoTest.setCasilla(5, 2, letra);
		juegoTest.setCasilla(5, 3, letra);
		juegoTest.setCasilla(5, 4, letra);
		//Fila 4
		juegoTest.setCasilla(4, 0, letra);
		juegoTest.setCasilla(4, 1, letra);
		juegoTest.setCasilla(4, 2, letra);
		juegoTest.setCasilla(4, 3, letra);
		juegoTest.setCasilla(4, 4, letra);
		//Fila 3
		juegoTest.setCasilla(3, 0, letra);
		juegoTest.setCasilla(3, 1, letra);
		juegoTest.setCasilla(3, 2, letra);
		juegoTest.setCasilla(3, 3, letra);
		juegoTest.setCasilla(3, 4, letra);
		//Fila 2
		juegoTest.setCasilla(2, 0, letra);
		juegoTest.setCasilla(2, 1, letra);
		juegoTest.setCasilla(2, 2, letra);
		juegoTest.setCasilla(2, 3, letra);
		juegoTest.setCasilla(2, 4, letra);
		//Fila 1
		juegoTest.setCasilla(1, 0, letra);
		juegoTest.setCasilla(1, 1, letra);
		juegoTest.setCasilla(1, 2, letra);
		juegoTest.setCasilla(1, 3, letra);
		juegoTest.setCasilla(1, 4, letra);
		//Fila 0
		juegoTest.setCasilla(0, 0, letra);
		juegoTest.setCasilla(0, 1, letra);
		juegoTest.setCasilla(0, 2, letra);
		juegoTest.setCasilla(0, 3, letra);
		juegoTest.setCasilla(0, 4, letra);
		
		
		//Verificamos que todas las posiciones del tablero estan ocupadas
		assertTrue(juegoTest.VerificaPosicionOcupada(9, 0));
		assertTrue(juegoTest.VerificaPosicionOcupada(9, 1));
		assertTrue(juegoTest.VerificaPosicionOcupada(9, 2));
		assertTrue(juegoTest.VerificaPosicionOcupada(9, 3));
		assertTrue(juegoTest.VerificaPosicionOcupada(9, 4));
		
		//Fila 8
		assertTrue(juegoTest.VerificaPosicionOcupada(8, 0));
		assertTrue(juegoTest.VerificaPosicionOcupada(8, 1));
		assertTrue(juegoTest.VerificaPosicionOcupada(8, 2));
		assertTrue(juegoTest.VerificaPosicionOcupada(8, 3));
		assertTrue(juegoTest.VerificaPosicionOcupada(8, 4));
		
		//Fila 7
		assertTrue(juegoTest.VerificaPosicionOcupada(7, 0));
		assertTrue(juegoTest.VerificaPosicionOcupada(7, 1));
		assertTrue(juegoTest.VerificaPosicionOcupada(7, 2));
		assertTrue(juegoTest.VerificaPosicionOcupada(7, 3));
		assertTrue(juegoTest.VerificaPosicionOcupada(7, 4));
		
		//Fila6
		assertTrue(juegoTest.VerificaPosicionOcupada(6, 0));
		assertTrue(juegoTest.VerificaPosicionOcupada(6, 1));
		assertTrue(juegoTest.VerificaPosicionOcupada(6, 2));
		assertTrue(juegoTest.VerificaPosicionOcupada(6, 3));
		assertTrue(juegoTest.VerificaPosicionOcupada(6, 4));
		
		//Fila5
		assertTrue(juegoTest.VerificaPosicionOcupada(5, 0));
		assertTrue(juegoTest.VerificaPosicionOcupada(5, 1));
		assertTrue(juegoTest.VerificaPosicionOcupada(5, 2));
		assertTrue(juegoTest.VerificaPosicionOcupada(5, 3));
		assertTrue(juegoTest.VerificaPosicionOcupada(5, 4));
		
		//Fila4
		assertTrue(juegoTest.VerificaPosicionOcupada(4, 0));
		assertTrue(juegoTest.VerificaPosicionOcupada(4, 1));
		assertTrue(juegoTest.VerificaPosicionOcupada(4, 2));
		assertTrue(juegoTest.VerificaPosicionOcupada(4, 3));
		assertTrue(juegoTest.VerificaPosicionOcupada(4, 4));
		
		//Fila3
		assertTrue(juegoTest.VerificaPosicionOcupada(3, 0));
		assertTrue(juegoTest.VerificaPosicionOcupada(3, 1));
		assertTrue(juegoTest.VerificaPosicionOcupada(3, 2));
		assertTrue(juegoTest.VerificaPosicionOcupada(3, 3));
		assertTrue(juegoTest.VerificaPosicionOcupada(3, 4));
		
		//Fila2
		assertTrue(juegoTest.VerificaPosicionOcupada(2, 0));
		assertTrue(juegoTest.VerificaPosicionOcupada(2, 1));
		assertTrue(juegoTest.VerificaPosicionOcupada(2, 2));
		assertTrue(juegoTest.VerificaPosicionOcupada(2, 3));
		assertTrue(juegoTest.VerificaPosicionOcupada(2, 4));
		
		//Fila1
		assertTrue(juegoTest.VerificaPosicionOcupada(1, 0));
		assertTrue(juegoTest.VerificaPosicionOcupada(1, 1));
		assertTrue(juegoTest.VerificaPosicionOcupada(1, 2));
		assertTrue(juegoTest.VerificaPosicionOcupada(1, 3));
		assertTrue(juegoTest.VerificaPosicionOcupada(1, 4));
		
		//Fila0
		assertTrue(juegoTest.VerificaPosicionOcupada(0, 0));
		assertTrue(juegoTest.VerificaPosicionOcupada(0, 1));
		assertTrue(juegoTest.VerificaPosicionOcupada(0, 2));
		assertTrue(juegoTest.VerificaPosicionOcupada(0, 3));
		assertTrue(juegoTest.VerificaPosicionOcupada(0, 4));
		
		
		
	}
	
	/**
	 * Test: LetraPosciconCorrecto()
	 * 
	 * Tipo: Caja Negra
	 * 
	 * Comprueba que el codigo introducido por el usuario coincida con el codigo secreto
	 */
	@Test public void LetraPosicionCorrectoTest() {
		
		//Forçamos que el codigoSecreto sea {A,B,C,D,E,F}
		for (int i = 0; i<juegoTest.longitudCodigo; i++) {			
					
			int codigAscii = (int)Math.floor(65+i);
			String codiAscii = Character.toString(codigAscii);
			juegoTest.codigoSecreto[i] = codiAscii;		
		
		}
		
		//Introducimos en la primera fila de la matriz el codigo {A,B,C,D,E,F}
		for (int i = 0; i<juegoTest.longitudCodigo; i++) {			
			
			int codigAscii = (int)Math.floor(65+i);
			String codiAscii = Character.toString(codigAscii);
			juegoTest.setCasilla(9, i, codiAscii);		
		
		}
		
		assertTrue(juegoTest.LetraPosicionCorrecto(9));
		
	}
	
	


}