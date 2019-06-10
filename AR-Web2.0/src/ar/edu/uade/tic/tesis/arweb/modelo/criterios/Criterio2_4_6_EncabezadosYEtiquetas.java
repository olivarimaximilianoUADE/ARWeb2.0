package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG130;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG131;

public class Criterio2_4_6_EncabezadosYEtiquetas extends Criterio {

	public Criterio2_4_6_EncabezadosYEtiquetas() {
		super(
				"2.4.6",
				"Encabezados y etiquetas.",
				"Los encabezados y etiquetas describen el tema o propósito.",
				NivelAccesibilidad.AA,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG130(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG131(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}
	
}