package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaH74 extends TecnicaHTML {

	public TecnicaH74(CategoriaTecnica categoriaTecnica) {
		super(
				"H74",
				"Asegurarse de que las marcas de apertura y cierre se usan de acuerdo a la especificación.", 
				"El objetivo de esta técnica es evitar errores claves que se sabe que causan problemas de las tecnologías de apoyo cuando están tratando de analizar el contenido de lo que implica el tener de apertura y cierre de etiquetas que no se utilizan de acuerdo con las especificaciones. Estos errores se pueden evitar mediante el uso del HTML o XHTML mecanismo para especificar la versión de la tecnología y la tecnología, y asegurarse de que la página de la Web no tiene este tipo de errores en el mismo. Hay varios validadores que el desarrollador puede utilizar: en general, los informes de validación mencionan estos tipos de errores. Esta técnica se ocupa sólo de los errores relacionados con bien formados, de las etiquetas de apertura y cierre. La declaración de tipo de documento no es estrictamente necesario para este tipo de evaluación, pero especificando la declaración de tipo de documento hace que sea más fácil de usar un validador.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que hay tags de cierre para todos los elementos con tags de cierre requerido.
	 * 2. Verificar que no hay tags de cierre para todos los elementos donde los tags de cierre son prohibidos.
	 * 3. Verificar que la apertura y cierre de tags para todos los elementos están anidados correctamente.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionExistenciaTagCierreRequerido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Existencia tags de cierre requeridos.",
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que hay tags de cierre para todos los elementos con tags de cierre requerido.",
				"Sigue la especificación del estándar elegido, poniendo atención al inicio y cierre de etiquetas y a sus atributos.");
		ResultadoEvaluacionTecnicaItem comprobacionInexistenciaTagCierreProhibido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Inexistencia tags de cierre prohibidos.",
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que no hay tags de cierre para todos los elementos donde los tags de cierre son prohibidos.",
				"Sigue la especificación del estándar elegido, poniendo atención al inicio y cierre de etiquetas y a sus atributos.");
		ResultadoEvaluacionTecnicaItem comprobacionTagsAperturaCierreAnidadosCorrectamente = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Anidamiento correcto entre tags de apertura y cierre.",
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que la apertura y cierre de tags para todos los elementos están anidados correctamente.",
				"Sigue la especificación del estándar elegido, poniendo atención al inicio y cierre de etiquetas y a sus atributos.");
		comprobacionExistenciaTagCierreRequerido.procesar();
		comprobacionInexistenciaTagCierreProhibido.procesar();
		comprobacionTagsAperturaCierreAnidadosCorrectamente.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionExistenciaTagCierreRequerido);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionInexistenciaTagCierreProhibido);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTagsAperturaCierreAnidadosCorrectamente);
		return resultadoEvaluacionTecnica;
	}

}