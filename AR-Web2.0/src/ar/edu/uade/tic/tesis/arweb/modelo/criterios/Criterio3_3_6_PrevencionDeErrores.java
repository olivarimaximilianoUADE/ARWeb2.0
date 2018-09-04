package ar.edu.uade.tic.tesis.arweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.Tecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG155;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG164;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG168;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG199;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG98;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales.TecnicaG99;

public class Criterio3_3_6_PrevencionDeErrores extends Criterio {

	public Criterio3_3_6_PrevencionDeErrores() {
		super(
				"3.3.6",
				"Ayuda.",
				"Para las páginas web que requieren al usuario el envío de información, se cumple al menos uno de los siguientes casos: El envío es reversible, Se verifica la información para detectar errores en la entrada de datos y se proporciona al usuario una oportunidad de corregirlos o Se proporciona un mecanismo para revisar, confirmar y corregir la información antes de finalizar el envío de los datos.",
				NivelAccesibilidad.AAA);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG164(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG98(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG155(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG99(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG168(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG199(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}

}