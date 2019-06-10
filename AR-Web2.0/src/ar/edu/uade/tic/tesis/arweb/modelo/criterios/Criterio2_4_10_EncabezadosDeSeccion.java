package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG141;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG69;

public class Criterio2_4_10_EncabezadosDeSeccion extends Criterio {

	public Criterio2_4_10_EncabezadosDeSeccion() {
		super(
				"2.4.10", 
				"Encabezados de sección.",
				"Se usan encabezados de sección para organizar el contenido.",
				NivelAccesibilidad.AAA,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG141(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG69(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}
	
}