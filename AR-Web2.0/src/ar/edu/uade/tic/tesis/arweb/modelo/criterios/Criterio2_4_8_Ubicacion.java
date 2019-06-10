package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG65;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG63;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG128;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG127;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH59;

public class Criterio2_4_8_Ubicacion extends Criterio {

	public Criterio2_4_8_Ubicacion() {
		super(
				"2.4.8",
				"Ubicación.",
				"Se proporciona información acerca de la ubicación del usuario dentro de un conjunto de páginas web.",
				NivelAccesibilidad.AAA,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG65(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG63(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG128(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG127(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH59(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}