package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG141 extends TecnicaGeneral {

	public TecnicaG141(CategoriaTecnica categoriaTecnica) {
		super(
				"G141", 
				"Organizar una página usando encabezados.", 
				"El objetivo de esta técnica es la de garantizar que los artículos tienen encabezamientos que los identifican. Criterio 1.3.1 requiere que los encabezados de estar marcados de modo que pueden ser identificados mediante programación. En HTML, esto se podría hacer uso de los elementos de encabezado HTML (h1 , h2 , h3 , h4 , h5 , h6). Éstos permiten que las aplicaciones de usuario para identificar automáticamente los encabezados de sección . Otras tecnologías utilizan otras técnicas para la identificación de las cabeceras. Para facilitar la navegación y la comprensión de la estructura general del documento, los autores deben utilizar las partidas que están anidados correctamente (por ejemplo, h1 seguido de h2 , h2 seguido de h2 o h3 , h3 seguido de h3 o h4 , etc.).", 
				categoriaTecnica);
	}

	/**
	 * 1. Examinar una página con contenido organizado en secciones.
	 * 2. Verificar que existe un encabezado para cada sección.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionExistenciaEncabezadoParaCadaSeccion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Existencia de encabezados para cada sección.", 
				TipoResultadoEvaluacion.MANUAL,
				"Examinar una página con contenido organizado en secciones: Verificar que existe un encabezado para cada sección.",
				"Comunica la información y sus relaciones mediante la estructura de la página web: los elementos \"h1-h6\" para identificar encabezados.");
		comprobacionExistenciaEncabezadoParaCadaSeccion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionExistenciaEncabezadoParaCadaSeccion);
		return resultadoEvaluacionTecnica;
	}

}