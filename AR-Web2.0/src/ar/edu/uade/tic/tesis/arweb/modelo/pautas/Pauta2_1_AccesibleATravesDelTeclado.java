package ar.edu.uade.tic.tesis.arweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_1_1_Teclado;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_1_2_SinTrampaDeTeclado;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_1_3_TecladoSinExcepcion;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_1_4_AtajosDeTeclado;

public class Pauta2_1_AccesibleATravesDelTeclado extends Pauta {

	public Pauta2_1_AccesibleATravesDelTeclado() {
		super(
				"2.1", 
				"Accesible a través del teclado.", 
				"Haga que toda funcionalidad esté disponible a través del teclado.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio2_1_1_Teclado());
		listaCriterios.add(new Criterio2_1_2_SinTrampaDeTeclado());
		listaCriterios.add(new Criterio2_1_3_TecladoSinExcepcion());
		listaCriterios.add(new Criterio2_1_4_AtajosDeTeclado());
		return listaCriterios;
	}

}