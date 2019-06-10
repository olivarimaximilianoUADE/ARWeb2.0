package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC27;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG59;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH4;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR26;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR27;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR37;

public class Criterio2_4_3_OrdenFoco extends Criterio {

	public Criterio2_4_3_OrdenFoco() {
		super(
				"2.4.3",
				"Orden de foco.",
				"Si una página web puede navegarse secuencialmente y la secuencia de navegación afecta a su significado u operatividad, los componentes que pueden recibir el foco lo hacen en un orden que conserva íntegros su significado y operatividad",
				NivelAccesibilidad.A,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG59(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH4(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC27(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR26(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR27(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR37(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}