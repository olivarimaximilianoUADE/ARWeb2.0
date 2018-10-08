package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio1_3_6_Identificar_Proposito extends Criterio {

	public Criterio1_3_6_Identificar_Proposito() {
		super(
				"1.3.6",
				"Identificar el propósito de la entrada.",
				"Crear contenido que pueda presentarse de diferentes formas (por ejemplo, con una disposición más simple) sin perder información o estructura.",
				NivelAccesibilidad.AAA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}
	
}
