package mastermind;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaulerTest {
	
	
	Tauler taulerTest = new Tauler();
	
	@Test public void ConstructorTaulerTest() {
		
		assertNotEquals(null,taulerTest.tauler);
		assertEquals(10, taulerTest.getFila());
		assertEquals(10, taulerTest.getColumna());
		assertNotEquals(9, taulerTest.getFila());
		assertNotEquals(9, taulerTest.getColumna());
		assertNotEquals(11, taulerTest.getFila());
		assertNotEquals(11, taulerTest.getColumna());
		 
		 
	 }


}
