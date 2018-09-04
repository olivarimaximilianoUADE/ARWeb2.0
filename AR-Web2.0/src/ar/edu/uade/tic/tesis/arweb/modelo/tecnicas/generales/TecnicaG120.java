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
				"Proporcionar la pronunciación inmediatamente después de la palabra.",
				"El objetivo de esta técnica es hacer que la pronunciación de una palabra esté disponible proporcionando la pronunciación después de la palabra al menos la primera vez que ocurre dentro de una página web. Cuando una página web contiene palabras con la misma ortografía pero diferentes pronunciaciones, esta técnica no es apropiada para proporcionar la pronunciación a menos que se proporcione para cada instancia.", 
				categoriaTecnica);
	}

	/**
	 * Para cada palabra que requiere información de pronunciación:
	 * 	1. Busque el primer uso de esa palabra en la página web.
	 *  2. Verifique que el primer uso sea seguido inmediatamente por la pronunciación de la palabra.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPronunciacionDespuesDeLaPalabra = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Pronunciación inmediatamente después de la palabra.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que luego de una palabra este la pronunciación de la misma.",
				"Cuando existan palabras con una pronunciación especial o compleja debe estar luego de la misma la pronunciación para que el usuario pueda leerla sin inconvenientes.");
		comprobacionPronunciacionDespuesDeLaPalabra.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPronunciacionDespuesDeLaPalabra);
		return resultadoEvaluacionTecnica;
	}

}