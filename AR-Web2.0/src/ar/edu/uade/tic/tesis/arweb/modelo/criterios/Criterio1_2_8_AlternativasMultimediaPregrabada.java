package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG69;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG58;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG53;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG159;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH46;

public class Criterio1_2_8_AlternativasMultimediaPregrabada extends Criterio{
	
	public Criterio1_2_8_AlternativasMultimediaPregrabada() {
		super(
				"1.2.8",
				"Alternativas multimedia (pregrabada)",
				"Se proporciona una alternativa para los medios tempodependientes, tanto para todos los contenidos multimedia sincronizados grabados como para todos los medios de sólo vídeo grabado.", 
				NivelAccesibilidad.AAA);
	}
	
	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG69(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG58(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG53(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG159(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH46(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}
	
}
