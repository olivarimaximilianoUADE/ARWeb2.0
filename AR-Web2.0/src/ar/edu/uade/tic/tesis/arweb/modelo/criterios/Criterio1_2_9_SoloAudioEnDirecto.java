package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG151;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG150;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG157;

public class Criterio1_2_9_SoloAudioEnDirecto extends Criterio {
	
	public Criterio1_2_9_SoloAudioEnDirecto() {
		super(
				"1.2.9",
				"Sólo audio (en directo)",
				"Se proporciona una alternativa para los medios tempodependientes que presenta información equivalente para el contenido de sólo audio en directo.", 
				NivelAccesibilidad.AAA);
	}
	
	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG151(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG150(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG157(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}
	
}
