package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG91;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG168;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH2;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH24;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH30;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH33;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC7;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR30;

public class Criterio2_4_9_PropositoDeLosEnlacesSoloEnlaces extends Criterio {

	public Criterio2_4_9_PropositoDeLosEnlacesSoloEnlaces() {
		super(
				"2.4.9",
				"Propósito de los enlaces (sólo enlaces).",
				"Se proporciona un mecanismo que permite identificar el propósito de cada enlace con sólo el texto del enlace, excepto cuando el propósito del enlace resultara ambiguo para los usuarios en general.",
				NivelAccesibilidad.AAA,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG91(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG168(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH30(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH24(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC7(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR30(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH2(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaH33(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}
	
}