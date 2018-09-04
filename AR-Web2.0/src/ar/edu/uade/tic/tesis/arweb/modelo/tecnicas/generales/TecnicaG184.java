package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG184 extends TecnicaGeneral {

	public TecnicaG184(CategoriaTecnica categoriaTecnica) {
		super(
				"G184",
				"Proporcionar instrucciones de texto al principio de una forma o conjunto de campos que describe la entrada necesaria.",
				"El objetivo de esta técnica es ayudar al usuario a evitar errores de entrada, informándoles de antemano acerca de las restricciones sobre el formato de los datos que se deben introducir. La instrucciones de las restricciones previstas en la parte superior de las formas. Esta técnica funciona mejor para las formas que tienen un pequeño número de campos o aquellos en los que muchos campos de formulario requieren datos en el mismo formato. En estos casos, es más eficiente para describir el formato de una vez en las instrucciones en la parte superior de la forma en lugar de repetir la misma información para cada campo que tiene el mismo requisito formato restringido.", 
				categoriaTecnica);
	}

	/**
	 * 1. Identificar los controles de formulario que sólo aceptará los datos de entrada del usuario en un formato determinado.
	 * 2. Determinar si se proporcionan instrucciones en la parte superior de la forma sobre el formato esperado de cada uno de los controles de formulario identificados en 1.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFormatoDatosEsperado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Información sobre formato de datos esperado.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Determinar si se proporcionan instrucciones en la parte superior de la forma sobre el formato esperado de cada uno de los controles de formulario que sólo aceptará los datos de entrada del usuario en un formato determinado.",
				"Ofrece etiquetas \"label\" descriptivas para dar instrucciones al comienzo del formulario o de un grupo de campos.");
		comprobacionFormatoDatosEsperado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFormatoDatosEsperado);
		return resultadoEvaluacionTecnica;
	}

}