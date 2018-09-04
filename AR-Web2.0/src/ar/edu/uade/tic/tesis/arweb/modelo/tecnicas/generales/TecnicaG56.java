package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG56 extends TecnicaGeneral {

	public TecnicaG56(CategoriaTecnica categoriaTecnica) {
		super(
				"G56",
				"Mezcla de archivos de audio para que los sonidos que no son de voz sean al menos 20 decibelios más bajos que el contenido de audio del habla.",
				"El objetivo de esta técnica es permitir que los autores incluyan el sonido detrás del habla sin que sea demasiado difícil para las personas con problemas de audición entender el habla. Asegurándose de que el habla en primer plano sea 20 db más fuerte que el sonido de fondo hace que el discurso sea 4 veces más fuerte que el audio de fondo.",
				categoriaTecnica);
	}

	/**
	 * 1. Ubique valores altos de contenido de fondo entre el habla en primer plano
	 * 2. Mida el volumen en dB (A) SPL
	 * 3. Mida el volumen del habla en primer plano en dB (A) SPL
	 * 4. Reste los valores
	 * 5. Verifique que el resultado sea 20 o mayor
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionRelacionDecibeliosSonidoAudio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"En los archivos de audio la voz debe ser 20 decibelios más alta que el resto del sonido.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que en los archivos de audio que tengan voz la misma este 20 decibelios más alta que el resto de los sonidos.",
				"Incluir en los audios del sitio la voz siempre 20 decibelios más arriba que el resto del contenido del audio.");
		comprobacionRelacionDecibeliosSonidoAudio.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionRelacionDecibeliosSonidoAudio);
		return resultadoEvaluacionTecnica;
	}

}