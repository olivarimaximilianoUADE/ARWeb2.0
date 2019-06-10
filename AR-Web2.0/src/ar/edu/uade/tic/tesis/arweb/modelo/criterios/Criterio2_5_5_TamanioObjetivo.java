package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio2_5_5_TamanioObjetivo extends Criterio {

	public Criterio2_5_5_TamanioObjetivo() {
		super(
				"2.5.5",
				"Tamaño objetivo.",
				"El tamaño del destino para las entradas de puntero es de al menos 44 por 44 píxeles CSS, excepto cuando:\r\n" + 
				"\r\n" + 
				"Equivalente:\r\n" + 
				"El objetivo está disponible a través de un enlace o control equivalente en la misma página que tiene al menos 44 por 44 píxeles CSS;\r\n" + 
				"En línea_\r\n" + 
				"El objetivo está en una oración o bloque de texto;\r\n" + 
				"Control de agente de usuario:\r\n" + 
				"El tamaño del objetivo lo determina el agente del usuario y no lo modifica el autor;\r\n" + 
				"Esencial:\r\n" + 
				"Una presentación particular del objetivo es esencial para la información que se transmite.",
				NivelAccesibilidad.AAA,
				Arrays.asList("2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}
	
}
