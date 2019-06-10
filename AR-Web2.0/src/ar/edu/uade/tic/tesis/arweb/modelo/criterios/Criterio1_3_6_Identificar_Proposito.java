package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio1_3_6_Identificar_Proposito extends Criterio {

	public Criterio1_3_6_Identificar_Proposito() {
		super(
				"1.3.6",
				"Identificar el prop�sito de la entrada.",
				"Crear contenido que pueda presentarse de diferentes formas (por ejemplo, con una disposici�n m�s simple) sin perder informaci�n o estructura.",
				NivelAccesibilidad.AAA,
				Arrays.asList("2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}
	
}
