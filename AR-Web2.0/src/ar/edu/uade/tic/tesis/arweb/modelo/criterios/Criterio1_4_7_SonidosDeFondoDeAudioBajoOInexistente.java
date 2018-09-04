package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG56;

public class Criterio1_4_7_SonidosDeFondoDeAudioBajoOInexistente extends Criterio {

	public Criterio1_4_7_SonidosDeFondoDeAudioBajoOInexistente() {
		super(
				"1.4.7",
				"Sonido de fondo bajo o ausente.",
				"Para el contenido de sólo audio grabado que (1) contiene habla en primer plano, (2) no es un CAPTCHA sonoro o un audiologo, y (3) que no es una vocalización cuya intención principal es servir como expresión musical (como el canto o el rap), se cumple al menos uno de los siguientes casos: El audio no contiene sonidos de fondo, Los sonidos de fondo pueden ser apagados ó Los sonidos de fondo son, al menos, 20 decibelios más bajos que el discurso en primer plano, con la excepción de sonidos ocasionales que duran solamente uno o dos segundos.",
				NivelAccesibilidad.AAA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG56(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}
	
}