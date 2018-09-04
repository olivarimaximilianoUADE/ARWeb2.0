package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG120 extends TecnicaGeneral {

	public TecnicaG120(CategoriaTecnica categoriaTecnica) {
		super(
				"G120",
				"Proporcionar la pronunciaci�n inmediatamente despu�s de la palabra.",
				"El objetivo de esta t�cnica es hacer que la pronunciaci�n de una palabra est� disponible proporcionando la pronunciaci�n despu�s de la palabra al menos la primera vez que ocurre dentro de una p�gina web. Cuando una p�gina web contiene palabras con la misma ortograf�a pero diferentes pronunciaciones, esta t�cnica no es apropiada para proporcionar la pronunciaci�n a menos que se proporcione para cada instancia.", 
				categoriaTecnica);
	}

	/**
	 * Para cada palabra que requiere informaci�n de pronunciaci�n:
	 * 	1. Busque el primer uso de esa palabra en la p�gina web.
	 *  2. Verifique que el primer uso sea seguido inmediatamente por la pronunciaci�n de la palabra.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPronunciacionDespuesDeLaPalabra = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Pronunciaci�n inmediatamente despu�s de la palabra.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que luego de una palabra este la pronunciaci�n de la misma.",
				"Cuando existan palabras con una pronunciaci�n especial o compleja debe estar luego de la misma la pronunciaci�n para que el usuario pueda leerla sin inconvenientes.");
		comprobacionPronunciacionDespuesDeLaPalabra.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPronunciacionDespuesDeLaPalabra);
		return resultadoEvaluacionTecnica;
	}

}