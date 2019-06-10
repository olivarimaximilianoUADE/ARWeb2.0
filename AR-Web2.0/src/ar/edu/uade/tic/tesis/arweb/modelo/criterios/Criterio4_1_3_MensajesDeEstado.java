package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG83;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG84;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG85;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG139;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG177;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG194;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG199;

public class Criterio4_1_3_MensajesDeEstado extends Criterio {

	public Criterio4_1_3_MensajesDeEstado() {
		super(
				"4.1.3",
				"Mensajes de estado.",
				"En el contenido implementado utilizando lenguajes de marcado, los mensajes de estado se pueden determinar mediante roles o propiedades, de modo que se puedan presentar al usuario mediante tecnologías de asistencia sin recibir atención.",
				NivelAccesibilidad.AA,
				Arrays.asList("2.1"));
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG83(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG84(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG85(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG139(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG177(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG194(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG199(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}
