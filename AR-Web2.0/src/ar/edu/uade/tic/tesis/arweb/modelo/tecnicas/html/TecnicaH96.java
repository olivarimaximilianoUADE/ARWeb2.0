package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH96 extends TecnicaHTML {

	public TecnicaH96(CategoriaTecnica categoriaTecnica) {
		super(
				"H96", 
				"Usar el elemento track para proporcionar descripciones de audio.", 
				"El objetivo de esta técnica es utilizar el elemento track para especificar una pista de texto de descripciones temporizadas para un elemento video. Pistas de texto de descripciones de audio temporizadas contiene descripciones de componente de video del recurso multimedia, destinados a la sintesís de audio cuando el componente visual es oscurecido, no disponible o no es utilizable. El agente de usuario hace que las señales disponibles para el usuario de una manera no visual, por ejemplo, mediante la síntesis de ellos en voz. El atributo src del elemento track es una URL que proporciona los datos de la pista de texto. Descripción de las señales de audio deben encajar en los huecos disponibles en el componente de audio de los recursos de los medios de comunicación . Si no hay tiempo suficiente para sintetizar el texto de descripción en el intervalo de tiempo de la señal de la pista , los agentes de usuario puede truncar el discurso. Esto limita la cantidad de información adicional que se puede añadir. Los agentes de usuario pueden también apoyar las descripciones de audio extendidas al detener el video hasta que la descripción se ha sintetizado por completo , a continuación, reiniciar el video .",
				categoriaTecnica);
	}

	/**
	 * Por cada elemento video que se utiliza para reproducir un video:
	 * 1. Verificar que el video contiene un elemento track con kind="descriptions" en el idioma del video.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionVideoConTrackConKindSinValorDescriptions = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Videos con elemento \"track\" con atributo \"kind\" sin valor \"descriptions\".",
				"Por cada elemento \"video\" que se utiliza para reproducir un video: Verificar que el elemento \"video\" contiene un elemento \"track\" con kind=\"descriptions\" en el idioma del video.",
				"Si el contenido es vídeo solo grabado ofrece un contenido sonoro que describa el contenido más importante del vídeo, utilizando el elemento \"track\" para proporcionar descripciones de audio en el idioma del vídeo.");
		for (Element elementoVIDEO : this.getParseador().getElementos(HTMLElementName.VIDEO))
			for (Element elementoTRACK : elementoVIDEO.getAllElements("track")) {
				String atributoKind = elementoTRACK.getAttributeValue("kind");
				if ((atributoKind != null) && (!atributoKind.equals("descriptions")))
					comprobacionVideoConTrackConKindSinValorDescriptions.procesar(elementoTRACK);
			}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionVideoConTrackConKindSinValorDescriptions);
		return resultadoEvaluacionTecnica;
	}

}