package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH90 extends TecnicaHTML {

	public TecnicaH90(CategoriaTecnica categoriaTecnica) {
		super(
				"H90",
				"Indicar los controles de formulario que es obligatorio rellenar.",
				"El objetivo de esta técnica es proporcionar una clara indicación de que un control específico del formulario en una aplicación Web o formulario es requerido para la presentación de los datos con éxito. Un símbolo o texto indicando que el control es requerido está programaticamente asociado con el campo al usar el elemento label o legend para grupos de controles asociados a través de fieldset. Si un símbolo es usado, el usuario es informado de su significado antes del primer uso.",
				categoriaTecnica);
	}

	/**
	 * 1. Por cada control de formulario requerido, verificar que el estado requerido está indicado en el label o legend del control del formulario.
	 * 2. Por cada indicador de estado requerido que no se proporciona en el texto, verificar que el significado del indicador es explicado antes del control del formulario que lo usa.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEstadoRequerido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Controles de formulario no indican estado requerido.", 
				TipoResultadoEvaluacion.MANUAL,
				"Por cada control de formulario requerido, verificar que el estado requerido está indicado en el \"label\" o \"legend\" del control del formulario.",
				"Ofrece etiquetas \"label\" descriptivas para identificar los campos obligatorios con texto.");
		for (Element elementoFORM : this.getParseador().getElementos(HTMLElementName.FORM)) {
			for (Element elementoINPUT : elementoFORM.getAllElements(HTMLElementName.INPUT)) 
				comprobacionEstadoRequerido.procesar(elementoINPUT);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEstadoRequerido);
		return resultadoEvaluacionTecnica;
	}

}