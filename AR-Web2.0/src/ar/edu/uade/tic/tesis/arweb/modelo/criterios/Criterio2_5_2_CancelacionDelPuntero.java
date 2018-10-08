package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio2_5_2_CancelacionDelPuntero extends Criterio {

	public Criterio2_5_2_CancelacionDelPuntero() {
		super(
				"2.5.2",
				"Cancelaci�n del puntero.",
				"Para la funcionalidad que puede operarse con un solo puntero, al menos uno de los siguientes es verdadero:\r\n" + 
				"\r\n" + 
				"Sin evento negativo:\r\n" + 
				"El evento descendente del puntero no se utiliza para ejecutar ninguna parte de la funci�n;\r\n" + 
				"Abortar o Deshacer:\r\n" + 
				"La finalizaci�n de la funci�n est� en el evento ascendente, y hay un mecanismo disponible para abortar la funci�n antes de completarla o para deshacerla despu�s de la finalizaci�n;\r\n" + 
				"Reversi�n:\r\n" + 
				"El evento up invierte cualquier resultado del evento down anterior;\r\n" + 
				"Esencial:\r\n" + 
				"Completar la funci�n en el evento descendente es esencial.\r\n" + 
				"Las funciones que emulan un teclado o la pulsaci�n del teclado num�rico se consideran esenciales.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}
	
}
