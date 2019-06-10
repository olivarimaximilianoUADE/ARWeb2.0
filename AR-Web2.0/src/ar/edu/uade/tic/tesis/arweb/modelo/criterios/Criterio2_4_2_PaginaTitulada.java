package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG127;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG88;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH25;

public class Criterio2_4_2_PaginaTitulada extends Criterio {

	public Criterio2_4_2_PaginaTitulada() {
		super(
				"2.4.2", 
				"Página titulada.",
				"Las páginas web tienen títulos que describen su tema o propósito.",
				NivelAccesibilidad.A,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG88(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG127(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaH25(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}