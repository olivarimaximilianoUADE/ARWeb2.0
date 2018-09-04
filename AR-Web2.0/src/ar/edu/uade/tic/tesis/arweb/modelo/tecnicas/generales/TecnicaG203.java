package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG203 extends TecnicaGeneral {

	public TecnicaG203(CategoriaTecnica categoriaTecnica) {
		super(
				"G203", 
				"El uso de una alternativa de texto estático para describir un video busto parlante.",
				"El propósito de esta técnica es proporcionar una alternativa a la descripción de audio para la multimedia sincronizada que no dispone de información basada en el tiempo importante contenida en la parte de vídeo de la media. Esto se aplica particularmente a los vídeos de \"presentación\" en que una persona está hablando delante de un fondo inmutable, como una rueda de prensa, la empresa presidente de conversación, o anuncio del gobierno, etc. En este caso no hay \"detalles visuales importantes\", que haría justificar la descripción de audio. La descripción de audio no es necesaria cuando hay una persona que habla en contra de un fondo que no cambia porque no hay información visual basada en el tiempo en el video que es \"importante\" para la comprensión de los contenidos. El entorno es estático y por lo tanto puede ser descrito en un formato no multimedia estático, tales como texto alternativo que esta programadamente asociada con el vídeo. Todo lo que es necesario en este caso es un texto alternativo estático que contendría una descripción general del contexto del medio ambiente, cualquier apertura/cierre de créditos, cualquier texto que aparece en la parte inferior del video con el nombre del que habla, y otra información básica, si éstos se ven en la pantalla y no se pueden escuchar en el audio. Esta técnica NO se aplica a una situación en la que hay varios altavoces y donde la identidad de cada nuevo altavoz no es evidente en la pista de audio, pero se identifica en la pantalla con texto visual, ya que hablan. En este caso, la descripción de audio debe ser utilizado, y esta técnica no se aplicaría.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que no hay información importante basada en el tiempo en la pista de vídeo.
	 * 2. Verificar que la programada descripción asociada a los contenidos multimedia contiene contexto del contenido que no está contenido en la pista de audio (por ejemplo, la identificación del hablante, créditos, contexto).
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualVideoPresentacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa de texto para videos de presentación", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la programada descripción asociada a los contenidos multimedia contiene contexto del contenido que no está contenido en la pista de audio (por ejemplo, la identificación del hablante, créditos, contexto).",
				"Ofrece una versión del vídeo con una alternativa de texto estático para describir el contenido que no está en la pista de audio.");
		comprobacionAlternativaTextualVideoPresentacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualVideoPresentacion);
		return resultadoEvaluacionTecnica;
	}

}