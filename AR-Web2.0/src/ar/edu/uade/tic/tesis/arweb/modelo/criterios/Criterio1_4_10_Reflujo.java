package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG206;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC31;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC32;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR34;

public class Criterio1_4_10_Reflujo extends Criterio {

	public Criterio1_4_10_Reflujo() {
		super(
				"1.4.10",
				"Reflujo.",
				"El contenido puede presentarse sin pérdida de información o funcionalidad y sin necesidad de hacer scroll en dos dimensiones, para:\r\n" + 
				"\r\n" + 
				"Contenido con desplazamiento vertical con un ancho equivalente a 320 píxeles CSS;\r\n" + 
				"Contenido con desplazamiento horizontal con una altura equivalente a 256 píxeles CSS;",
				NivelAccesibilidad.AA);
	}
	
	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG206(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC31(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC32(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR34(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}
}
