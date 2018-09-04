package ar.edu.uade.tic.tesis.arweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio3_1_1_IdiomaDeLaPagina;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio3_1_2_IdiomaDePartes;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio3_1_3_PalabrasInusuales;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio3_1_4_Abreviaturas;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio3_1_5_NivelDeLectura;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio3_1_6_Pronunciacion;

public class Pauta3_1_Legible extends Pauta {

	public Pauta3_1_Legible() {
		super(
				"3.1", 
				"Legible.", 
				"Haga el contenido textual legible y comprensible.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio3_1_1_IdiomaDeLaPagina());
		listaCriterios.add(new Criterio3_1_2_IdiomaDePartes());
		listaCriterios.add(new Criterio3_1_3_PalabrasInusuales());
		listaCriterios.add(new Criterio3_1_4_Abreviaturas());
		listaCriterios.add(new Criterio3_1_5_NivelDeLectura());
		listaCriterios.add(new Criterio3_1_6_Pronunciacion());
		return listaCriterios;
	}

}