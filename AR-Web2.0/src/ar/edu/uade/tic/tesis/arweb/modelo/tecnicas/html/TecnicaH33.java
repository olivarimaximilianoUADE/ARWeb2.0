package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH33 extends TecnicaHTML {

	public TecnicaH33(CategoriaTecnica categoriaTecnica) {
		super(
				"H33",
				"Complementar el texto de un enlace con el tributo title.",
				"El propósito de esta técnica es mostrar cómo usar un atributo title en un enlace para proporcionar texto adicional que describa el enlace. El atributo title se usa para proporcionar información adicional para aclarar o describir con más detalle el propósito de un enlace. Si la información complementaria proporcionada por el atributo title es algo que el usuario debe saber antes de seguir el enlace, como una advertencia, entonces debe ser proporcionada en el texto del enlace y no en el atributo title.",
				categoriaTecnica);
	}

	/**
	 * 1. Por cada elemento a que tiene un atributo title, verificar que el atributo title junto con el texto del enlace describen el propósito del enlace.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAtributoTitleRepiteTextoDelEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Enlaces con igual texto en el contenido y atributo \"title\".",
				"Por cada elemento \"a\" que tiene un atributo \"title\", verificar que el atributo \"title\" sea distinto del texto del enlace.",
				"Identifica el objetivo del un enlace usando un texto clarificador en el enlace combinado con el atributo \"title\".");
		ResultadoEvaluacionTecnicaItem comprobacionAtributoTitleJuntoConTextoEnlaceDescribenPropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Enlaces con atributo \"title\" junto con el texto del enlace describen su propósito.", 
				TipoResultadoEvaluacion.MANUAL,
				"Por cada elemento \"a\" que tiene un atributo \"title\", verificar que el atributo \"title\" junto con el texto del enlace describen el propósito del enlace.",
				"Identifica el objetivo del un enlace usando un texto clarificador en el enlace combinado con el atributo \"title\".");
		for (Element elementoA : this.getParseador().getElementos(HTMLElementName.A)) {
			String atributoTitle = elementoA.getAttributeValue("title");
			if ((atributoTitle != null) && (!atributoTitle.isEmpty())) {
				if (elementoA.getTextExtractor().toString().trim().equalsIgnoreCase(atributoTitle))
					comprobacionAtributoTitleRepiteTextoDelEnlace.procesar(elementoA);
				comprobacionAtributoTitleJuntoConTextoEnlaceDescribenPropositoEnlace.procesar(elementoA);			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAtributoTitleRepiteTextoDelEnlace);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAtributoTitleJuntoConTextoEnlaceDescribenPropositoEnlace);
		return resultadoEvaluacionTecnica;
	}

}