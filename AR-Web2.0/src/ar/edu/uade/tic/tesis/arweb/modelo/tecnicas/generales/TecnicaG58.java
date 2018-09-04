package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG58 extends TecnicaGeneral {

	public TecnicaG58(CategoriaTecnica categoriaTecnica) {
		super(
				"G58",
				"Un acceso directo a la alternativa de los medios de comunicación basados en el tiempo inmediatamente al lado del contenido no textual.",
				"Con esta técnica, se proporciona un link al documento compaginado que recopile la descripción de audio y subtítulos. El documento compaginado podría estar en otro lugar, en la misma página Web o en otro URI. Un enlace al documento compaginado es inmediatamente adyacente al contenido no textual. El link puede ser inmediatamente antes o después sincronizado con el contenido multimedia. Si el documento compaginado está en la misma página Web como otros contenidos a continuación, colocar \"Fin del documento\" al final para que sepan cuándo dejar de leer y volver a su lugar anterior. Si un botón Back no llevará a la persona de nuevo al punto desde el que saltaron, se proporciona a continuación un link a la ubicación del contenido no textual.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar la presencia de un link inmediatamente antes o después del contenido no textual.
	 * 2. Verificar que es un link valido, que apunta directamente al documento ingresado de este medio sincronizado en particular.
	 * 3. Verificar la disponibilidad de un link o su función trasera para conseguir que el usuario vuelva a la localización original del contenido multimedia sincronizado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionLinkContenidoNoTextual = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Link antes o después del contenido no textual.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar la presencia de un link inmediatamente antes o después del contenido no textual.",
				"Ofrece un enlace a la alternativa de los medios tempodependientes.");
		comprobacionLinkContenidoNoTextual.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLinkContenidoNoTextual);
		return resultadoEvaluacionTecnica;
	}

}