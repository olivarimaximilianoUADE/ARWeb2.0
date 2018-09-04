package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG82 extends TecnicaGeneral {

	public TecnicaG82(CategoriaTecnica categoriaTecnica) {
		super(
				"G82",
				"Proporcionar una alternativa de texto que identifica el propósito del contenido no textual.",
				"El propósito de esta técnica es proporcionar información útil a través de la alternativa textual, incluso si la función completa del contenido no textual no puede proporcionarse. A veces, una alternativa textual no puede servir al mismo propósito que el contenido original no textual (por ejemplo, un applet destinado a desarrollar dos habilidades de orientación rápidas dimensionales y la coordinación ojo-mano). En estos casos se utiliza esta técnica. Con esta técnica se proporciona una descripción de la finalidad del contenido no textual.", 
				categoriaTecnica);
	}

	/**
	 * 1. Eliminar, ocultar o enmascarar el contenido no textual.
	 * 2. Reemplazarlo con el texto alternativo.
	 * 3. Verificar que el propósito del contenido no textual es claro - incluso si se pierde la función.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualIdentificaPropositoContenidoNoTextual = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa textual identifica el propósito del contenido no textual.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el propósito del contenido no textual es claro - incluso si se pierde la función.",
				"Asegúrate que el contenido no textual identifica el propósito del contenido no textual.");
		comprobacionAlternativaTextualIdentificaPropositoContenidoNoTextual.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualIdentificaPropositoContenidoNoTextual);
		return resultadoEvaluacionTecnica;
	}

}