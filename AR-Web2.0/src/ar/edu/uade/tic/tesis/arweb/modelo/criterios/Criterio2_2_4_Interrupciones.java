package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG75;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG76;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR14;

public class Criterio2_2_4_Interrupciones extends Criterio {

	public Criterio2_2_4_Interrupciones() {
		super(
				"2.2.4",
				"Interrupciones.",
				"El usuario puede postergar o suprimir las interrupciones, excepto cuando las interrupciones implican una emergencia.",
				NivelAccesibilidad.AAA,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG75(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG76(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR14(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}