package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio2_5_1_GestosDelPuntero extends Criterio {

	public Criterio2_5_1_GestosDelPuntero() {
		super(
				"2.5.1",
				"Gestos del puntero.",
				"Todas las funciones que utilizan gestos multipunto o basados ​​en ruta para la operación pueden operarse con un solo puntero sin un gesto basado en ruta, a menos que sea esencial un gesto multipunto o basado en ruta.\r\n" + 
				"Este requisito se aplica al contenido web que interpreta las acciones de puntero (es decir, esto no se aplica a las acciones que se requieren para operar el agente de usuario o la tecnología de asistencia).",
				NivelAccesibilidad.A,
				Arrays.asList("2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}
	
}
