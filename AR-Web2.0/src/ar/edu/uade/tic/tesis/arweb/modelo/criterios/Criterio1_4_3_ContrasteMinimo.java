package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG18;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG148;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG174;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG145;

public class Criterio1_4_3_ContrasteMinimo extends Criterio {

public Criterio1_4_3_ContrasteMinimo() {
	super(
			"1.4.3",
			"Contraste (mínimo).",
			"La presentación visual de texto e imágenes de texto tiene una relación de contraste de, al menos, 4.5:1, excepto en los siguientes casos: textos grandes, incidental y logotipos.",
			NivelAccesibilidad.AA);
}

public List<Tecnica> getTecnicasAAgregar() {
	List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
	listaTecnicas.add(new TecnicaG18(CategoriaTecnica.SUFICIENTE));
	listaTecnicas.add(new TecnicaG148(CategoriaTecnica.SUFICIENTE));
	listaTecnicas.add(new TecnicaG174(CategoriaTecnica.SUFICIENTE));
	listaTecnicas.add(new TecnicaG145(CategoriaTecnica.SUFICIENTE));
	return listaTecnicas;
}

}