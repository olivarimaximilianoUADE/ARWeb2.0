package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG150 extends TecnicaGeneral {

	public TecnicaG150(CategoriaTecnica categoriaTecnica) {
		super(
				"G150",
				"Proporcionar alternativas basadas en texto para contenido solo de audio en vivo.",
				"El objetivo de esta técnica es permitir que los usuarios que no pueden escuchar puedan acceder a transmisiones de audio en tiempo real. Es más difícil crear alternativas precisas en tiempo real porque hay poco tiempo para corregir errores, escuchar por segunda vez o consultar a alguien para asegurarse de que las palabras se reproduzcan con precisión. También es más difícil simplificar o parafrasear información si fluye demasiado rápido.", 
				categoriaTecnica);
	}

	/**
	 * Compruebe que existe un procedimiento y una política para garantizar que las alternativas de texto se entreguen en tiempo real
	 * 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSubtitulosEnVivo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Transcripción de audio en vivo a texto.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Comprobar que existen alternativas basadas en texto para contenido solo de audio en vivo.",
				"Proporciona un enlace a una transcripción de texto por cada audio en vivo.");
		comprobacionSubtitulosEnVivo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSubtitulosEnVivo);
		return resultadoEvaluacionTecnica;
	}
	
}