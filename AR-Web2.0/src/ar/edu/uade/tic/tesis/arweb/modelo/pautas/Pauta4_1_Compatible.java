package ar.edu.uade.tic.tesis.arweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio4_1_1_Interpretacion;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio4_1_2_NombreRolValor;

public class Pauta4_1_Compatible extends Pauta {

	public Pauta4_1_Compatible() {
		super(
				"4.1", 
				"Compatible.", 
				"Maximice la compatibilidad con aplicaciones de usuarios actuales y futuros, incluyendo las ayudas técnicas.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio4_1_1_Interpretacion());
		listaCriterios.add(new Criterio4_1_2_NombreRolValor());
		return listaCriterios;
	}

}