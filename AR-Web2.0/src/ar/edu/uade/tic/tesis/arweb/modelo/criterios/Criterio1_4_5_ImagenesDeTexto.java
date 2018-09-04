package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG140;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC6;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC8;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC12;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC13;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC14;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC22;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC30;

public class Criterio1_4_5_ImagenesDeTexto extends Criterio {

public Criterio1_4_5_ImagenesDeTexto() {
	super(
			"1.4.5",
			"Imágenes de texto.",
			"Si con las tecnologías que se están utilizando se puede conseguir la presentación visual deseada, se utiliza texto para transmitir la información en vez de imágenes de texto, excepto en los siguientes casos: Configurable: La imagen de texto es visualmente configurable según los requisitos del usuario; Esencial: Una forma particular de presentación del texto resulta esencial para la información que se transmite.",
			NivelAccesibilidad.AA);
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