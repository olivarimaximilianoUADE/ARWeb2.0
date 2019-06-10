package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC27;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC6;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC8;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG57;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH34;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH56;

public class Criterio1_3_2_SecuenciaSignificativa extends Criterio {

	public Criterio1_3_2_SecuenciaSignificativa() {
		super(
				"1.3.2",
				"Secuencia significativa.",
				"Cuando la secuencia en la que se presenta un contenido afecta a su significado, la secuencia correcta de lectura puede ser programablemente determinada.",
				NivelAccesibilidad.A,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG57(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH34(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH56(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC6(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC8(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC27(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}