package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio2_5_4_ActuacionDeMovimiento extends Criterio {

	public Criterio2_5_4_ActuacionDeMovimiento() {
		super(
				"2.5.4",
				"Actuaci�n de movimiento.",
				"La funcionalidad que puede ser operada por el movimiento del dispositivo o el movimiento del usuario tambi�n puede ser operada por los componentes de la interfaz del usuario y la respuesta al movimiento se puede deshabilitar para prevenir la activaci�n accidental, excepto cuando:\r\n" + 
				"\r\n" + 
				"Interfaz soportada:\r\n" + 
				"El movimiento se utiliza para operar la funcionalidad a trav�s de una interfaz compatible con accesibilidad;\r\n" + 
				"Esencial:\r\n" + 
				"La moci�n es esencial para la funci�n y hacerlo invalidar�a la actividad.",
				NivelAccesibilidad.A,
				Arrays.asList("2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}
	
}
