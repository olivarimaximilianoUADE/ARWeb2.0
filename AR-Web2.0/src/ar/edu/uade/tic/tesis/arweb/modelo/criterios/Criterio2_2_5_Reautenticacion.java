package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG105;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG181;

public class Criterio2_2_5_Reautenticacion extends Criterio {

	public Criterio2_2_5_Reautenticacion() {
		super(
				"2.2.5",
				"Re-autentificación.",
				"Cuando expira una sesión autentificada, el usuario puede continuar la actividad sin pérdida de datos tras volver a identificarse.",
				NivelAccesibilidad.AAA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG105(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG181(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}