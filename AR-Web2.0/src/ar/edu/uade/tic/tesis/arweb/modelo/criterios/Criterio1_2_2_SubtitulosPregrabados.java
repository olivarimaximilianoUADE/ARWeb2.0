package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG87;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG93;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH95;

public class Criterio1_2_2_SubtitulosPregrabados extends Criterio {

	public Criterio1_2_2_SubtitulosPregrabados() {
		super(
				"1.2.2",
				"Subt�tulos (pregrabados).",
				"Se proporcionan subt�tulos para todo audio pregrabado presente en un contenido multimedia sincronizado, excepto cuando tal contenido es un contenido multimedia alternativo al texto y est� claramente identificado como tal.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG93(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG87(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH95(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}
