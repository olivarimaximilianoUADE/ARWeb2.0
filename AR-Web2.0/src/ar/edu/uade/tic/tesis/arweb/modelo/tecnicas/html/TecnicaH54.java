package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaH54 extends TecnicaHTML {

	public TecnicaH54(CategoriaTecnica categoriaTecnica) {
		super(
				"H54",
				"Usar el elemento dfn para identificar la instancia de definici�n de una palabra.",
				"El objetivo de esta t�cnica es usar el \"dfn\" para marcar el uso de una palabra o frase donde est� definido. El elemento dfn se utiliza para indicar la instancia de definici�n del t�rmino adjunto. En otras palabras, marca la ocurrencia del t�rmino donde se define el t�rmino. Tenga en cuenta que encierra el t�rmino, no la definici�n.",
				categoriaTecnica);
	}

	/**
	 * 1. Identifique todas las palabras que est�n definidas en l�nea en el texto, es decir, donde la definici�n ocurre en una oraci�n cerca de la ocurrencia de la palabra.
	 * 2. Compruebe que cada palabra que se define en l�nea est� contenida en un elemento dfn.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDefinicionDentroElementoDfn = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Definiciones usando el elemento dfn.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que cuando en los texto se de una definici�n, la palabra que se define este dentro del elemento \"dfn\".",
				"Cuando en los textos del sitio se deba dar definiciones de ciertas palabras o conceptos los mismo deben estar dentro del elemento \"dfn\" no as� su definici�n.");
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDefinicionDentroElementoDfn);
		return resultadoEvaluacionTecnica;
	}
}