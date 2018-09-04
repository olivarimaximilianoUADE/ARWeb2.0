package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG140 extends TecnicaGeneral {

	public TecnicaG140(CategoriaTecnica categoriaTecnica) {
		super(
				"G140",
				"Separar la información y la estructura en la presentación para permitir presentaciones diferentes.",
				"El objetivo de esta técnica es la de facilitar la interacción de la tecnología de asistencia con el contenido mediante la separación lógica de codificación estructural del contenido de la codificación de presentación. Codificación estructural es la indicación de elementos como encabezados, párrafos, listas, tablas, etc., y se realiza mediante el uso de características de la tecnología reservada para tal fin. Por el contrario, la codificación de presentación es la indicación de los efectos de formato, tales como tipo de letra, color, tamaño, posición, bordes, etc., y también es apoyado por características de la tecnología. Mientras que implican elementos de presentación visual estructura - los usuarios pueden determinar encabezados, párrafos, listas, etc., de las convenciones de formato utilizados - estas características no codifican la estructura sin ambigüedad suficiente para que la tecnología de asistencia para interactuar con la página de forma efectiva. Proporcionar capas de estructura, funcionalidad y presentación por separado permite la semántica que implica el formato para convertirse en determinaron mediante programación a través de la capa de estructura.", 
				categoriaTecnica);
	}

	/**
	 * 1. Examinar la codificación de un documento.
	 * 2. Verificar que la información estructural y la funcionalidad se proporcionan de manera explícita y está separada lógicamente de información de presentación.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionUtilizacionAtributosPresentacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Utilización de atributos de presentación.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que la información estructural y la funcionalidad se proporcionan de manera explícita y está separada lógicamente de información de presentación.",
				"Si la tecnología ofrece una estructura semántica para comunicar la información y las relaciones (por ejemplo, HTML), separa la información y la estructura de la forma de presentación para permitir al usuario disponer de diferentes presentaciones, por ejemplo, utilizando sus propias hojas de estilo.");
		ResultadoEvaluacionTecnicaItem comprobacionUtilizacionEtiquetasPresentacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Utilización de etiquetas de presentación.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que la información estructural y la funcionalidad se proporcionan de manera explícita y está separada lógicamente de información de presentación.",
				"Si la tecnología ofrece una estructura semántica para comunicar la información y las relaciones (por ejemplo, HTML), separa la información y la estructura de la forma de presentación para permitir al usuario disponer de diferentes presentaciones, por ejemplo, utilizando sus propias hojas de estilo.");
		comprobacionUtilizacionAtributosPresentacion.procesar();
		comprobacionUtilizacionEtiquetasPresentacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionUtilizacionAtributosPresentacion);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionUtilizacionEtiquetasPresentacion);
		return resultadoEvaluacionTecnica;
	}

}