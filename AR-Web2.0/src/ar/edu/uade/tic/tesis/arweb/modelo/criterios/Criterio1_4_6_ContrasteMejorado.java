package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG17;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG148;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG174;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG18;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG156;

public class Criterio1_4_6_ContrasteMejorado extends Criterio{

	public Criterio1_4_6_ContrasteMejorado() {
		super(
				"1.4.6",
				"Contraste (mejorado).",
				"La presentación visual de texto e imágenes de texto tiene una relación de contraste de, al menos, 7:1, excepto en los siguientes casos: textos grandes, incidental y logotipos.",
				NivelAccesibilidad.AAA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG17(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG148(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG174(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG18(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG156(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}
	
}