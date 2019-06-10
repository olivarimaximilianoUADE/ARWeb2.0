package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio2_5_6_MecanismosDeEntrada extends Criterio {

	public Criterio2_5_6_MecanismosDeEntrada() {
		super(
				"2.5.6",
				"Mecanismos de entrada.",
				"El contenido web no restringe el uso de las modalidades de entrada disponibles en una plataforma, excepto cuando la restricción es esencial, es necesario para garantizar la seguridad del contenido o para respetar la configuración del usuario.",
				NivelAccesibilidad.AAA,
				Arrays.asList("2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}
	
}
