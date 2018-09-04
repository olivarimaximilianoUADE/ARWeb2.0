package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR34 extends TecnicaSCR {

	public TecnicaSCR34(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR34",
				"Cálcular el tamaño y posición de una manera que se escala con el tamaño del texto.",
				"\r\n" + 
				"El objetivo de esta técnica es calcular el tamaño y la posición de los elementos de una manera que se escalará adecuadamente a medida que se escala el tamaño del texto.\r\n" + 
				"\r\n" + 
				"Hay cuatro propiedades en JavaScript que ayudan a determinar el tamaño y la posición de los elementos:\r\n" + 
				"\r\n" + 
				"offsetHeight (la altura del elemento en píxeles)\r\n" + 
				"\r\n" + 
				"offsetWidth (el ancho del elemento en píxeles)\r\n" + 
				"\r\n" + 
				"offsetLeft (la distancia del elemento desde la izquierda de su elemento principal (offsetParent) en píxeles)\r\n" + 
				"\r\n" + 
				"offsetTop (la distancia del elemento desde la parte superior de su elemento principal (offsetParent) en píxeles)", 
				categoriaTecnica);
	}

	/**
	 * 1. Abra una página que está diseñada para ajustar el tamaño de los contenedores a medida que cambia el tamaño del texto.
	 * 2. Aumente el tamaño del texto hasta 200% utilizando el ajuste de tamaño de texto del navegador (no la función de zoom).
	 * 3. Examine el texto para asegurarse de que el tamaño del contenedor de texto se ajuste para adaptarse al tamaño del texto.
	 * 4. Asegúrese de que ningún texto esté "recortado" o haya desaparecido como resultado del aumento en el tamaño del texto.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		for (Element elementoLINK : this.getParseador().getElementos(HTMLElementName.LINK)) {
			String atributoType = elementoLINK.getAttributeValue("type");
			if ((atributoType != null) && (atributoType.equals("text/javascript"))) {
				String atributoHref = elementoLINK.getAttributeValue("href");
				ResultadoEvaluacionTecnicaItem comprobacion = new ResultadoEvaluacionTecnicaItem(
						Tipologia.PRESENTACION, 
						"Validación de scritps: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que al aumentar el tamaño del texto del navegador, no el zoom, el texto del sitio aumenta también y el contenedor se ajusta para que todo el contenido entre.",
						"Todo el contenido de la página debe ajustarse al aumentar el tamaño del texto desde el navegador de modo tal que todo el texto se muestre sin problemas y sin que haya palabras \"recortadas\"");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}