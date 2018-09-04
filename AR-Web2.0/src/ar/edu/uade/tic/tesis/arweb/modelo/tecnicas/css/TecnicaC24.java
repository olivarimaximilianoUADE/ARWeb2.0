package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC24 extends TecnicaCSS {

	public TecnicaC24(CategoriaTecnica categoriaTecnica) {
		super(
				"C24",
				"Usar valores porcentuales en CSS para tama�os de contenedores.",
				"El objetivo de esta t�cnica es permitir a los usuarios aumentar el tama�o del texto sin tener que desplazarse horizontalmente para leer ese texto. Para utilizar esta t�cnica, un autor especifica el ancho de los contenedores de texto utilizando valores porcentuales.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que todos los anchos de los contenedores est�n especificados como valores porcentuales.
	 * 2. Aumente el tama�o del texto al 200%.
	 * 3. Compruebe para asegurarse de que no se requiera el desplazamiento horizontal para leer cualquier l�nea de texto.
	 * 4. Verifique que todo el texto a�n est� visible en la p�gina.
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
						"Verificar que el ancho de todos los contenedores se especificaron con valores porcentuales y que al aumentar el zoom del navegador no se requiere desplazamiento horizontal.",
						"Especificar el ancho de los contenedores con valores porcentuales permitiendo a los usuarios aumentar el tama�o del texto sin tener que desplazarse horizontalmente para leer ese texto.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}