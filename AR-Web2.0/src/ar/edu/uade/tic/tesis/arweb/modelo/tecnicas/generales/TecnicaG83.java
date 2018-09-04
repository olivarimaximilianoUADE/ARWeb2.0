package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG83 extends TecnicaGeneral {

	public TecnicaG83(CategoriaTecnica categoriaTecnica) {
		super(
				"G83",
				"Proporcionar descripciones de texto para identificar los campos requeridos que no se completaron.",
				"El objetivo de esta técnica es notificar al usuario cuando un campo que debe ser completado no se ha completado. Cuando los usuarios no proporcionan ningún dato para campos de formulario obligatorios, la información se proporciona en el texto para que los usuarios puedan identificar qué campos fueron omitidos. Un método consiste en utilizar la validación del lado del cliente y proporcionar un cuadro de diálogo de alerta para identificar los campos obligatorios que fueron omitidos. Otro enfoque, el uso de la validación del lado del servidor, es volver a mostrar el formulario (incluyendo los datos introducidos anteriormente), ya sea con una descripción textual en la ubicación del campo obligatorio omitido, o una descripción textual que identifique los campos obligatorios omitidos.", 
				categoriaTecnica);
	}

	/**
	 * 1. Llenar un formulario, dejando deliberadamente uno o más campos en blanco requeridos (obligatorios), y enviarlo.
	 * 2. Verificar que se proporciona una descripción textual que identifica el o los campo(s) obligatorio(s) que no se completaron.
	 * 3. Verificar que los otros datos introducidos previamente por el usuario se volverán a mostrar, a menos que los datos estén en un campo relacionado con la seguridad, donde no sería adecuado retener los datos para volver a la pantalla (por ejemplo, una contraseña).
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionValoresErroneosEnFormularios = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Identifique los valores erróneos en formularios. ", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que se proporciona una descripción textual que identifica el o los campo(s) obligatorio(s) que no se completaron.",
				"Si el usuario no ha rellenado los campos obligatorios de un formulario: Identifica los campos que no han sido completados y avisa al usuario con un mensaje de texto explicando el error.");
		comprobacionValoresErroneosEnFormularios.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionValoresErroneosEnFormularios);
		return resultadoEvaluacionTecnica;
	}

}