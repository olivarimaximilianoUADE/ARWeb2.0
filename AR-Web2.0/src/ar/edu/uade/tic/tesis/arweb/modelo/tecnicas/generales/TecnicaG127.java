package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG127 extends TecnicaGeneral {

	public TecnicaG127(CategoriaTecnica categoriaTecnica) {
		super(
				"G127", 
				"Identificar la relación de una página Web con una gran colección de páginas Web.", 
				"El objetivo de esta técnica es que los usuarios puedan identificar la relación entre la página Web actual y otras páginas Web en la misma colección (por ejemplo, en el mismo sitio web). En algunos casos esto se puede hacer mediante programación, por ejemplo mediante el atributo rel del elemento link  en HTML. En otros casos, la información se proporciona mediante la inclusión de la información relevante en el título de la página Web.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar si el título de la página Web describe la relación de la página Web de la colección a la que pertenece.
	 * 2. Verificar si la página Web incluye metadatos que identifican la relación de la página Web de la colección a la que pertenece.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTituloDescribeRelacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Título de la página Web describe la relación de la página Web de la colección a la que pertenece.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar si el título de la página Web describe la relación de la página Web de la colección a la que pertenece.",
				"Identifica la relación de la página web con un conjunto de páginas.");
		comprobacionTituloDescribeRelacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTituloDescribeRelacion);
		return resultadoEvaluacionTecnica;
	}

}