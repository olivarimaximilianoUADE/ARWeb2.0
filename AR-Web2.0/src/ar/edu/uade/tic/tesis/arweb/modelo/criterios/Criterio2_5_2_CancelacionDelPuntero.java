package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio2_5_2_CancelacionDelPuntero extends Criterio {

	public Criterio2_5_2_CancelacionDelPuntero() {
		super(
				"2.5.2",
				"Cancelación del puntero.",
				"Para la funcionalidad que puede operarse con un solo puntero, al menos uno de los siguientes es verdadero:\r\n" + 
				"\r\n" + 
				"Sin evento negativo:\r\n" + 
				"El evento descendente del puntero no se utiliza para ejecutar ninguna parte de la función;\r\n" + 
				"Abortar o Deshacer:\r\n" + 
				"La finalización de la función está en el evento ascendente, y hay un mecanismo disponible para abortar la función antes de completarla o para deshacerla después de la finalización;\r\n" + 
				"Reversión:\r\n" + 
				"El evento up invierte cualquier resultado del evento down anterior;\r\n" + 
				"Esencial:\r\n" + 
				"Completar la función en el evento descendente es esencial.\r\n" + 
				"Las funciones que emulan un teclado o la pulsación del teclado numérico se consideran esenciales.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}
	
}
