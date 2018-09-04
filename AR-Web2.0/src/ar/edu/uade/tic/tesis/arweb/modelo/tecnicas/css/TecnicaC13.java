package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC13 extends TecnicaCSS {

	public TecnicaC13(CategoriaTecnica categoriaTecnica) {
		super(
				"C13",
				"Usar tama�os de fuente con nombre.",
				"El objetivo de esta t�cnica es especificar un tama�o de letra con nombre que exprese el tama�o de fuente relativo deseado. Estos valores proporcionan sugerencias para que el agente de usuario pueda elegir un tama�o de fuente relativo al tama�o de fuente heredado.", 
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que el valor de la propiedad CSS que define el tama�o de la fuente sea uno de xx-small, xx-small, x-small, small, medium, large, x-large, xx-large, xsmaller o larger.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		for (Element elementoLINK : this.getParseador().getElementos(HTMLElementName.LINK)) {
			String atributoType = elementoLINK.getAttributeValue("type");
			if ((atributoType != null) && (atributoType.equals("text/css"))) {
				String atributoHref = elementoLINK.getAttributeValue("href");
				ResultadoEvaluacionTecnicaItem comprobacion = new ResultadoEvaluacionTecnicaItem(
						Tipologia.PRESENTACION, 
						"Validaci�n de las hojas de estilo: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que el valor de la propiedad CSS que define el tama�o de la fuente se exprese con nombre (ejemplo: large).",
						"Especificar el tama�o de la fuente del texto en nombre. Los valores posibles son: xx-small, xx-small, x-small, small, medium, large, x-large, xx-large, xsmaller o larger.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}