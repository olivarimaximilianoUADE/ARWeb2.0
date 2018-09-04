package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH95 extends TecnicaHTML {

	public TecnicaH95(CategoriaTecnica categoriaTecnica) {
		super(
				"H95", 
				"Usar el elemento track para proporcionar subtítulos.", 
				"El objetivo de esta técnica es utilizar el elemento track para especificar una pista de texto de subtítulos temporizados para un elemento video. Las pistas de texto de subtítulo temporizado contienen transcripciones o traducciones del diálogo, efectos de sonido, música relevante y otro información de audio importante adecuada para cuando el sonido no está disponible o no claramente audible. El atributo src del elemento track es una URL que es la dirección de los datos de la pista de texto. El atributo kind del elemento track indica el tipo de información en el texto temporizado. Las pistas de texto de subutítulo proveen una versión de texto del diálogo y otros sonidos importantes para entender el video. Los subtítulos contienen solamente el diálogo. Si otra información de audio es importante para entender el video, una pista de subtítulo no será suficiente para cumplir con los criterios de éxito.", 
				categoriaTecnica);
	}

	/**
	 *  Por cada elemento video que se utiliza para reproducir un video:
	 *  1. Verificar que el video contiene un elemento track con kind="captions" en el idioma del video.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionVideoConTrackConKindSinValorCaptions = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Videos con elemento \"track\" con atributo \"kind\" sin valor \"captions\".",
				"Por cada elemento \"video\" que se utiliza para reproducir un video: Verificar que el elemento \"video\" contiene un elemento \"track\" con atributo kind=\"captions\" en el idioma del video.",
				"No omitas los subtítulos para sordos (subtítulos generales  que incluyen información sobre los sonidos que suceden) en diálogos o efectos de sonido importantes, utilizando el elemento \"track\", para proporcionar subtítulos en el idioma del vídeo.");
		for (Element elementoVIDEO : this.getParseador().getElementos(HTMLElementName.VIDEO))
			for (Element elementoTRACK : elementoVIDEO.getAllElements("track")) {
				String atributoKind = elementoTRACK.getAttributeValue("kind");
				if ((atributoKind != null) && (!atributoKind.equals("captions")))
					comprobacionVideoConTrackConKindSinValorCaptions.procesar(elementoTRACK);
			}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionVideoConTrackConKindSinValorCaptions);
		return resultadoEvaluacionTecnica;
	}

}