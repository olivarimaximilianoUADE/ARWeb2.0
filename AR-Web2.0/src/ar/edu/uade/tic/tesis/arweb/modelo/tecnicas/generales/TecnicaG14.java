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
				"Asegurar que la informaci�n transmitida por las diferencias de color tambi�n est� disponible en texto.",
				"El objetivo de esta t�cnica es para asegurar que cuando se usan las diferencias de color para transmitir informaci�n, tales como campos de formulario requeridos, la informaci�n transmitida por las diferencias de color tambi�n son transportados de forma expl�cita en el texto.", 
				categoriaTecnica);
	}

	/**
	 * Para cada elemento en el que se usa una diferencia de color para transmitir informaci�n:
	 * 1. Verificar que la informaci�n transmitida tambi�n est� disponible en el texto y que el texto no es contenido condicional.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionInformacionMedianteColor = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Informaci�n mediante color.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la informaci�n transmitida tambi�n est� disponible en el texto y que el texto no es contenido condicional.",
				"Si se comunica informaci�n mediante el color en palabras, fondos u otros contenidos: aseg�rate que la informaci�n representada por colores est� disponible en texto.");
		comprobacionInformacionMedianteColor.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionInformacionMedianteColor);
		return resultadoEvaluacionTecnica;
	}

}