package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG96;

public class Criterio1_3_3_CaracteristicasSensoriales extends Criterio {

	public Criterio1_3_3_CaracteristicasSensoriales() {
		super(
				"1.3.3",
				"Características sensoriales.",
				"Las instrucciones que se proporcionan para comprender y operar con un contenido no dependen solamente de las características sensoriales de los componentes, tales como forma, tamaño, ubicación visual, orientación o sonido.",
				NivelAccesibilidad.A,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG96(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}