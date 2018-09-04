package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG85 extends TecnicaGeneral {

	public TecnicaG85(CategoriaTecnica categoriaTecnica) {
		super(
				"G85",
				"Proporcionar una descripción de texto cuando la entrada del usuario se encuentra fuera del formato o valores requeridos.",
				"El objetivo de esta técnica es proporcionar ayuda en la corrección de errores de entrada, donde la información suministrada por el usuario no se acepta. Cuando los usuarios introducen los datos de entrada que se valida y se detectan errores de entrada, se proporciona información sobre la naturaleza y la ubicación del error de entrada de texto para que los usuarios puedan identificar el problema. Un método consiste en utilizar la validación del lado del cliente y proporcionar un cuadro de diálogo de alerta que describe el error inmediatamente cuando los usuarios introducen datos no válidos en el campo. Otro enfoque, el uso de la validación del lado del servidor, es volver a mostrar el formulario (incluyendo los datos introducidos anteriormente), y una descripción de texto en la parte superior de la página que indica el hecho de que hubo un error, se describe la naturaleza del problema y proporciona maneras de localizar fácilmente el campo (s) con un problema.", 
				categoriaTecnica);
	}

	/**
	 * 1. Llenar un formulario, introducir deliberadamente la entrada del usuario que está fuera del formato o valores requeridos.
	 * 2. Verificar que se proporciona una descripción de texto que identifica el campo en el error y proporciona información sobre la naturaleza de la entrada inválida y cómo solucionarlo.
	 * 3. Verificar que los otros datos introducidos previamente por el usuario se volverá a mostrar, a menos que los datos están en un campo relacionado con la seguridad, donde no sería adecuado para retener los datos para volver a la pantalla (por ejemplo, una contraseña).
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionIdentifiqueValoresConFormatosEspeciales = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Identifique los valores que deben indicarse con formatos especiales.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que se proporciona una descripción de texto que identifica el campo en el error y proporciona información sobre la naturaleza de la entrada inválida y cómo solucionarlo.",
				"Avisa al usuario con un mensaje de texto explicando el error.");
		comprobacionIdentifiqueValoresConFormatosEspeciales.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionIdentifiqueValoresConFormatosEspeciales);
		return resultadoEvaluacionTecnica;
	}

}