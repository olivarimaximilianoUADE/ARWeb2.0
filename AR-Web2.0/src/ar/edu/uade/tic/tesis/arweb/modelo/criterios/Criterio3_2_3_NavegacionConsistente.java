package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG61;

public class Criterio3_2_3_NavegacionConsistente extends Criterio {

	public Criterio3_2_3_NavegacionConsistente() {
		super(
				"3.2.3",
				"Navegaci�n Consistente.",
				"Los mecanismos de navegaci�n que se repiten en m�ltiples p�ginas web dentro de un conjunto de p�ginas web aparecen siempre en el mismo orden relativo cada vez que se repiten, a menos que el cambio sea provocado por el propio usuario. ",
				NivelAccesibilidad.AA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG61(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}