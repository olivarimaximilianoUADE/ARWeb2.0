package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio2_2_6_TiemposDeEspera  extends Criterio {

	public Criterio2_2_6_TiemposDeEspera() {
		super(
				"2.2.6",
				"Tiempos de Espera.",
				"Se advierte a los usuarios sobre la duraci�n de la inactividad de cualquier usuario que pueda causar la p�rdida de datos, a menos que los datos se conserven durante m�s de 20 horas cuando el usuario no realiza ninguna acci�n.",
				NivelAccesibilidad.AAA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}

}
