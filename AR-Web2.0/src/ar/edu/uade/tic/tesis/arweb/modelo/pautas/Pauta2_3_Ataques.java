package ar.edu.uade.tic.tesis.arweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_3_1_TresDestellosOPorDebajoDelUmbral;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_3_2_TresDestellos;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_3_3_AnimacionDeInteracciones;

public class Pauta2_3_Ataques extends Pauta {

	public Pauta2_3_Ataques() {
		super(
				"2.3", 
				"Ataques.", 
				"No diseñe un contenido de manera que se sepa que puede causar ataques, espasmos o convulsiones.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio2_3_1_TresDestellosOPorDebajoDelUmbral());
		listaCriterios.add(new Criterio2_3_2_TresDestellos());
		listaCriterios.add(new Criterio2_3_3_AnimacionDeInteracciones());
		return listaCriterios;
	}

}