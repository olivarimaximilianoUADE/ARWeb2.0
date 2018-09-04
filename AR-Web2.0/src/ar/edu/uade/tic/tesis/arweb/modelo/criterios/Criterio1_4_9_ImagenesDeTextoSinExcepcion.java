package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC6;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC8;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC12;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC13;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC14;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC22;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC30;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG140;

public class Criterio1_4_9_ImagenesDeTextoSinExcepcion extends Criterio {

public Criterio1_4_9_ImagenesDeTextoSinExcepcion() {
	super(
			"1.4.9",
			"Imágenes de texto (sin excepciones).",
			"Las imágenes de texto sólo se utilizan como simple decoración o cuando una forma de presentación particular del texto resulta esencial para la información transmitida.",
			NivelAccesibilidad.AAA);
}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaC22(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC30(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG140(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC6(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaC8(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaC12(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaC13(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaC14(CategoriaTecnica.RECOMENDABLE));
		
		return listaTecnicas;
	}

}