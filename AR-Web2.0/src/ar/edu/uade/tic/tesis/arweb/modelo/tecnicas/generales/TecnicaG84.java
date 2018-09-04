package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG84 extends TecnicaGeneral {

	public TecnicaG84(CategoriaTecnica categoriaTecnica) {
		super(
				"G84",
				"Proporcionar una descripción de texto cuando el usuario proporciona información que no está en la lista de valores permitidos.",
				"Cuando los usuarios introducen de entrada que se valida y se detectan errores, la naturaleza del error necesita ser descrito para el usuario de manera que pueden acceder. Un método consiste en presentar un cuadro de diálogo de alerta que describe los campos con errores cuando el usuario intenta enviar el formulario. Otro enfoque, si la validación se realiza por el servidor, es devolver la forma (con los datos del usuario todavía en los campos) y una descripción de texto en la parte superior de la página que indica el hecho de que había un problema de validación, describe la naturaleza del problema, y proporciona maneras de localizar el campo (s) con un problema fácilmente. La parte \"en el texto\" del Criterio de relieve que no es suficiente simplemente para indicar que un campo tiene un error al poner un asterisco en la etiqueta o girando la etiqueta roja. Una descripción textual del problema debe ser proporcionada. Cuando la entrada debe ser una de un conjunto de valores permitidos, la descripción de texto debe indicar este hecho. Se debe incluir la lista de valores si es posible, o sugerir el valor permitido que más se asemeja al valor introducido.", 
				categoriaTecnica);
	}

	/**
	 * 1. Introducir datos no válidos en un campo de formulario.
	 * 2. Verificar que la información se proporciona en el texto sobre el problema.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionIdentifiqueValoresConFormatosEspeciales = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Identifique los valores que deben indicarse con formatos especiales.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que la información se proporciona en el texto sobre el problema tras introducir datos no válidos en campo de formulario.",
				"Advierte de los errores en el momento que el usuario introduzca la información y enfatiza visualmente los errores donde sucedan.");
		comprobacionIdentifiqueValoresConFormatosEspeciales.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionIdentifiqueValoresConFormatosEspeciales);
		return resultadoEvaluacionTecnica;
	}

}