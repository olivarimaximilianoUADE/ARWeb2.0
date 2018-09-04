package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC9 extends TecnicaCSS {

	public TecnicaC9(CategoriaTecnica categoriaTecnica) {
		super(
				"C9",
				"Usar CSS para incluir imágenes decorativas.",
				"El propósito de esta técnica es proporcionar un mecanismo que permita agregar imágenes puramente decorativas e imágenes usadas para dar formato visual al contenido sin necesidad de marcas adicionales en el contenido. Esto hace posible que las ayudas técnicas ignoren el contenido no textual. Cuando las imágenes son decorativas es aceptable el uso del atributo alt nulo pero las imágenes que no transmiten información ni proporcionan alguna funcionalidad deberían incluirse mediante CSS. Ejemplos: body {background: #ffe url(\"/images/home-bg.jpg\") repeat;} ul {list-style-image: url(\"bullet.gif\")} p:before {content: url(\"smiley.gif\")}",
				categoriaTecnica);
	}

	/**
	 *  Verificar la presencia de imágenes decorativas.
	 *  Verificar que están incluidos con CSS.
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
						"Verificar la presencia de imágenes decorativas.",
						"Incluye imágenes decorativas con la propiedad \"background\", o los pseudo-elementos \":before\" y \":after\" de CSS.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}