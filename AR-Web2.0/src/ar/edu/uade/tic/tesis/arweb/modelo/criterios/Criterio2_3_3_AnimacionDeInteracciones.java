package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio2_3_3_AnimacionDeInteracciones extends Criterio {

	public Criterio2_3_3_AnimacionDeInteracciones() {
		super(
				"2.3.3",
				"Animación de interacciones.",
				"La animación de movimiento activada por la interacción se puede desactivar, a menos que la animación sea esencial para la funcionalidad o la información que se transmite.",
				NivelAccesibilidad.AAA,
				Arrays.asList("2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}
	
}
