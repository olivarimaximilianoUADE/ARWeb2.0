package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG149;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG165;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG195;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC15;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR31;

public class Criterio2_4_7_FocoVisible extends Criterio {

	public Criterio2_4_7_FocoVisible() {
		super(
				"2.4.7",
				"Foco Visible.",
				"Cualquier interfaz de usuario operable por teclado tiene una forma de operar en la cuál el indicador del foco del teclado resulta visible.",
				NivelAccesibilidad.AA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG149(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG165(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG195(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC15(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR31(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}
	
}