package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css.TecnicaC15;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG111;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG14;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG182;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG183;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG205;

public class Criterio1_4_1_UsoColor extends Criterio {

	public Criterio1_4_1_UsoColor() {
		super(
				"1.4.1",
				"Uso del color.",
				"El color no se emplea como el �nico medio visual para transmitir una informaci�n, indicar una acci�n, provocar una respuesta o distinguir visualmente un elemento.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG14(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG205(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG182(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG183(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG111(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC15(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}

}