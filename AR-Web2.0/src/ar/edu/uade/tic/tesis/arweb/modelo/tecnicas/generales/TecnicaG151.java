package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG151 extends TecnicaGeneral {

	public TecnicaG151(CategoriaTecnica categoriaTecnica) {
		super(
				"G151",
				"Proporcionar un enlace a una transcripción de texto de una declaración preparada o script si los scripts estan permitidos.",
				"El objetivo de esta técnica es proporcionar una transcripción o guión si el contenido de audio en vivo sigue un guión establecido. Debido a que está preparado de antemano, el guión puede ser más preciso y completo que la transcripción en vivo. Sin embargo, la secuencia de comandos no se sincronizará con el audio mientras se reproduce. El audio en vivo no debe desviarse del guión de esta técnica. Con esta técnica, se proporciona un enlace a la transcripción o secuencia de comandos y debe conformarse a WCAG 2.0 y podría incluirse en otra ubicación en la misma página web o en otro URI.", 
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe la presencia de un enlace que apunta directamente al guión o transcripción.
	 * 2. Verifique que el audio en vivo siga el guion.
	 * 3. Si la (s) versión (s) alternativa (s) están en una página separada, verifique la disponibilidad de los enlaces para permitirle al usuario acceder a las otras versiones.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSubtitulos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Transcripción de texto por audio.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Comprobar la presencia de un enlace que apunta directamente al guión o transcripción.",
				"Proporciona un enlace a una transcripción de texto por cada audio en vivo que siga con guión preestablecido.");
		comprobacionSubtitulos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSubtitulos);
		return resultadoEvaluacionTecnica;
	}
	
}
