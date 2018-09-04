package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG142;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG146;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG178;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG179;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC28;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC12;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC13;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC14;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC17;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC20;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC22;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR34;

public class Criterio1_4_4_VariarElTamañoDelTexto extends Criterio {

public Criterio1_4_4_VariarElTamañoDelTexto() {
	super(
			"1.4.4",
			"Variar el tamaño del texto.",
			"A excepción de los subtítulos y las imágenes de texto, todo el texto puede ser ajustado sin ayudas técnicas hasta un 200 por ciento sin que se pierdan el contenido o la funcionalidad.",
			NivelAccesibilidad.AA);
}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG142(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG146(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG178(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG179(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC28(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC12(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC13(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC14(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR34(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC17(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaC20(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaC22(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}

}