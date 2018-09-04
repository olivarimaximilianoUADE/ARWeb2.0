package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG55 extends TecnicaGeneral {

	public TecnicaG55(CategoriaTecnica categoriaTecnica) {
		super(
				"G55",
				"Enlaces a las definiciones.", 
				"El objetivo de esta t�cnica es hacer que la definici�n de una palabra, frase o abreviatura est� disponible proporcionando la definici�n, ya sea dentro de la misma p�gina web o en una p�gina web diferente, y estableciendo un v�nculo entre el elemento y su definici�n.",
				categoriaTecnica);
	}

	/**
	 * Para cada palabra, frase o abreviatura que se definir�:
	 *  1. Verifique que al menos la primera instancia del elemento sea un enlace.
	 *  2. Verifique que cada enlace navegue a la definici�n del art�culo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlaceADeficiones = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Incluir enlaces a definiciones de palabras, frases o abreviaturas", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que las palabras, frases o abreviaturas tengan enlaces a sus definiciones.",
				"Incluir enlaces a las definiciones de palabras, frases o abreviaturas que requieran una ampliaci�n o definiciones para poder ser comprendidos por el usuario del sitio.");
		comprobacionEnlaceADeficiones.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlaceADeficiones);
		return resultadoEvaluacionTecnica;
	}

}