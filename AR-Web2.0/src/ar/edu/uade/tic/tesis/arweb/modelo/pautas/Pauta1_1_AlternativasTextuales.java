package ar.edu.uade.tic.tesis.arweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_1_1_ContenidoNoTextual;

public class Pauta1_1_AlternativasTextuales extends Pauta {

	public Pauta1_1_AlternativasTextuales() {
		super(
				"1.1", 
				"Alternativas textuales.", 
				"Proporcione alternativas textuales para todo contenido no textual, de manera que pueda modificarse para ajustarse a las necesidades de las personas, como por ejemplo en una letra mayor, braille, voz, s�mbolos o un lenguaje m�s simple.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio1_1_1_ContenidoNoTextual());
		return listaCriterios;
	}

}