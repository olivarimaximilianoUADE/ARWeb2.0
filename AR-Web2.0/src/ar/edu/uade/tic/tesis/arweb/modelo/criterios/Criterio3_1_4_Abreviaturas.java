package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG102;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG55;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG62;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG97;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH28;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH60;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH70;

public class Criterio3_1_4_Abreviaturas extends Criterio {

	public Criterio3_1_4_Abreviaturas() {
		super(
				"3.1.4",
				"Abreviaturas.",
				"Se proporciona un mecanismo para identificar la forma expandida o el significado de las abreviaturas.",
				NivelAccesibilidad.AAA,
				Arrays.asList("2.0","2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG102(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG97(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG55(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG62(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH28(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH60(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH70(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}