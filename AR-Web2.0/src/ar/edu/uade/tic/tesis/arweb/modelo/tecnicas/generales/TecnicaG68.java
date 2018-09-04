package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG68 extends TecnicaGeneral {

	public TecnicaG68(CategoriaTecnica categoriaTecnica) {
		super(
				"G68",
				"Proporcionar una alternativa de texto corto que describe el propósito del contenido en vivo de sólo audio en directo y sólo vídeo.",
				"Esta técnica ofrece una alternativa textual corta para el contenido en vivo de sólo audio y solo video. Este texto puede ser utilizado en combinación con una alternativa de texto completo de los medios de comunicación basados en el tiempo (por audio o video), o en combinación con la descripción de audio (para vídeo). Esas alternativas, sin embargo, no son parte de esta técnica. El propósito de esta técnica es asegurar que el usuario pueda determinar cuál es el contenido no textual, incluso si no pueden acceder a el. NOTA: Aunque las alternativas completas también están disponibles, es importante que los usuarios sean capaces de identificar el contenido no textual cuando se encuentran con él para que no se confundan, y para que puedan asociarlo con la alternativa completa cuando se encuentran con ella.", 
				categoriaTecnica);
	}

	/**
	 * 1. Eliminar, ocultar o enmascarar el contenido no textual.
	 * 2. Mostrar la/s alternativa de texto corto/s.
	 * 3. Verificar que el propósito del contenido no textual es claro, incluso si el contenido se pierde.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualDescribeContenidoAudioVideo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativas textuales describen propósito contenido audio y video.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el propósito del contenido no textual es claro, incluso si el contenido se pierde.",
				"Si el contenido no textual es un vídeo solo en directo o un sonido solo en directo describe el contenido no textual o su objetivo con una técnica de descripción corta.");
		comprobacionAlternativaTextualDescribeContenidoAudioVideo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualDescribeContenidoAudioVideo);
		return resultadoEvaluacionTecnica;
	}

}