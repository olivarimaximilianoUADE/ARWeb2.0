package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR20 extends TecnicaSCR {

	public TecnicaSCR20(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR20",
				"Usar el teclado y otras funciones específicas del dispositivo.",
				"El objetivo de esta técnica es ilustrar el uso de eventos específicos del teclado y específicos del mouse con un código que tiene una función de scripts asociada a un evento. El uso conjunto de eventos específicos del teclado y específicos del mouse asegura que el contenido pueda ser operado por una amplia gama de dispositivos. Por ejemplo, un script puede realizar la misma acción cuando se detecta una pulsación de tecla que se realiza cuando se hace clic en un botón del mouse. Esta técnica va más allá del requisito del Criterio de Conformidad para el acceso al teclado al incluir no solo acceso al teclado, sino también acceso a otros dispositivos.", 
				categoriaTecnica);
	}

	/**
	 * 1. Encuentra toda la funcionalidad interactiva
	 * 2. Verifique que se pueda acceder a todas las funciones interactivas solo con el teclado
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
						"Verificar que se puede acceder a todas las funciones interactivas del sitio solo con el telado, sin necesidad de usar el mouse.",
						"En el sitio se debe poder acceder a todas las funcionalidades interactivas con el teclado, de esta forma el sitio es accedible desde distintos dispositivos y por todas las personas.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}