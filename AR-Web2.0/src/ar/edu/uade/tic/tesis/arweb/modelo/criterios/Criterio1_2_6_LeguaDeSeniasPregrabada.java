package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG54;

public class Criterio1_2_6_LeguaDeSeniasPregrabada extends Criterio {

	public Criterio1_2_6_LeguaDeSeniasPregrabada() {
		super(
				"1.2.6",
				"Lengua de Se�as (pregrabada)",
				"Se proporciona una interpretaci�n en lengua de se�as para todo el contenido de audio grabado dentro de contenido multimedia sincronizado.", 
				NivelAccesibilidad.AAA);
	}
	
	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG54(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}
	
}