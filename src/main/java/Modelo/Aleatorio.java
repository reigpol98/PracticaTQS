package Modelo;

/**
 * Classe que genera las letras aleatorias para el CodigoSecreto
 * @author Victor-1456556
 */

public class Aleatorio {
	/**
	 * Retorna un valor aleatorio entre (65 y 72 codigoAscii) equivalente a (A-G)
	 * @return
	 */
	public String GenerarLetrasAleatorias() {
		
		char codigoAscii =  (char) Math.floor(Math.random()*(72 - 65)+65); 
		String Letra = Character.toString(codigoAscii);
		return Letra;
		
		
	}

}
