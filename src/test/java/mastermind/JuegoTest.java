package mastermind;
import Modelo.Juego;
import Modelo.MockAleatorio;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe que implementa los Test de la classe Juego().
 * @author Victor-1456556
 */

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
	 * Valor Frontera = "-"
	 * Valor Interior = "-"
	 * Valor Interior Frontera = "-"
	 * Valor Exterior Frontera = Cualquiera excepto "-"
	 * 
	 */
	@Test public void InicialitzarTableroTest() {	
				
		juegoTest.InicializarTablero();			
		//Valores Exteriores Frontera
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
				assertNotEquals(i-1,juegoTest.tablero[i][j]);
				assertNotEquals(i-10,juegoTest.tablero[i][j]);
				assertNotEquals(i-20,juegoTest.tablero[i][j]);
				assertNotEquals(i-30,juegoTest.tablero[i][j]);
				assertNotEquals(i-50,juegoTest.tablero[i][j]);
				assertNotEquals(i-60,juegoTest.tablero[i][j]);
				assertNotEquals(i-70,juegoTest.tablero[i][j]);
				assertNotEquals(i-80,juegoTest.tablero[i][j]);
				assertNotEquals(i-90,juegoTest.tablero[i][j]);
				assertNotEquals("-1",juegoTest.tablero[i][j]);
				assertNotEquals("1",juegoTest.tablero[i][j]);								
			}
		}		
		//Valor Frontera / Valor Interior / Valor Interior Frontera
		for (int i=0; i<juegoTest.fila; i++) {
			for (int j=0; j<juegoTest.columna;j++) {				
				assertEquals(juegoTest.vacio,juegoTest.tablero[i][j]);			
			}
		}					
	}	
	
	
	/**
	 * Test: GenerarCodigoGama()
	 * 
	 * Tipo: Caja Negra
	 * 
	 * Explicacion: Se comprueba que el codigoGamma generado sea {A,B,C,D,E,F,G}
	 * 
	 * Valores Frontera: A y G
	 * Valores Interiores: C,D,E
	 * Valores Interiores Frontera: B,F
	 * Valores Exteriores Frontera: @,H 	  									
	 */	
	@Test public void GenerarCodigoGamaTest() {			
		
		juegoTest.GenerarCodigoGama();		
		//Longitud Codigo = 7
		assertEquals(juegoTest.codigo.length,7);		
		//Valores Frontera
		assertEquals(juegoTest.getCodigo(0),"A");
		assertEquals(juegoTest.getCodigo(6),"G");		
		//Valores Interiores
		assertEquals(juegoTest.getCodigo(2),"C");
		assertEquals(juegoTest.getCodigo(3),"D");
		assertEquals(juegoTest.getCodigo(4),"E");		
		//Valores Interiores Frontera
		assertEquals(juegoTest.getCodigo(1),"B");
		assertEquals(juegoTest.getCodigo(5),"F");		
		//Valores Exteriores Frontera
		assertNotEquals(juegoTest.getCodigo(1),"@");
		assertNotEquals(juegoTest.getCodigo(5),"H");		
		//Valores Exteriores  
		//Letras Mayusculas: Cogemos letras mayusculas random de la H a la Z (72-90 codigoAscii)		
		for (int i=0; i<juegoTest.longitudCodigo; i++) {				
			int codigoAscii = (char) Math.floor(Math.random()*(72 - 90)+90); 
			String codiAscii = Character.toString(codigoAscii);
			assertNotEquals(juegoTest.getCodigo(i),codiAscii);						
		}			
		 //Letras Minusculas:  Cogemos letras minuscuals random de la a a la z (97-122 codigoAscii)
		for (int i=0; i<juegoTest.longitudCodigo; i++) {				
			int codigAscii = (char) Math.floor(Math.random()*(97 - 122)+97); 
			String codiAscii = Character.toString(codigAscii);
			assertNotEquals(juegoTest.getCodigo(i),codiAscii);						
		}				
		//Otros Caracteres: (32-64 codigoAscii)
		for (int i=0; i<juegoTest.longitudCodigo; i++) {				
			int codigAscii = (char) Math.floor(Math.random()*(32 - 64)+32);
			String codiAscii = Character.toString(codigAscii);
			assertNotEquals(juegoTest.getCodigo(i),codiAscii);						
		}			
		//Otros Caracteres: (123-165 codigoAscii)		
		for (int i=0; i<juegoTest.longitudCodigo; i++) {				
			int codigAscii = (char) Math.floor(Math.random()*(123 - 165)+123);
			String codiAscii = Character.toString(codigAscii);
			assertNotEquals(juegoTest.getCodigo(i),codiAscii);					
		}
	}	
	
	
	/**
	 * Test: VerificaLimitesColumna()
	 * 
	 * Tipo: Caja Negra
	 * 
	 * Explicacion: Verificamos que la funcion nos debuelve True cuando el valor introducido esta entre [1-5], sino False.
	 * 				Para el usuario es [1-5], pero para el programa es [0-4].
	 * 
	 * Valores Frontera: 0,4
	 * Valores Interior: 2
	 * Valores Interiores Frontera: 1,3
	 * Valores Exteriores Frontera: -1,5
	 * 
	 */
	@Test public void VerificaLimitesColumnaTest() {
		
		//Valores Frontera
		assertTrue(juegoTest.VerificaLimitesColumna(0));
		assertTrue(juegoTest.VerificaLimitesColumna(4));
		
		//Valor Interior 
		assertTrue(juegoTest.VerificaLimitesColumna(2));
		
		//Valores Interiores Frontera
		assertTrue(juegoTest.VerificaLimitesColumna(1));		
		assertTrue(juegoTest.VerificaLimitesColumna(3));
		
		//Valores Exteriores Frontera		
		assertFalse(juegoTest.VerificaLimitesColumna(-1));		
		assertFalse(juegoTest.VerificaLimitesColumna(-5));
		
		//Valores Exteriores
		for (int  i=5; i<100; i++) {			
		assertFalse(juegoTest.VerificaLimitesColumna(i));
		assertFalse(juegoTest.VerificaLimitesColumna(-i));				
		}			
	}	
	
	
	/**
	 * Test: VerificaLetra()
	 * 
	 * Tipo: Caja Negra
	 * 
	 * Explicacion: Comprobamos que las letras introducidas sean las permitidas {A,B,C,D,E,F}
	 * 
	 * Valores Frontera: A,G
	 * Valores Interiores: C,D,E
	 * Valores Interiores Frontera: B,F
	 * Valores Exteriores Frontera: @,H
	 * 
	 */
	@Test public void VerificaLetraTest() {
		
		juegoTest.GenerarCodigoGama();		
		//Valores Frontera
		assertTrue(juegoTest.VerificaLetra("A"));
		assertTrue(juegoTest.VerificaLetra("G"));		
		//Valores Interiores
		assertTrue(juegoTest.VerificaLetra("C"));
		assertTrue(juegoTest.VerificaLetra("D"));
		assertTrue(juegoTest.VerificaLetra("E"));		
		//Valores Interiores Frontera
		assertTrue(juegoTest.VerificaLetra("B"));		
		assertTrue(juegoTest.VerificaLetra("F"));	
		//Valores Exteriores Frontera
		assertNotEquals(juegoTest.getCodigo(1),"@");
		assertNotEquals(juegoTest.getCodigo(5),"H");		
		//Valores Exteriores
		//Letras Mayusculas: (H-Z) (72-90 codigoAscii)
		for (int i=0; i<20; i++) {				
			int codigAscii = (int)Math.floor(72+i);
			String codiAscii = Character.toString(codigAscii);
			assertFalse(juegoTest.VerificaLetra(codiAscii));				
		}		
		//Letras Minusculas (a-z) (97-122 codigoAscii)
		for (int i=0; i<26; i++) {							
			int codigAscii = (int)Math.floor(97+i);
			String codiAscii = Character.toString(codigAscii);
			assertFalse(juegoTest.VerificaLetra(codiAscii));						
		}			
		//Letras Mayusculas (espacio-@) (32-64 codigoAscii)
		for (int i=0; i<32; i++) {						
			int codigAscii = (int)Math.floor(32+i);
			String codiAscii = Character.toString(codigAscii);
			assertFalse(juegoTest.VerificaLetra(codiAscii));						
		}
		//Letras Mayusculas ({-nbsp) (123-255 codigoAscii) 
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
	 * Explicacion: Verificamos que todas las posiciones esten libres.
	 * 				Luego rellenamos todo el tablero y comporbamos que estas esten ocupadas.
	 * 				Recordar que el programa [1-5], para el es [0-4].
	 * 
	 * Valores Frontera: Columnas: 0 y 4, Filas: 0 y 9
	 * Valores Interiores: Columnas: 2, Filas: [2-7]
	 * Valores Interiores Frontera: Columnas: 1 y 3, Filas: 1 y 8
	 * Valores Exteriores Frontera: Columnas: -1 y 5, Filas: -1 y 10
	 * 	  	 
	 */
	@Test public void VerificaPosicionOcupadaTest() {
		
		juegoTest.InicializarTablero();		
		String letra = "A";		
		//Ninguna posicion esta Ocupada
		//Valores Frontera
		for (int i=0; i<10; i++) {			
			assertFalse(juegoTest.VerificaPosicionOcupada(i, 0));
			assertFalse(juegoTest.VerificaPosicionOcupada(i, 4));			
		}
		for (int i=0; i<5; i++) {		
			assertFalse(juegoTest.VerificaPosicionOcupada(0, i));
			assertFalse(juegoTest.VerificaPosicionOcupada(9, i));
		}			
		//Valores Interiores		
		for(int i=1; i<7; i++) {
			assertFalse(juegoTest.VerificaPosicionOcupada(i, 2));			
		}		
		//Valores Interiores Frontera
		for (int i=0; i<10; i++) {			
			assertFalse(juegoTest.VerificaPosicionOcupada(i, 1));
			assertFalse(juegoTest.VerificaPosicionOcupada(i, 3));			
		}
		for (int i=0; i<5; i++) {		
			assertFalse(juegoTest.VerificaPosicionOcupada(1, i));
			assertFalse(juegoTest.VerificaPosicionOcupada(8, i));
		}		
		//Ocupamos todas las posiciones
		for(int i = 0; i<10; i++) {
			for(int j=0; j<5; j++) {				
				juegoTest.setCasilla(i, j, letra);				
			}
		}		
		//Verificamos que todas las posiciones del tablero estan ocupadas
		//Valores Frontera
		for (int i=0; i<10; i++) {			
			assertTrue(juegoTest.VerificaPosicionOcupada(i, 0));
			assertTrue(juegoTest.VerificaPosicionOcupada(i, 4));				
		}
		for (int i=0; i<5; i++) {		
			assertTrue(juegoTest.VerificaPosicionOcupada(0, i));
			assertTrue(juegoTest.VerificaPosicionOcupada(9, i));
		}					
		//Valores Interiores		
		for(int i=1; i<7; i++) {
			assertTrue(juegoTest.VerificaPosicionOcupada(i, 2));			
		}				
		//Valores Interiores Frontera
		for (int i=0; i<10; i++) {			
			assertTrue(juegoTest.VerificaPosicionOcupada(i, 1));
			assertTrue(juegoTest.VerificaPosicionOcupada(i, 3));			
		}
		for (int i=0; i<5; i++) {		
			assertTrue(juegoTest.VerificaPosicionOcupada(1, i));
			assertTrue(juegoTest.VerificaPosicionOcupada(8, i));
		}		
	}
	
	
	/**
	 * Test: LetraPosciconCorrecto()
	 * 
	 * Tipo: Caja Negra
	 * 
	 * Explicacion: Comprueba que el codigo introducido por el usuario coincida con el codigo secreto.
	 * 
	 * Valores Frontera: Columnas: 0 y 4, Filas: 0 y 9
	 * Valores Interiores: Columnas: 2, Filas: [2-7]
	 * Valores Interiores Frontera: Columnas: 1 y 3, Filas: 1 y 8
	 * Valores Exteriores Frontera: Columnas: -1 y 5, Filas: -1 y 10
	 * 
	 */
	@Test public void LetraPosicionCorrectoTest() {
		
		//Todas las posiciones son correctas
		//Forçamos que el codigoSecreto sea {A,B,C,D,E}
		for (int j=0; j<10;j++) {		
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				int codigoAscii = (int)Math.floor(65+i);
				String letra = Character.toString(codigoAscii);
				juegoTest.codigoSecreto[i] = letra;			
				juegoTest.setCasilla(j, i, letra);		
				assertTrue(juegoTest.LetraPosicionCorrecto(j,i));		
			}
		}		
		//Forçamos que el codigoSecreto sea: {A,A,A,A,A} / {B,B,B,B,B} / {C,C,C,C,C} / {D,D,D,D,D} / {E,E,E,E,E} / {F,F,F,F,F} / {G,G,G,G,G}
		for (int k=0; k<7;k++) {
			for (int j=0; j<10;j++) {
				for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {			
					int codigoAscii = (int)Math.floor(66+k);
					String letra = Character.toString(codigoAscii);
					juegoTest.codigoSecreto[i] = letra;
					juegoTest.setCasilla(j, i, letra);
					assertTrue(juegoTest.LetraPosicionCorrecto(j,i));			
				}
			}
		}		
		//Forçamos que el codigoSecreto sea {F,E,D,C,B}
		for (int j=0; j<10;j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {						
				int codigoAscii = (int)Math.floor(70-i);
				String letra = Character.toString(codigoAscii);
				juegoTest.codigoSecreto[i] = letra;
				juegoTest.setCasilla(j, i, letra);
				assertTrue(juegoTest.LetraPosicionCorrecto(j,i));			
			}
		}
		//Forçamos que el codigoSecreto sea {A,C,E,G,A}
		for (int j=0; j<10;j++) {
			int inc_1 = 2;
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {			
				int codigoAscii = (int)Math.floor(63+inc_1);
				String letra = Character.toString(codigoAscii);				
				juegoTest.codigoSecreto[i] = letra;
				letra = juegoTest.getCodigoSecreto(i);
				juegoTest.setCasilla(j, i, letra);
				assertTrue(juegoTest.LetraPosicionCorrecto(j,i));
				inc_1 = inc_1*2;
				if (inc_1==8) {
					inc_1=2;
				}
			}
		}		
		//Forçamos que el codigoSecreto sea {B,D,F,B,D}
		for (int j=0; j<10;j++) {
			int inc_0 = 2;
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				int codigoAscii = (int)Math.floor(64+inc_0);
				String letra = Character.toString(codigoAscii);
				juegoTest.codigoSecreto[i] = letra;
				juegoTest.setCasilla(j, i, letra);
				assertTrue(juegoTest.LetraPosicionCorrecto(j,i));
				inc_0 = inc_0+2;
				if (inc_0==6) {
					inc_0=2;
				}
			}
		}		
		//Todas las posiciones son incorrectas		
		//Forçamos que el codigoSecreto sea {A,B,C,D,E} y el codigo insertado {F,E,D,C,B}
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {								
				int codigAscii = (int)Math.floor(65+i);
				String codiAscii = Character.toString(codigAscii);
				juegoTest.codigoSecreto[i] = codiAscii;	
				int codigoAscii = (int)Math.floor(70-i);	
				String codiiAscii = Character.toString(codigoAscii);
				juegoTest.setCasilla(j, i, codiiAscii);		
				assertFalse(juegoTest.LetraPosicionCorrecto(j,i));					
			}		
		}		
		//Algunas correctas y otras incorrectas
		//Forçamos que el codigoSecreto sea {A,B,C,D,E} y el codigo insertado {E,D,C,B,A}
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {								
				int codigAscii = (int)Math.floor(65+i);
				String codiAscii = Character.toString(codigAscii);
				juegoTest.codigoSecreto[i] = codiAscii;	
				int codigoAscii = (int)Math.floor(69-i);	
				String codiiAscii = Character.toString(codigoAscii);
				juegoTest.setCasilla(j, i, codiiAscii);	
				if (i==2) {
					assertTrue(juegoTest.LetraPosicionCorrecto(j,i));
				}else {
					assertFalse(juegoTest.LetraPosicionCorrecto(j,i));
				}					
			}	
		}		
	}
	
	
	/**
	 * Test: LetraCasiCorrecto()
	 * 
	 * Tipo: Caja Negra
	 * 
	 * Explicacion: Se verifica que el codigo introducido por el usuario contenga letras del CodigoSecreto pero en distintas posciones.
	 * 
	 * Los limites y los valores validos es el tablero y el codigo
	 */
	@Test public void LetraCasiCorrectoTest() {
	
		//Forçamos que el codigoSecreto sea {A,B,C,D,E} y el introducido {F,F,F,F,F}
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {							
				int codigAscii = (int)Math.floor(65+i);
				String letraSecreta = Character.toString(codigAscii);
				juegoTest.codigoSecreto[i] = letraSecreta;			
				int codigoAscii = (int)Math.floor(70);	
				String letra = Character.toString(codigoAscii);
				juegoTest.setCasilla(j, i, letra);
				assertFalse(juegoTest.LetraPosicionCorrecto(j, i));				
			}				
		}	
		//Forçamos que el codigoSecreto sea {A,B,C,D,E} y el introducido {B,C,D,E,A}
			juegoTest.InicializarTablero();
			for (int j=0; j<juegoTest.fila; j++) {
				for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {								
					int codigAscii = (int)Math.floor(65+i);				
					String codiAscii = Character.toString(codigAscii);
					juegoTest.codigoSecreto[i] = codiAscii;
					int codigo_Ascii = (int)Math.floor(66+i);
					String LetraIntroducida = Character.toString(codigo_Ascii);	
					if (i==4) {
						juegoTest.setCasilla(j, i, "A");	
					}else {
						juegoTest.setCasilla(j, i, LetraIntroducida);	
					}
					juegoTest.codigoPista[i] = juegoTest.vacio;
				}
			}			
			for (int j=0; j<juegoTest.fila; j++) {
				for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {						
				assertTrue(juegoTest.LetraCasiCorrecto(j,i));
					
				}
			}
		}
	
	
	/**
	 * Test: LetraCasiCorrecto()
	 * 
	 * Tipo: Caja Blanca(DecisionCoverage y ConditionCoverage)
	 * 
	 * Explicacion: Comprueba que el codigo introducido por el usuario las letras estan en el CodigoSecreto pero en distinas posiciones.
	 */
	@Test public void LetraCasiCorrectoTest2() {		
		
		//Decision (While True)
		juegoTest.longitudCodigoSecreto = 5;
		juegoTest.letra_correcto = false;		
		//Decision (While False)
		juegoTest.longitudCodigoSecreto = -1;
		juegoTest.letra_correcto = true;		
		//Condition (False && True)
		juegoTest.longitudCodigoSecreto = -1;		
		//Condition (True && False)
		juegoTest.longitudCodigoSecreto = 5;
		juegoTest.letra_correcto = true;		
		//Condition (False && False)
		juegoTest.longitudCodigoSecreto = -1;
		juegoTest.letra_correcto = true;		
		//Condition (True && True)		
		juegoTest.longitudCodigoSecreto = 5;
		juegoTest.letra_correcto = false;			
		//Decision (IF false)					
		//Forçamos que el codigoSecreto sea {A,B,C,D,E} y el introducido {F,F,F,F,F}
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {							
				int codigAscii = (int)Math.floor(65+i);
				int codigoAscii = (int)Math.floor(70);
				String letraSecreta = Character.toString(codigAscii);
				String letraIntroducida = Character.toString(codigoAscii);
				juegoTest.codigoSecreto[i] = letraSecreta;			
				juegoTest.setCasilla(j, i, letraIntroducida);					
			}
			juegoTest.InicializarTablero();
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				assertFalse(juegoTest.LetraCasiCorrecto(j,i));
			}
		}
		//Decision (IF true: Entra dentro del IF)			
		//Forçamos que el codigoSecreto sea {A,B,C,D,E} y el introducido {B,C,D,E,A}
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				int codigAscii = (int)Math.floor(65+i);
				int codigoAscii = (int)Math.floor(66+i);
				if (i==4) {	codigoAscii = (int)Math.floor(65);	}
				String letraSecreta = Character.toString(codigAscii);
				String letraIntroducida = Character.toString(codigoAscii);
				juegoTest.codigoSecreto[i] = letraSecreta;					
				juegoTest.setCasilla(j, i, letraIntroducida);
				juegoTest.codigoPista[i] = juegoTest.vacio;				
			}	
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {	
				assertTrue(juegoTest.LetraCasiCorrecto(j,i));
			}
		}
			juegoTest.InicializarTablero();
			juegoTest.letra_correcto = false;	
		//Condition (True && False && False)
		//Forçamos que el codigoSecreto sea {C,D,E,F,G} y el introducido {G,F,E,D,C}
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				int codigoAscii = (int)Math.floor(67+i);
				int codiAscii = (int)Math.floor(71-i);
				String LetraSecreta = Character.toString(codigoAscii);
				String letraIntroducida = Character.toString(codiAscii);
				juegoTest.codigoSecreto[i] = LetraSecreta;					
				juegoTest.setCasilla(j, i, letraIntroducida);				
				juegoTest.setCasilla(j, i+5, juegoTest.acierto);				
				juegoTest.codigoPista[i] = juegoTest.pista;				
			}		
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				assertFalse(juegoTest.LetraCasiCorrecto(j,i));
			}
		}
		//Condition (True && False && True)
		//Forçamos que el codigoSecreto sea {C,D,E,F,G} y el introducido {G,F,E,D,C}
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				int codigoAscii = (int)Math.floor(67+i);
				int codiAscii = (int)Math.floor(71-i);
				String LetraSecreta = Character.toString(codigoAscii);
				String letraIntroducida = Character.toString(codiAscii);
				juegoTest.codigoSecreto[i] = LetraSecreta;					
				juegoTest.setCasilla(j, i, letraIntroducida);
				juegoTest.setCasilla(j, i+5, juegoTest.acierto);	
				juegoTest.codigoPista[i] = juegoTest.vacio;
			}	
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				assertFalse(juegoTest.LetraCasiCorrecto(j,i));
			}
		}
		//Condition (True && True && False)
		//Forçamos que el codigoSecreto sea {C,D,E,F,G} y el introducido {G,F,E,D,C}
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				int codigoAscii = (int)Math.floor(67+i);
				int codiAscii = (int)Math.floor(71-i);
				String LetraSecreta = Character.toString(codigoAscii);
				String letraIntroducida = Character.toString(codiAscii);
				juegoTest.codigoSecreto[i] = LetraSecreta;					
				juegoTest.setCasilla(j, i, letraIntroducida);				
				juegoTest.setCasilla(j, i+5, juegoTest.vacio);				
				juegoTest.codigoPista[i] = juegoTest.pista;				
			}		
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				assertFalse(juegoTest.LetraCasiCorrecto(j,i));
			}
		}
		//Condition (True && True && True)	
		//Forçamos que el codigoSecreto sea {C,D,E,F,G} y el introducido {G,F,E,D,C}
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				int codigoAscii = (int)Math.floor(67+i);
				int codiAscii = (int)Math.floor(71-i);
				String LetraSecreta = Character.toString(codigoAscii);
				String letraIntroducida = Character.toString(codiAscii);
				juegoTest.codigoSecreto[i] = LetraSecreta;					
				juegoTest.setCasilla(j, i, letraIntroducida);				
				juegoTest.setCasilla(j, i+5, juegoTest.vacio);				
				juegoTest.codigoPista[i] = juegoTest.vacio;				
			}		
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				assertTrue(juegoTest.LetraCasiCorrecto(j,i));
			}
		}
			juegoTest.InicializarTablero();
			juegoTest.letra_correcto = false;			
		//Condition (False && True && True)
		//Forçamos que el codigoSecreto sea {C,D,E,F,G} y el introducido {A,A,A,B,B}
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				int codigo_secreto = (int)Math.floor(67+i);
				int codigo_introducido = (int)Math.floor(65);
				if (i<2) {	codigo_introducido = (int)Math.floor(66);}
				String LetraSecreta = Character.toString(codigo_secreto);
				String letraIntroducida = Character.toString(codigo_introducido);
				juegoTest.codigoSecreto[i] = LetraSecreta;					
				juegoTest.setCasilla(j, i, letraIntroducida);
				juegoTest.setCasilla(j, i+5, juegoTest.vacio);
				juegoTest.codigoPista[i] = juegoTest.vacio;	
			}		
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {			
				assertFalse(juegoTest.LetraCasiCorrecto(j,i));
			}
		}
		//Condition (False && True && False)
		//Forçamos que el codigoSecreto sea {C,D,E,F,G} y el introducido {A,A,A,B,B}
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				int codigo_secreto = (int)Math.floor(67+i);
				int codigo_introducido = (int)Math.floor(65);
				if (i<2) {codigo_introducido = (int)Math.floor(66);	}
				String LetraSecreta = Character.toString(codigo_secreto);
				String letraIntroducida = Character.toString(codigo_introducido);
				juegoTest.codigoSecreto[i] = LetraSecreta;					
				juegoTest.setCasilla(j, i, letraIntroducida);
				juegoTest.setCasilla(j, i+5, juegoTest.vacio);
				juegoTest.codigoPista[i] = juegoTest.pista;	
			}		
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {			
				assertFalse(juegoTest.LetraCasiCorrecto(j,i));
			}
		}
		//Condition (False && False && True)
		//Forçamos que el codigoSecreto sea {C,D,E,F,G} y el introducido {A,A,A,B,B}
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				int codigo_secreto = (int)Math.floor(67+i);
				int codigo_introducido = (int)Math.floor(65);
				if (i<2) {	codigo_introducido = (int)Math.floor(66);}
				String LetraSecreta = Character.toString(codigo_secreto);
				String letraIntroducida = Character.toString(codigo_introducido);
				juegoTest.codigoSecreto[i] = LetraSecreta;					
				juegoTest.setCasilla(9, i, letraIntroducida);
				juegoTest.setCasilla(9, i+5, juegoTest.acierto);
				juegoTest.codigoPista[i] = juegoTest.vacio;	
			}		
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {			
				assertFalse(juegoTest.LetraCasiCorrecto(9,i));
			}
		}
		//Condition (False && False && False)
		//Forçamos que el codigoSecreto sea {C,D,E,F,G} y el introducido {A,A,A,B,B}
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
				int codigo_secreto = (int)Math.floor(67+i);
				int codigo_introducido = (int)Math.floor(65);
				if (i<2) {
				codigo_introducido = (int)Math.floor(66);
				}
				String LetraSecreta = Character.toString(codigo_secreto);
				String letraIntroducida = Character.toString(codigo_introducido);
				juegoTest.codigoSecreto[i] = LetraSecreta;					
				juegoTest.setCasilla(j, i, letraIntroducida);
				juegoTest.setCasilla(j, i+5, juegoTest.acierto);
				juegoTest.codigoPista[i] = juegoTest.pista;	
			}		
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {			
				assertFalse(juegoTest.LetraCasiCorrecto(j,i));
			}
		}
	}
	
	
	/**
	 * Test: VerificarLimitesColumna()
	 * 
	 * Tipo: Caja Blanca(DecisionCoverage y ConditionCoverage)
	 * 
	 * Explicacion: Decision: Se comprueba que se ejecute el if (True/False).
	 * 				Condition: Se comprueba que se ejecute el predicado(True-True/True-False/False-True/False-False)
	 */
	@Test public void VerificarLimitesColumnaTest2() {
		
		//Condition (IF True)
		assertTrue(juegoTest.VerificaLimitesColumna(3));		
		//Condition (IF False)
		assertFalse(juegoTest.VerificaLimitesColumna(-10));		
		//Decision (True-True)
		assertTrue(juegoTest.VerificaLimitesColumna(4));		
		//Decision (False-False)
		assertFalse(juegoTest.VerificaLimitesColumna(-5));
		assertFalse(juegoTest.VerificaLimitesColumna(6));		
		//Decision (True-False)
		assertFalse(juegoTest.VerificaLimitesColumna(5));		
		//Decision (False-True)
		assertFalse(juegoTest.VerificaLimitesColumna(-1));		
	}
		
	/**
	 * Test: GenerarPista()
	 * 
	 * Tipo: Caja Blanca(LoopTesting)
	 * 
	 * Explicacion: Se comprueba para los tres loops de la funcion que se ejecute n veces o no se ejecute. 
	 */
	@Test public void GenerarPistaTest() {		
		
		juegoTest.InicializarTablero();		
		for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {				
			int codigAscii = (int)Math.floor(65+i);
			String codiAscii = Character.toString(codigAscii);
			juegoTest.codigoSecreto[i] = codiAscii;			
			int codigoAscii = (int)Math.floor(65+i);	
			String codiiAscii = Character.toString(codigoAscii);
			juegoTest.setCasilla(5, i, codiiAscii);					
		}		
		//Evitamos el Loop
		juegoTest.longitudCodigoSecreto = 0;		
		juegoTest.GenerarPista(5);		
		//Una passada por el loop
		juegoTest.longitudCodigoSecreto = 1;		
		juegoTest.GenerarPista(5);		
		//Dos passadas por el loop
		juegoTest.longitudCodigoSecreto = 2;		
		juegoTest.GenerarPista(5);		
		//m passades por el loop m<n
		juegoTest.longitudCodigoSecreto = 3;		
		juegoTest.GenerarPista(5);			
		//(n-1), n passades pel loop (n=5)
		juegoTest.longitudCodigoSecreto = 4;		
		juegoTest.GenerarPista(5);		
	}
	
	
	/**
	 * Test: GenerarCodigoSecreto
	 * 
	 * Tipo: MockObject
	 * 
	 * Explicacion: Se comprueba que las letras aleatorias generadas por el metodo GeneraLetrasAleatorias() son validas. 
	 * 
	 */
	@Test public void GenerarLetrasAleatoriasTest() {	
		
		MockAleatorio MockAleatorio = new MockAleatorio();
		String letra = MockAleatorio.GenerarLetrasAleatorias();
		assertEquals(letra,"A");
		letra = MockAleatorio.GenerarLetrasAleatorias();
		assertEquals(letra,"B");
		letra = MockAleatorio.GenerarLetrasAleatorias();
		assertEquals(letra,"C");
		letra = MockAleatorio.GenerarLetrasAleatorias();
		assertEquals(letra,"D");
		letra = MockAleatorio.GenerarLetrasAleatorias();
		assertEquals(letra,"E");
		letra = MockAleatorio.GenerarLetrasAleatorias();
		assertEquals(letra,"F");
		letra = MockAleatorio.GenerarLetrasAleatorias();
		assertEquals(letra,"G");
		letra = MockAleatorio.GenerarLetrasAleatorias();
		assertEquals(letra,"B");
		letra = MockAleatorio.GenerarLetrasAleatorias();
		assertEquals(letra,"D");
		letra = MockAleatorio.GenerarLetrasAleatorias();
		assertEquals(letra,"E");
		letra = MockAleatorio.GenerarLetrasAleatorias();
		assertEquals(letra,"G");
		letra = MockAleatorio.GenerarLetrasAleatorias();
		assertEquals(letra,"A");
		letra = MockAleatorio.GenerarLetrasAleatorias();
		assertEquals(letra,"C");	
	}
	
	
	/**
	 * Test: FinPartida()
	 * 
	 * Tipo: Caja Negra
	 * 
	 * Explicacion: Comprueba que el codigo introducido por el usuario sea el mismo que el codigoSecreto.
	 */
	@Test public void FinalPartidaTest() {	
		
		//Forzamos que el codigoSecreto sea {A,B,C,D,E} y el introducido {A,B,C,D,E}
		//Forzamos que se termine la partida
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {			
				int codigAscii = (int)Math.floor(65+i);
				String letra = Character.toString(codigAscii);
				juegoTest.codigoSecreto[i] = letra;					
				juegoTest.setCasilla(j, i, letra);				
			}
			juegoTest.GenerarPista(j);
			assertTrue(juegoTest.FinalPartida(j));
		}
		//Forzamos que el codigoSecreto sea {C,D,E,F,G} y el introducido {C,D,E,F,G}
		//Forzamos que se termine la partida
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {			
				int codigAscii = (int)Math.floor(67+i);
				String letra = Character.toString(codigAscii);
				juegoTest.codigoSecreto[i] = letra;			
				juegoTest.setCasilla(j, i, letra);				
			}
			juegoTest.GenerarPista(j);
			assertTrue(juegoTest.FinalPartida(j));
		}
		//Forzamos que el codigoSecreto sea {A,B,C,D,E} y el introducido {E,D,C,B,A}
		//No se termine la partida
		juegoTest.InicializarTablero();
		for (int j=0; j<juegoTest.fila; j++) {
			for (int i = 0; i<juegoTest.longitudCodigoSecreto; i++) {			
				int codigAscii = (int)Math.floor(65+i);
				int codigoAscii = (int)Math.floor(69-i);
				String letraSecreta = Character.toString(codigAscii);				
				String letraIntroducida = Character.toString(codigoAscii);
				juegoTest.codigoSecreto[i] = letraSecreta;			
				juegoTest.setCasilla(j, i, letraIntroducida);				
			}
			juegoTest.GenerarPista(j);
			assertFalse(juegoTest.FinalPartida(j));
		}		
	}
}
	
	