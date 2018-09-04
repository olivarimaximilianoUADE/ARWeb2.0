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
				"Uso de definiciones en l�nea.",  
				"El objetivo de esta t�cnica es proporcionar una definici�n en contexto para cualquier palabra utilizada de una manera inusual o restringida. La definici�n se proporciona en el texto, ya sea justo antes o justo despu�s de que se usa la palabra. La definici�n puede incluirse en la misma oraci�n que la palabra que se est� definiendo, o en una oraci�n separada.", 
				categoriaTecnica);
	}

	/**
	 * Para cada palabra o frase utilizada de forma inusual o restringida:
	 *  1. Verifique que la palabra est� definida en texto antes o despu�s de la primera aparici�n de la palabra. 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDefinicionEnLinea = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Cada palabra o frase inusual debe tener su explicaci�n.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cada palabra o frase utilizada de forma inusual o restringida en el sitio denbe estar definida la misma antes o despu�s de la primera aparici�n.",
				"Proporcionar una definici�n en contexto para cualquier palabra utilizada de una manera inusual o restringida. La definici�n se proporciona en el texto, ya sea justo antes o justo despu�s de que se usa la palabra.");
		comprobacionDefinicionEnLinea.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDefinicionEnLinea);
		return resultadoEvaluacionTecnica;
	}

}