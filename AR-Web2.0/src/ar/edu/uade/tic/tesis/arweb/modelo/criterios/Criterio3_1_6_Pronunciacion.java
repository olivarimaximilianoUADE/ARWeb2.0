package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG120;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG121;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG62;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG163;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH62;

public class Criterio3_1_6_Pronunciacion extends Criterio {

	public Criterio3_1_6_Pronunciacion() {
		super(
				"3.1.6",
				"Pronunciación.",
				"Se proporciona un mecanismo para identificar la pronunciación específica de las palabras cuando el significado de esas palabras, dentro del contexto, resulta ambiguo si no se conoce su pronunciación.",
				NivelAccesibilidad.AAA,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG120(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG121(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG62(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG163(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH62(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}