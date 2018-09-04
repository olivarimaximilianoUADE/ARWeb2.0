package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG124 extends TecnicaGeneral {

	public TecnicaG124(CategoriaTecnica categoriaTecnica) {
		super(
				"G124", 
				"Agregar enlaces en la parte superior de la página para cada área del contenido.", 
				"El objetivo de esta técnica es proporcionar un mecanismo para evitar bloques de material proporcionando una lista de enlaces a las diferentes secciones del contenido. Los enlaces en esta lista, como una pequeña tabla de contenidos al inicio del contenido, establecer el foco en las diferentes secciones del contenido. Esta técnica es particularmente útil para las páginas con muchas secciones independientes, tales como portales. También se puede combinar con otras técnicas para saltar bloques dentro de una sección.",
				categoriaTecnica);
	}

	/**
	 * Para cada eslabón de la serie de enlaces que se proporcionan para este propósito:
	 * 1. Verificar que los únicos controles en la página Web que preceden el enlace son otros enlaces en el conjunto.
	 * 2. Verificar que la descripción de cada enlace comunica que conecta a alguna sección del contenido.
	 * 3. Verificar que el enlace está bien siempre visible o visible cuando tiene el foco del teclado.
	 * 4. Verificar que la activación del enlace mueve el foco a esa sección del contenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSaltarBloquesContenidoRepetidos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Saltar bloques de contenido repetidos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la descripción de cada enlace comunica que conecta a alguna sección del contenido.",
				"Evita al usuario tener que pasar bloques de contenido o elementos repetidos con un enlace en el principio de la página para ir directamente al contenido principal o a cada bloque de contenido.");
		comprobacionSaltarBloquesContenidoRepetidos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSaltarBloquesContenidoRepetidos);
		return resultadoEvaluacionTecnica;
	}

}