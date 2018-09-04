package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG159 extends TecnicaGeneral {

	public TecnicaG159(CategoriaTecnica categoriaTecnica) {
		super(
				"G159",
				"Proporcionar una alternativa para los medios de comunicación basados en el tiempo para el contenido de solo video.",
				"El propósito de esta técnica es proporcionar una forma alternativa accesible de presentar la información en una presentación de sólo vídeo. En una presentación de sólo vídeo, la información se presenta en una variedad de maneras, incluyendo la animación, texto o gráficos, el ajuste y el fondo, las acciones y expresiones de las personas, animales, etc. Con el fin de presentar la misma información en forma accesible, esta técnica consiste en la creación de un documento que cuenta la misma historia y presenta la misma información que el contenido de sólo vídeo pregrabado. En esta técnica, el documento sirve como una larga descripción de los contenidos e incluye toda la información importante, así como descripciones de paisajes, acciones, expresiones, etc., que forman parte de la presentación. Si se utiliza un screenplay para el contenido de sólo vídeo para crear el contenido, en primer lugar, esto puede ser un buen punto de partida. En la producción y edición, sin embargo, la versión final a menudo varía un poco del screenplay. Para utilizar el screenplay, que tendría que ser corregido para que coincida con la forma final editada de la presentación de sólo vídeo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Ver el contenido de sólo vídeo mientras se hace referencia a los medios alternativos basados en el tiempo.
	 * 2. Verificar que la información en la transcripción incluye la misma información que se encuentra en la presentación de sólo vídeo.
	 * 3. Si el vídeo incluye varias personas o personajes, verificar que la transcripción identifica qué persona o personaje está asociada con cada acción descrita.
	 * 4. Verificar que al menos una de las siguientes situaciones sea verdadera:
	 * 	a. La transcripción sí se puede determinar mediante programación del texto alternativo para el contenido de sólo vídeo.
	 * 	b. La transcripción se refiere al texto alternativo mediante programación determinada por el contenido de sólo vídeo.
	 * 5. Si las versiones alternativas están en una página separada, verificar la disponibilidad de enlaces para permitir al usuario llegar a las otras versiones.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaSoloVideo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa para los medios de comunicación basados en el tiempo para el contenido de sólo video.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la transcripción en sí se puede determinar mediante programación  del texto alternativo para el contenido de sólo video  o la transcripción se refiere al texto alternativo mediante programación determinada por el contenido de sólo video.",
				"Si el contenido es vídeo solo grabado, ofrece una alternativa que presente la misma información.");
		comprobacionAlternativaSoloVideo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaSoloVideo);
		return resultadoEvaluacionTecnica;
	}

}