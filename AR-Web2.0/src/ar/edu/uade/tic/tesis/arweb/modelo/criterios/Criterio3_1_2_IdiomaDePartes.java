package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH58;

public class Criterio3_1_2_IdiomaDePartes extends Criterio {

	public Criterio3_1_2_IdiomaDePartes() {
		super(
				"3.1.2",
				"Idioma de Partes.",
				"El idioma de cada pasaje o frase en el contenido puede ser determinado por software, excepto los nombres propios, términos técnicos, palabras en un idioma indeterminado y palabras o frases que se hayan convertido en parte natural del texto que las rodea.",
				NivelAccesibilidad.AA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaH58(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}