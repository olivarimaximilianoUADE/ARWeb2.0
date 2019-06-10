package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG125;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG64;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG63;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG161;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG126;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG185;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH59;

public class Criterio2_4_5_MultiplesMedios extends Criterio {

	public Criterio2_4_5_MultiplesMedios() {
		super(
				"2.4.5",
				"M�ltiples medios.",
				"Se proporciona m�s de un camino para localizar una p�gina web dentro de un conjunto de p�ginas web, excepto cuando la p�gina es el resultado, o un paso intermedio, de un proceso.",
				NivelAccesibilidad.AA,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG125(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG64(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG63(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG161(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG126(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG185(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH59(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}

}