package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG93;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG87;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG9;

public class Criterio1_2_4_SubtitulosEnDirecto extends Criterio {

	public Criterio1_2_4_SubtitulosEnDirecto() {
		super(
				"1.2.4",
				"Subtítulos (en directo).",
				"Se proporcionan subtítulos para todo el contenido de audio en directo de los multimedia sincronizados.",
				NivelAccesibilidad.AA);
	}
	
	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG93(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG87(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG9(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}