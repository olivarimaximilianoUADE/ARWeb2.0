package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG89 extends TecnicaGeneral {

	public TecnicaG89(CategoriaTecnica categoriaTecnica) {
		super(
				"G89", 
				"Proporcionar espera formato de datos y el ejemplo.", 
				"El objetivo de esta técnica es ayudar al usuario a evitar errores de entrada, ofreciéndoles información sobre restricciones en el formato de los datos que se deben introducir. Esto se puede hacer mediante la descripción de las características del formato o proporcionar una muestra del formato de los datos deben tener.", 
				categoriaTecnica);
	}

	/**
	 * 1. Identificar los controles de formulario que sólo aceptará los datos de entrada del usuario en un formato determinado.
	 * 2. Determinar si cada uno de los controles de formulario identificados en 1 proporciona información sobre el formato esperado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFormatoDatosEsperado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Información sobre formato de datos esperado.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Determinar si cada uno de los controles de formulario que sólo aceptará los datos de entrada del usuario en un formato determinado proporciona información sobre el formato esperado.",
				"Ofrece etiquetas \"label\" descriptivas para indicar el formato esperado de los datos y pon un ejemplo.");
		comprobacionFormatoDatosEsperado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFormatoDatosEsperado);
		return resultadoEvaluacionTecnica;
	}

}