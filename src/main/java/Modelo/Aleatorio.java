package Modelo;

public class Aleatorio {
	
	
	
	public String GenerarLetrasAleatorias() {
		
		char codigoAscii =  (char) Math.floor(Math.random()*(72 - 65)+65); 
		String Letra = Character.toString(codigoAscii);
		return Letra;
		
		
	}

}
