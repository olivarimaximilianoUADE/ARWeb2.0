package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG15;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG176;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG19;

public class Criterio2_3_1_TresDestellosOPorDebajoDelUmbral extends Criterio {

	public Criterio2_3_1_TresDestellosOPorDebajoDelUmbral() {
		super(
				"2.3.1",
				"Tres destellos o por debajo del umbral.",
				"Las páginas web no contienen nada que destelle más de tres veces en cualquier período de un segundo, o el destello está por debajo de los umbrales de destello general y de destello rojo.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG19(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG176(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG15(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}