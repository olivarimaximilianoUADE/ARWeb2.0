package ar.edu.uade.tic.tesis.arweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_4_1_SaltarBloques;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_4_2_PaginaTitulada;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_4_3_OrdenFoco;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_4_4_PropositoDeUnVinculoEnSuContexto;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_4_5_MultiplesMedios;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_4_6_EncabezadosYEtiquetas;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_4_7_FocoVisible;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_4_8_Ubicacion;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_4_9_PropositoDeLosEnlacesSoloEnlaces;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio2_4_10_EncabezadosDeSeccion;

public class Pauta2_4_Navegable extends Pauta {

	public Pauta2_4_Navegable() {
		super(
				"2.4", 
				"Navegable.", 
				"Proporcione medios que sirvan de ayuda a los usuarios a la hora de navegar, localizar contenido y determinar dónde se encuentran.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio2_4_1_SaltarBloques());
		listaCriterios.add(new Criterio2_4_2_PaginaTitulada());
		listaCriterios.add(new Criterio2_4_3_OrdenFoco());
		listaCriterios.add(new Criterio2_4_4_PropositoDeUnVinculoEnSuContexto());
		listaCriterios.add(new Criterio2_4_5_MultiplesMedios());
		listaCriterios.add(new Criterio2_4_6_EncabezadosYEtiquetas());
		listaCriterios.add(new Criterio2_4_7_FocoVisible());
		listaCriterios.add(new Criterio2_4_8_Ubicacion());
		listaCriterios.add(new Criterio2_4_9_PropositoDeLosEnlacesSoloEnlaces());
		listaCriterios.add(new Criterio2_4_10_EncabezadosDeSeccion());
		return listaCriterios;
	}

}