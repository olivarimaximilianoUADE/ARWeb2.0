package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH98;

public class Criterio1_3_5_IdentificarPropositoEntrada extends Criterio {

	public Criterio1_3_5_IdentificarPropositoEntrada() {
		super(
				"1.3.5",
				"Identificar el propósito de la entrada.",
				"Crear contenido que pueda presentarse de diferentes formas (por ejemplo, con una disposición más simple) sin perder información o estructura.",
				NivelAccesibilidad.AA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaH98(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}
	
}
