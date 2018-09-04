package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG71;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG193;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG194;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG184;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG89;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH89;

public class Criterio3_3_5_Ayuda extends Criterio {

	public Criterio3_3_5_Ayuda() {
		super(
				"3.3.5",
				"Ayuda.",
				"Se proporciona ayuda dependiente del contexto.",
				NivelAccesibilidad.AAA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG71(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG193(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG194(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG184(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG89(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH89(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}

}