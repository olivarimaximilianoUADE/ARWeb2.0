package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG117 extends TecnicaGeneral {

	public TecnicaG117(CategoriaTecnica categoriaTecnica) {
		super(
				"G117",
				"El uso de texto para transmitir la información que se transmite por las variaciones en la presentación del texto.",
				"El objetivo de esta técnica es asegurar que la información transmitida a través de variaciones en el formato del texto se transmita en el texto también. Cuando la apariencia visual del texto se varía para transmitir información, el estado de la información está de forma explícita en el texto. Las variaciones en la apariencia visual se pueden hacer por los cambios de tipo de letra, tamaño de fuente, subrayado, tachado y varios atributos de otro texto. Cuando estos tipos de variaciones transmiten información, la información tiene que estar disponible en el contenido a través de texto en otro lugar. Incluyendo secciones adicionales en el documento o una descripción en línea donde la variación en la presentación del texto se produce, puede ser usado para transmitir la información.", 
				categoriaTecnica);
	}

	/**
	 * 1. Encontrar objetos donde se utilizan las variaciones en la presentación del texto para transmitir información.
	 * 2. Para aquellos artículos, verificar para determinar si la información transmitida visualmente también se indica explícitamente en el texto.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionVariacionesFormatoTexto = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Variaciones en el formato del texto se transmita en el texto.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Encontrar objetos donde se utilizan las variaciones en la presentación del texto para transmitir información y verificar para determinar si la información transmitida visualmente también se indica explícitamente en el texto.",
				"Si la tecnología ofrece una estructura semántica para comunicar la información y las relaciones (por ejemplo, HTML), comunica con texto la información que es transmitida por las variaciones en la presentación de texto.");
		comprobacionVariacionesFormatoTexto.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionVariacionesFormatoTexto);
		return resultadoEvaluacionTecnica;
	}

}