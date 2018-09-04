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
				"Proporcionar un enlace a una transcripci�n de texto de una declaraci�n preparada o script si los scripts estan permitidos.",
				"El objetivo de esta t�cnica es proporcionar una transcripci�n o gui�n si el contenido de audio en vivo sigue un gui�n establecido. Debido a que est� preparado de antemano, el gui�n puede ser m�s preciso y completo que la transcripci�n en vivo. Sin embargo, la secuencia de comandos no se sincronizar� con el audio mientras se reproduce. El audio en vivo no debe desviarse del gui�n de esta t�cnica. Con esta t�cnica, se proporciona un enlace a la transcripci�n o secuencia de comandos y debe conformarse a WCAG 2.0 y podr�a incluirse en otra ubicaci�n en la misma p�gina web o en otro URI.", 
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe la presencia de un enlace que apunta directamente al gui�n o transcripci�n.
	 * 2. Verifique que el audio en vivo siga el guion.
	 * 3. Si la (s) versi�n (s) alternativa (s) est�n en una p�gina separada, verifique la disponibilidad de los enlaces para permitirle al usuario acceder a las otras versiones.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSubtitulos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Transcripci�n de texto por audio.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Comprobar la presencia de un enlace que apunta directamente al gui�n o transcripci�n.",
				"Proporciona un enlace a una transcripci�n de texto por cada audio en vivo que siga con gui�n preestablecido.");
		comprobacionSubtitulos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSubtitulos);
		return resultadoEvaluacionTecnica;
	}
	
}
