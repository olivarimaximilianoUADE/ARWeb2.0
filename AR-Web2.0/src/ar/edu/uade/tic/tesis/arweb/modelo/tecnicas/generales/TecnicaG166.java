package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG166 extends TecnicaGeneral {

	public TecnicaG166(CategoriaTecnica categoriaTecnica) {
		super(
				"G166",
				"Proporcionar audio que describe el contenido de vídeo importante y lo describió como tales.",
				"Contenido de solo vídeo es inaccesible para las personas ciegas y con algunos que tienen baja visión. Por lo tanto, es importante para ellos tener un audio alternativo. Una forma de hacer esto es proporcionar una pista de audio que describe la información en el vídeo. El audio debe ser un formato de audio común usado en Internet, tales como MP3.", 
				categoriaTecnica);
	}

	/**
	 * Para una página Web que contiene el contenido de sólo vídeo:
	 * 1. Verificar que hay un link a un audio alternativo que describe el contenido del vídeo inmediatamente antes o después del contenido de sólo vídeo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAudioDescribeContenidoVideo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Audio que describe el contenido del video.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para una página Web que contiene el contenido de sólo vídeo: Verificar que hay un link a un audio alternativo que describe el contenido del vídeo inmediatamente antes o después del contenido de sólo vídeo.",
				"Si el contenido es vídeo solo grabado, ofrece un contenido sonoro que describa el contenido más importante del video.");
		comprobacionAudioDescribeContenidoVideo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAudioDescribeContenidoVideo);
		return resultadoEvaluacionTecnica;
	}

}