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
				"C�lcular el tama�o y posici�n de una manera que se escala con el tama�o del texto.",
				"\r\n" + 
				"El objetivo de esta t�cnica es calcular el tama�o y la posici�n de los elementos de una manera que se escalar� adecuadamente a medida que se escala el tama�o del texto.\r\n" + 
				"\r\n" + 
				"Hay cuatro propiedades en JavaScript que ayudan a determinar el tama�o y la posici�n de los elementos:\r\n" + 
				"\r\n" + 
				"offsetHeight (la altura del elemento en p�xeles)\r\n" + 
				"\r\n" + 
				"offsetWidth (el ancho del elemento en p�xeles)\r\n" + 
				"\r\n" + 
				"offsetLeft (la distancia del elemento desde la izquierda de su elemento principal (offsetParent) en p�xeles)\r\n" + 
				"\r\n" + 
				"offsetTop (la distancia del elemento desde la parte superior de su elemento principal (offsetParent) en p�xeles)", 
				categoriaTecnica);
	}

	/**
	 * 1. Abra una p�gina que est� dise�ada para ajustar el tama�o de los contenedores a medida que cambia el tama�o del texto.
	 * 2. Aumente el tama�o del texto hasta 200% utilizando el ajuste de tama�o de texto del navegador (no la funci�n de zoom).
	 * 3. Examine el texto para asegurarse de que el tama�o del contenedor de texto se ajuste para adaptarse al tama�o del texto.
	 * 4. Aseg�rese de que ning�n texto est� "recortado" o haya desaparecido como resultado del aumento en el tama�o del texto.
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
						"Validaci�n de scritps: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que al aumentar el tama�o del texto del navegador, no el zoom, el texto del sitio aumenta tambi�n y el contenedor se ajusta para que todo el contenido entre.",
						"Todo el contenido de la p�gina debe ajustarse al aumentar el tama�o del texto desde el navegador de modo tal que todo el texto se muestre sin problemas y sin que haya palabras \"recortadas\"");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}