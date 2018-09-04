package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC12 extends TecnicaCSS {

	public TecnicaC12(CategoriaTecnica categoriaTecnica) {
		super(
				"C12",
				"Usar porcentaje para tamaños de fuente.",
				"El objetivo de esta técnica es especificar el tamaño de fuente del texto proporcionalmente para que los agentes de usuario puedan escalar contenido de manera efectiva. Si se especifica un tamaño de letra para el elemento del cuerpo, todos los demás elementos heredan ese valor, a menos que sea anulado por un selector más específico.", 
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que el valor de la propiedad CSS que define el tamaño de la fuente es un porcentaje.
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
						"Validación de las hojas de estilo: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que el valor de la propiedad CSS que define el tamaño de la fuente sea un porcentaje.",
						"Especificar el tamaño de la fuente del texto en porcentaje permite que el contenido se escale a los navegadores de manera efectiva.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}