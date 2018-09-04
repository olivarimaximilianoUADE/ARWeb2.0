package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG76;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG110;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH76;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH83;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR19;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script.TecnicaSCR24;

public class Criterio3_2_5_CambioAPeticion extends Criterio {

	public Criterio3_2_5_CambioAPeticion() {
		super(
				"3.2.5",
				"Cambios a Petición.",
				"Los cambios en el contexto son iniciados únicamente a solicitud del usuario o se proporciona un mecanismo para detener tales cambios.",
				NivelAccesibilidad.AAA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG76(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG110(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH76(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH83(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR19(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaSCR24(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}