package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG139;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG199;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG83;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG84;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG85;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR18;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR32;

public class Criterio3_3_1_IdentificacionErrores extends Criterio {

	public Criterio3_3_1_IdentificacionErrores() {
		super(
				"3.3.1",
				"Identificación de errores.",
				"Si se detecta automáticamente un error de entrada de datos, se identifica el ítem erróneo y el error se describe al usuario por medio de texto.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG83(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG84(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG85(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG139(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaG199(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaSCR18(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR32(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}