package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG78 extends TecnicaGeneral {

	public TecnicaG78(CategoriaTecnica categoriaTecnica) {
		super(
				"G78",
				"Proporcionar un segundo, seleccionable por el usuario, pista de audio que incluye descripciones de audio.",
				"El objetivo de esta técnica es proporcionar una versión de audio (hablado) de la información que se proporciona visualmente por lo que es posible para las personas que no pueden ver ser capaz de entender el material audiovisual. Dado que los agentes de usuario hoy en día no se puede combinar múltiples pistas de sonido, esta técnica añade la información de audio adicional a los medios sincronizados, proporcionando una opción que permite a los usuarios reemplazar la banda sonora con una nueva copia de la banda sonora original que tiene la descripción de audio adicional añadido. Esta información añadida se centra en acciones, personajes, cambios de escena y en pantalla de texto (capturas) que son importantes para entender el contenido. Dado que no es útil contar con esta nueva información de la información de audio clave oscura en la banda sonora original (o ser oscurecida por los efectos de sonido altos), se añade la nueva información durante las pausas en el diálogo y efectos de sonido. Esto limita la cantidad de información suplementaria que puede ser añadido al programa. La banda sonora con la descripción de audio (de la información visual) puede ser o bien una pista de sonido alternativo que el usuario puede elegir, o puede ser la pista de sonido estándar que todo el mundo escucha.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que existe la capacidad para encender la pista de audio que incluye descripciones de audio. Por ejemplo, mediante el uso de un control en el contenido en sí mismo o mediante la selección de un control o de preferencia en el reproductor multimedia o en el sistema operativo.
	 * 2. Escuchar el contenido multimedia sincronizado.
	 * 3. Verificar si las lagunas en el diálogo se utilizan para transmitir información importante relacionada con el contenido visual.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPistaAudio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Capacidad para encesder la pista de audio que incluye descripciones de audio.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que existe la capacidad para encender la pista de audio que incluye descripciones de audio.",
				"Agrega una segunda pista de sonido, seleccionable por el usuario, que incluya la audiodescripción (sistema destinado a personas con discapacidad visual, mediante el cual se suministra información sonora que traduce o explica un contenido visual, como los gestos de un personaje,  el vestuario, los paisajes, etc.)");
		comprobacionPistaAudio.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPistaAudio);
		return resultadoEvaluacionTecnica;
	}

}