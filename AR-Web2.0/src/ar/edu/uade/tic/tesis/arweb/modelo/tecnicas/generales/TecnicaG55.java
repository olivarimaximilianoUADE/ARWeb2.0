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
				"El objetivo de esta técnica es hacer que la definición de una palabra, frase o abreviatura esté disponible proporcionando la definición, ya sea dentro de la misma página web o en una página web diferente, y estableciendo un vínculo entre el elemento y su definición.",
				categoriaTecnica);
	}

	/**
	 * Para cada palabra, frase o abreviatura que se definirá:
	 *  1. Verifique que al menos la primera instancia del elemento sea un enlace.
	 *  2. Verifique que cada enlace navegue a la definición del artículo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlaceADeficiones = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Incluir enlaces a definiciones de palabras, frases o abreviaturas", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que las palabras, frases o abreviaturas tengan enlaces a sus definiciones.",
				"Incluir enlaces a las definiciones de palabras, frases o abreviaturas que requieran una ampliación o definiciones para poder ser comprendidos por el usuario del sitio.");
		comprobacionEnlaceADeficiones.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlaceADeficiones);
		return resultadoEvaluacionTecnica;
	}

}