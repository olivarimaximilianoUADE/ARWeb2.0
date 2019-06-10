package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG21;

public class Criterio2_1_2_SinTrampaDeTeclado extends Criterio {

	public Criterio2_1_2_SinTrampaDeTeclado() {
		super(
				"2.1.2",
				"Sin trampa de teclado.",
				"Si el foco puede moverse a un componente de la p�gina por medio de una interfaz de teclado, u otro m�todo de salida est�ndar, entonces el foco puede moverse fuera de ese componente empleando simplemente la misma interfaz de teclado y, si para ello se necesita algo m�s que la simple flecha o techa de tabulaci�n, entonces se avisa al usuario del m�todo con el que mover el foco.",
				NivelAccesibilidad.A,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG21(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}