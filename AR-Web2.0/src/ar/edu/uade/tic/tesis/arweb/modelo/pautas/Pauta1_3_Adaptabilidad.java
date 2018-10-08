package ar.edu.uade.tic.tesis.arweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_3_1_InformacionYRelaciones;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_3_2_SecuenciaSignificativa;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_3_3_CaracteristicasSensoriales;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_3_4_Orientacion;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_3_5_IdentificarPropositoEntrada;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio1_3_6_Identificar_Proposito;

public class Pauta1_3_Adaptabilidad extends Pauta {

	public Pauta1_3_Adaptabilidad() {
		super(
				"1.3", 
				"Adaptabilidad.", 
				"Cree contenidos que puedan presentarse de diversas maneras (como por ejemplo una composición más simple) sin perder la información ni su estructura.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio1_3_1_InformacionYRelaciones());
		listaCriterios.add(new Criterio1_3_2_SecuenciaSignificativa());
		listaCriterios.add(new Criterio1_3_3_CaracteristicasSensoriales());
		listaCriterios.add(new Criterio1_3_4_Orientacion());
		listaCriterios.add(new Criterio1_3_5_IdentificarPropositoEntrada());
		listaCriterios.add(new Criterio1_3_6_Identificar_Proposito());
		
		return listaCriterios;
	}

}