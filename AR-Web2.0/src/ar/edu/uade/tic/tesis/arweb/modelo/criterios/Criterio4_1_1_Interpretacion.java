package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG134;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG192;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH74;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH75;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH88;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH93;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH94;

public class Criterio4_1_1_Interpretacion extends Criterio {

	public Criterio4_1_1_Interpretacion() {
		super(
				"4.1.1",
				"Interpretación.",
				"Para contenido que se haya implementado empleando un lenguaje de marcado, los elementos cuentan con etiquetas completas de cierre y apertura, se han anidado correctamente, no contienen atributos duplicados y cualquier ID es único, excepto donde la especificación permita excepciones.",
				NivelAccesibilidad.A,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG134(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG192(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH88(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH74(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH93(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH94(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH75(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}