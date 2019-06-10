package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio1_4_13_ContenidoConPunteroOEnfoque extends Criterio {

	public Criterio1_4_13_ContenidoConPunteroOEnfoque() {
		super(
				"1.4.13",
				"Contenido con puntero o enfoque.",
				"El lugar donde se recibe y luego se quita el puntero o el foco del teclado hace que el contenido adicional se vuelva visible y luego se oculte.",
				NivelAccesibilidad.AA,
				Arrays.asList("2.1"));
	}
	
	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}
	
}
