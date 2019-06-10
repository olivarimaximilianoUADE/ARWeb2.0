package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG202;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG90;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH91;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR2;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR20;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR35;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR29;

public class Criterio2_1_1_Teclado extends Criterio {

	public Criterio2_1_1_Teclado() {
		super(
				"2.1.1",
				"Teclado.",
				"Toda funcionalidad del contenido es operable a través de una interfaz de teclado sin que exista un límite de tiempo específico para realizar las pulsaciones de las teclas, excepto para cuando la funcionalidad subyacente requiere una interacción del usuario para la que es relevante no sólo los puntos finales de su movimiento sino también la ruta que traza el mismo.",
				NivelAccesibilidad.A,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG202(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG90(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH91(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR2(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR20(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR35(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR29(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}

}