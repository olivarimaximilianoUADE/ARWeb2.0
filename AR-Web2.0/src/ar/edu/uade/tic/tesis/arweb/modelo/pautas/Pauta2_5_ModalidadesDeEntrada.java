package ar.edu.uade.tic.tesis.arweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_5_1_GestosDelPuntero;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_5_2_CancelacionDelPuntero;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_5_3_EtiquetaEnNombre;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_5_4_ActuacionDeMovimiento;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_5_5_TamanioObjetivo;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_5_6_MecanismosDeEntrada;

public class Pauta2_5_ModalidadesDeEntrada extends Pauta {

	public Pauta2_5_ModalidadesDeEntrada() {
		super(
				"2.5", 
				"Modalides de entrada.", 
				"Facilitar a los usuarios el funcionamiento de la funcionalidad a través de varias entradas más allá del teclado.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio2_5_1_GestosDelPuntero());
		listaCriterios.add(new Criterio2_5_2_CancelacionDelPuntero());
		listaCriterios.add(new Criterio2_5_3_EtiquetaEnNombre());
		listaCriterios.add(new Criterio2_5_4_ActuacionDeMovimiento());
		listaCriterios.add(new Criterio2_5_5_TamanioObjetivo());
		listaCriterios.add(new Criterio2_5_6_MecanismosDeEntrada());
		return listaCriterios;
	}
	
}
