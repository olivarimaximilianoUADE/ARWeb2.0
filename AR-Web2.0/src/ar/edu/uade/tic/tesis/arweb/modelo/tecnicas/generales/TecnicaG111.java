package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG111 extends TecnicaGeneral {

	public TecnicaG111(CategoriaTecnica categoriaTecnica) {
		super(
				"G111", 
				"Uso del color y el patrón.", 
				"El objetivo de esta técnica es para asegurar que cuando se usan las diferencias de color para transmitir información dentro de contenido no textual, los patrones se incluyen para transmitir la misma información de una manera que no depende de color.", 
				categoriaTecnica);
	}

	/**
	 * Para cada imagen dentro de la página Web que utilizan las diferencias de color para transmitir información:
	 * 1. Verificar que toda la información que es transmitida usando color es también transmitida usando patrones que no se basan en el color. 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionInformacionConColorYPatrones = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Información que es transmitida usando color es también transmitida usando patrones que no se basan en el color.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cada imagen dentro de la página Web que utilizan las diferencias de color para transmitir información: Verificar que toda la información que es transmitida usando color es también transmitida usando patrones que no se basan en el color.",
				"Si se comunica información mediante el color dentro de una imagen: Diferencia los datos mediante colores y motivos del dibujo. Asegúrate que la información comunicada por las diferencias de color está también disponible en el texto.");
		comprobacionInformacionConColorYPatrones.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionInformacionConColorYPatrones);
		return resultadoEvaluacionTecnica;
	}

}