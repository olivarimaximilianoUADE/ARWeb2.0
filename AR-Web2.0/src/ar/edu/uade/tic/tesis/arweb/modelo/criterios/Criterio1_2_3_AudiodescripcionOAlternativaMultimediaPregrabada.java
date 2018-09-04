package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG203;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG58;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG69;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG78;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH53;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH96;

public class Criterio1_2_3_AudiodescripcionOAlternativaMultimediaPregrabada extends Criterio {

	public Criterio1_2_3_AudiodescripcionOAlternativaMultimediaPregrabada() {
		super(
				"1.2.3",
				"Audiodescripci�n o alternativa multimedia (pregrabada).",
				"Se proporciona una alternativa para contenido multimedia dependiente del tiempo o una audiodescripci�n para el contenido de v�deo pregrabado del contenido multimedia sincronizado, excepto cuando tal contenido es un contenido multimedia alternativo al texto y est� claramente identificado como tal.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG69(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG58(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG78(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG203(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH53(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH96(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}

}