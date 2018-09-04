package ar.edu.uade.tic.tesis.arweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_2_1_LimiteTiempoAjustable;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_2_2_PausarDetenerOcultar;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_2_3_SinTiempo;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_2_4_Interrupciones;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_2_5_Reautenticacion;

public class Pauta2_2_TiempoSuficiente extends Pauta {

	public Pauta2_2_TiempoSuficiente() {
		super(
				"2.2", 
				"Tiempo suficiente.", 
				"Proporcione a los usuarios el tiempo suficiente para leer y usar un contenido.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio2_2_1_LimiteTiempoAjustable());
		listaCriterios.add(new Criterio2_2_2_PausarDetenerOcultar());
		listaCriterios.add(new Criterio2_2_3_SinTiempo());
		listaCriterios.add(new Criterio2_2_4_Interrupciones());
		listaCriterios.add(new Criterio2_2_5_Reautenticacion());
		return listaCriterios;
	}

}