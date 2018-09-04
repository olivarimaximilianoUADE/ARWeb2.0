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
				"Indicar la ubicación actual dentro de la barra de navegación.", 
				"El objetivo de esta técnica es ayudar a orientar al usuario al proporcionar información sobre la ubicación actual a través del componente de interfaz de usuario de navegación. Esta técnica es especialmente útil cuando las páginas web son pasos en una tarea que debe procesarse en orden. Proporcionar esta indicación ayuda al usuario a comprender mejor su lugar en la secuencia. La ubicación se puede indicar agregando un icono o texto, o cambiando el estado del elemento.", 
				categoriaTecnica);
	}

	/**
	 * Cuando el componente de navegación se repite dentro de un conjunto de páginas web:
	 *  1. Verifique que al usuario se le dé una indicación del elemento seleccionado actualmente dentro de la unidad de navegación.
	 *  2. Verifique que el elemento seleccionado coincida con el contenido que se muestra.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlacesPaginasSitioWeb = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Indicar ubicación actual dentro de la barra de navegación.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que se esta indicando la ubicación actual al usuario dentro de la barra de navegación.",
				"Cuando las páginas web son pasos en una tarea que debe procesarse en orden, proporcionar la ubicación actual en la bara de navegación ayuda al usuario a comprender mejor su lugar en la secuencia.");
		comprobacionEnlacesPaginasSitioWeb.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlacesPaginasSitioWeb);
		return resultadoEvaluacionTecnica;
	}

}