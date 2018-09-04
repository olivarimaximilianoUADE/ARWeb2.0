package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG19;

public class Criterio2_3_2_TresDestellos extends Criterio {

	public Criterio2_3_2_TresDestellos() {
		super(
				"2.3.2",
				"Tres destellos.",
				"Las páginas web no contienen nada que destelle más de tres veces por segundo.",
				NivelAccesibilidad.AAA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG19(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}
	
}