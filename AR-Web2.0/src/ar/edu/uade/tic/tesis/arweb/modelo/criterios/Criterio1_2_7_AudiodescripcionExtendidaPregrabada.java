package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH96;

public class Criterio1_2_7_AudiodescripcionExtendidaPregrabada extends Criterio {
	
	public Criterio1_2_7_AudiodescripcionExtendidaPregrabada() {
		super(
				"1.2.7",
				"Audiodescripción extendida (pregrabada)",
				"Cuando las pausas en el audio de primer plano son insuficientes para permitir que la audiodescripción comunique el significado del vídeo, se proporciona una audiodescripción ampliada para todos los contenidos de vídeo grabado dentro de contenido multimedia sincronizado.", 
				NivelAccesibilidad.AAA);
	}
	
	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaH96(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}
	
}