package Modelo;

public class MockAleatorio extends Aleatorio {

	
	private int i = 0;
	private String LetrasAleatorias[] = {"A","B","C","D","E","F","G","B","D","E","G","A","C"};
	
	public String GenerarLetrasAleatorias() {
		
		
		String letra = LetrasAleatorias[i];
		i++;		
		return letra;		
		
		
	}
	
	
	
}
