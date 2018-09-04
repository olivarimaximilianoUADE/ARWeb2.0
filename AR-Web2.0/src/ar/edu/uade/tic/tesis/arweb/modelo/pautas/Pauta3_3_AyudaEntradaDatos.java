package ar.edu.uade.tic.tesis.arweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio3_3_1_IdentificacionErrores;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio3_3_2_InstruccionesOEtiquetas;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio3_3_3_SugerenciasAnteErrores;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio3_3_4_PrevencionDeErroresLegalesFinancierosDeDatos;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio3_3_5_Ayuda;
import ar.edu.uade.tic.tesis.arweb.modelo.criterios.Criterio3_3_6_PrevencionDeErrores;

public class Pauta3_3_AyudaEntradaDatos extends Pauta{

	public Pauta3_3_AyudaEntradaDatos() {
		super(
				"3.3", 
				"Ayuda a la entrada de datos.", 
				"Ayude a los usuarios a evitar y corregir errores.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio3_3_1_IdentificacionErrores());
		listaCriterios.add(new Criterio3_3_2_InstruccionesOEtiquetas());
		listaCriterios.add(new Criterio3_3_3_SugerenciasAnteErrores());
		listaCriterios.add(new Criterio3_3_4_PrevencionDeErroresLegalesFinancierosDeDatos());
		listaCriterios.add(new Criterio3_3_5_Ayuda());
		listaCriterios.add(new Criterio3_3_6_PrevencionDeErrores());
		return listaCriterios;
	}

}