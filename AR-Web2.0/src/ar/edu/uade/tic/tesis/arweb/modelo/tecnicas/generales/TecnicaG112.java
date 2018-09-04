package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG112 extends TecnicaGeneral {

	public TecnicaG112(CategoriaTecnica categoriaTecnica) {
		super(
				"G112", 
				"Uso de definiciones en línea.",  
				"El objetivo de esta técnica es proporcionar una definición en contexto para cualquier palabra utilizada de una manera inusual o restringida. La definición se proporciona en el texto, ya sea justo antes o justo después de que se usa la palabra. La definición puede incluirse en la misma oración que la palabra que se está definiendo, o en una oración separada.", 
				categoriaTecnica);
	}

	/**
	 * Para cada palabra o frase utilizada de forma inusual o restringida:
	 *  1. Verifique que la palabra esté definida en texto antes o después de la primera aparición de la palabra. 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDefinicionEnLinea = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Cada palabra o frase inusual debe tener su explicación.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cada palabra o frase utilizada de forma inusual o restringida en el sitio denbe estar definida la misma antes o después de la primera aparición.",
				"Proporcionar una definición en contexto para cualquier palabra utilizada de una manera inusual o restringida. La definición se proporciona en el texto, ya sea justo antes o justo después de que se usa la palabra.");
		comprobacionDefinicionEnLinea.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDefinicionEnLinea);
		return resultadoEvaluacionTecnica;
	}

}