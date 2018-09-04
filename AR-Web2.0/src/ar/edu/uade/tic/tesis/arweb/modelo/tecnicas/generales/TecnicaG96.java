package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG96 extends TecnicaGeneral {

	public TecnicaG96(CategoriaTecnica categoriaTecnica) {
		super(
				"G96",
				"Proporcionar la identificación textual de artículos que de otra manera se basan únicamente en la información sensorial que se entienda.",
				"El objetivo de esta técnica es asegurar que los elementos dentro de una página web se hace referencia en el contenido , no sólo por la forma, el tamaño , el sonido o la ubicación , sino también en formas que no dependen de que la percepción sensorial . Por ejemplo , una referencia también puede describir la función del artículo o su etiqueta", 
				categoriaTecnica);
	}

	/**
	 * Buscar todas las referencias en la página Web que menciona la forma, el tamaño o la posición de un objeto. Para cada uno de esos elementos:
	 * 1. Verificar que la referencia contiene información adicional que permite que el elemento a ser localizados e identificados sin ningún conocimiento de su forma, tamaño o posición relativa.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCaracteristicasSensoriales = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Características sensoriales.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Buscar todas las referencias en la página Web que menciona la forma, el tamaño o la posición de un objeto. Para cada uno de esos elementos: Verificar que la referencia contiene información adicional que permite que el elemento a ser localizados e identificados sin ningún conocimiento de su forma, tamaño o posición relativa.",
				"Ofrece identificación textual de los elementos que de otra manera sólo dependerían de la información sensorial para ser comprendidos (por ejemplo,  \"pulsa en el cuadro grande para continuar\"). No identifiques el contenido sólo por su forma o localización. No utilices únicamente un símbolo gráfico para comunicar información.");
		comprobacionCaracteristicasSensoriales.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCaracteristicasSensoriales);
		return resultadoEvaluacionTecnica;
	}

}