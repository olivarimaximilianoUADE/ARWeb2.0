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
				"El objetivo de esta t�cnica es permitir que los usuarios que no pueden escuchar puedan acceder a transmisiones de audio en tiempo real. Es m�s dif�cil crear alternativas precisas en tiempo real porque hay poco tiempo para corregir errores, escuchar por segunda vez o consultar a alguien para asegurarse de que las palabras se reproduzcan con precisi�n. Tambi�n es m�s dif�cil simplificar o parafrasear informaci�n si fluye demasiado r�pido.", 
				categoriaTecnica);
	}

	/**
	 * Compruebe que existe un procedimiento y una pol�tica para garantizar que las alternativas de texto se entreguen en tiempo real
	 * 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSubtitulosEnVivo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Transcripci�n de audio en vivo a texto.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Comprobar que existen alternativas basadas en texto para contenido solo de audio en vivo.",
				"Proporciona un enlace a una transcripci�n de texto por cada audio en vivo.");
		comprobacionSubtitulosEnVivo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSubtitulosEnVivo);
		return resultadoEvaluacionTecnica;
	}
	
}