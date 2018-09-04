package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG158 extends TecnicaGeneral {

	public TecnicaG158(CategoriaTecnica categoriaTecnica) {
		super(
				"G158",
				"Proporcionar una alternativa para los medios de comunicación basada en el tiempo para el contenido de sólo audio.",
				"El propósito de esta técnica es proporcionar una forma alternativa accesible de representar la información en una presentación de sólo audio. En una presentación de sólo audio, la información se presenta en una variedad de maneras, incluyendo el diálogo y sonidos (tanto naturales y artificiales). Con el fin de presentar la misma información en forma accesible, esta técnica implica la creación de un documento que cuenta la misma historia y presenta la misma información que el contenido de solo audio pregrabado. En esta técnica, el documento sirve una larga descripción por el contenido e incluye la totalidad del diálogo importante y así como descripciones de los sonidos de fondo, etc., que son parte de la historia.", 
				categoriaTecnica);
	}

	/**
	 * 1. Ver el contenido de sólo audio mientras se hace referencia a la alternativa de los medios alternativos basados en el tiempo.
	 * 2. Verificar que el diálogo en la transcripción coincide con el diálogo y la información presentada en la presentación de sólo audio.
	 * 3. Si el audio incluye múltiples voces, verificar que la transcripción identifica quién está hablando de todo diálogo.
	 * 4. Verificar que al menos una de las siguientes situaciones es verdadera:
	 * 	a. La transcripción en sí se puede determinar mediante programación de la del texto alternativo para el contenido de sólo audio.
	 * 	b. La transcripción se refiere al texto alternativo mediante programación determinada por el contenido de sólo audio.
	 * 5. Si las versiones alternativas están en una página separada, verificar la disponibilidad de enlaces para permitir al usuario llegar a las otras versiones.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaSoloAudio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa para los medios de comunicación basada en el tiempo para el contenido de sólo audio.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la transcripción en sí se puede determinar mediante programación de la del texto alternativo para el contenido de sólo audio o la transcripción se refiere al texto alternativo mediante programación determinada por el contenido de sólo audio.",
				"Si el contenido es sonido solo grabado, ofrece una alternativa que presente la misma información.");
		comprobacionAlternativaSoloAudio.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaSoloAudio);
		return resultadoEvaluacionTecnica;
	}

}