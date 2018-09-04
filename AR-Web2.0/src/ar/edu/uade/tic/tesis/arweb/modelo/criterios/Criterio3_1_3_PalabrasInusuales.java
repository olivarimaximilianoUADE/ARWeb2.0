package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG101;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG55;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG62;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG112;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG70;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH40;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH60;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH54;

public class Criterio3_1_3_PalabrasInusuales extends Criterio {

	public Criterio3_1_3_PalabrasInusuales() {
		super(
				"3.1.3",
				"Palabras Inusuales.",
				"Se proporciona un mecanismo para identificar las definiciones específicas de palabras o frases usadas de modo inusual o restringido, incluyendo expresiones idiomáticas y jerga.",
				NivelAccesibilidad.AAA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG101(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG55(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG62(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG112(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG70(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH40(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH60(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH54(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}