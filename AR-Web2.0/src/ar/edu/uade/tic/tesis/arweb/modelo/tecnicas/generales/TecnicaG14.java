package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG14 extends TecnicaGeneral {

	public TecnicaG14(CategoriaTecnica categoriaTecnica) {
		super(
				"G14",
				"Asegurar que la información transmitida por las diferencias de color también está disponible en texto.",
				"El objetivo de esta técnica es para asegurar que cuando se usan las diferencias de color para transmitir información, tales como campos de formulario requeridos, la información transmitida por las diferencias de color también son transportados de forma explícita en el texto.", 
				categoriaTecnica);
	}

	/**
	 * Para cada elemento en el que se usa una diferencia de color para transmitir información:
	 * 1. Verificar que la información transmitida también está disponible en el texto y que el texto no es contenido condicional.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionInformacionMedianteColor = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Información mediante color.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la información transmitida también está disponible en el texto y que el texto no es contenido condicional.",
				"Si se comunica información mediante el color en palabras, fondos u otros contenidos: asegúrate que la información representada por colores está disponible en texto.");
		comprobacionInformacionMedianteColor.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionInformacionMedianteColor);
		return resultadoEvaluacionTecnica;
	}

}