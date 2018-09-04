package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG128 extends TecnicaGeneral {

	public TecnicaG128(CategoriaTecnica categoriaTecnica) {
		super(
				"G128",
				"Indicar la ubicaci�n actual dentro de la barra de navegaci�n.", 
				"El objetivo de esta t�cnica es ayudar a orientar al usuario al proporcionar informaci�n sobre la ubicaci�n actual a trav�s del componente de interfaz de usuario de navegaci�n. Esta t�cnica es especialmente �til cuando las p�ginas web son pasos en una tarea que debe procesarse en orden. Proporcionar esta indicaci�n ayuda al usuario a comprender mejor su lugar en la secuencia. La ubicaci�n se puede indicar agregando un icono o texto, o cambiando el estado del elemento.", 
				categoriaTecnica);
	}

	/**
	 * Cuando el componente de navegaci�n se repite dentro de un conjunto de p�ginas web:
	 *  1. Verifique que al usuario se le d� una indicaci�n del elemento seleccionado actualmente dentro de la unidad de navegaci�n.
	 *  2. Verifique que el elemento seleccionado coincida con el contenido que se muestra.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlacesPaginasSitioWeb = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Indicar ubicaci�n actual dentro de la barra de navegaci�n.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que se esta indicando la ubicaci�n actual al usuario dentro de la barra de navegaci�n.",
				"Cuando las p�ginas web son pasos en una tarea que debe procesarse en orden, proporcionar la ubicaci�n actual en la bara de navegaci�n ayuda al usuario a comprender mejor su lugar en la secuencia.");
		comprobacionEnlacesPaginasSitioWeb.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlacesPaginasSitioWeb);
		return resultadoEvaluacionTecnica;
	}

}