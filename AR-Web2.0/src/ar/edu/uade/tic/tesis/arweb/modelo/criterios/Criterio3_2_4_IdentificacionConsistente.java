package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG197;

public class Criterio3_2_4_IdentificacionConsistente extends Criterio {

	public Criterio3_2_4_IdentificacionConsistente() {
		super(
				"3.2.4",
				"Identificación consistente.",
				"Los componentes que tienen la misma funcionalidad dentro de un conjunto de páginas web son identificados de manera coherente.",
				NivelAccesibilidad.AA,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG197(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}