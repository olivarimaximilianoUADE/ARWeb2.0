package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG68;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG103;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG79;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG153;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG160;

public class Criterio3_1_5_NivelDeLectura extends Criterio {

	public Criterio3_1_5_NivelDeLectura() {
		super(
				"3.1.5", 
				"Nivel de lectura.",
				"Cuando un texto requiere un nivel de lectura más avanzado que el nivel mínimo de educación secundaria una vez que se han eliminado nombres propios y títulos, se proporciona un contenido suplementario o una versión que no requiere un nivel de lectura mayor a ese nivel educativo.",
				NivelAccesibilidad.AAA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG68(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG103(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG79(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG153(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG160(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}