package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG21;

public class Criterio2_1_3_TecladoSinExcepcion extends Criterio {

	public Criterio2_1_3_TecladoSinExcepcion() {
		super(
				"2.1.3",
				"Teclado (sin excepción).",
				"Toda la funcionalidad del contenido se puede operar a través de una interfaz de teclado sin requerir una determinada velocidad en la pulsación de las teclas.",
				NivelAccesibilidad.AAA,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG21(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}
	
}
