package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;

public class Criterio2_5_5_TamanioObjetivo extends Criterio {

	public Criterio2_5_5_TamanioObjetivo() {
		super(
				"2.5.5",
				"Tama�o objetivo.",
				"El tama�o del destino para las entradas de puntero es de al menos 44 por 44 p�xeles CSS, excepto cuando:\r\n" + 
				"\r\n" + 
				"Equivalente:\r\n" + 
				"El objetivo est� disponible a trav�s de un enlace o control equivalente en la misma p�gina que tiene al menos 44 por 44 p�xeles CSS;\r\n" + 
				"En l�nea_\r\n" + 
				"El objetivo est� en una oraci�n o bloque de texto;\r\n" + 
				"Control de agente de usuario:\r\n" + 
				"El tama�o del objetivo lo determina el agente del usuario y no lo modifica el autor;\r\n" + 
				"Esencial:\r\n" + 
				"Una presentaci�n particular del objetivo es esencial para la informaci�n que se transmite.",
				NivelAccesibilidad.AAA,
				Arrays.asList("2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		return listaTecnicas;
	}
	
}
