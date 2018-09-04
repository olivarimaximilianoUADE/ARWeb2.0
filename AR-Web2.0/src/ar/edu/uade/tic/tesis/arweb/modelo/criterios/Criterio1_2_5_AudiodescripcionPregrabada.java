package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG203;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG78;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH96;

public class Criterio1_2_5_AudiodescripcionPregrabada extends Criterio {

	public Criterio1_2_5_AudiodescripcionPregrabada() {
		super(
				"1.2.5",
				"Audiodescripci�n (pregrabada)",
				"Se proporciona una audiodescripci�n para todo el contenido de v�deo grabado dentro de contenido multimedia sincronizado.", 
				NivelAccesibilidad.AA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG78(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG203(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH96(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}
	
}