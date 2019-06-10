package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio2_5_4_ActuacionDeMovimiento extends Criterio {

	public Criterio2_5_4_ActuacionDeMovimiento() {
		super(
				"2.5.4",
				"Actuación de movimiento.",
				"La funcionalidad que puede ser operada por el movimiento del dispositivo o el movimiento del usuario también puede ser operada por los componentes de la interfaz del usuario y la respuesta al movimiento se puede deshabilitar para prevenir la activación accidental, excepto cuando:\r\n" + 
				"\r\n" + 
				"Interfaz soportada:\r\n" + 
				"El movimiento se utiliza para operar la funcionalidad a través de una interfaz compatible con accesibilidad;\r\n" + 
				"Esencial:\r\n" + 
				"La moción es esencial para la función y hacerlo invalidaría la actividad.",
				NivelAccesibilidad.A,
				Arrays.asList("2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}
	
}
