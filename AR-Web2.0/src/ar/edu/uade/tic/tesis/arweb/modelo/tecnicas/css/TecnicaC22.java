package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC22 extends TecnicaCSS {

	public TecnicaC22(CategoriaTecnica categoriaTecnica) {
		super(
				"C22",
				"Usar CSS para controlar la presentación visual del texto.",
				"El propósito de esta técnica es demostrar cómo se pueden utilizar las CSS para controlar la presentación visual del texto. Esto permitirá a los usuarios modificar, a través de la aplicación de usuario, las características visuales del texto para satisfacer sus necesidades. Las CSS benefician la accesibilidad principalmente por la separación de la estructura del documento de su presentación. Las hojas de estilo fueron diseñadas para permitir un control preciso -por fuera del sistema de marcas- del espaciado entre caracteres, alineación del texto, la posición del objeto en la página, las características de la fuente, etc. Al separar el estilo del sistema de marcas, los autores pueden simplificar y limpiar el marcado en su contenido, logrando al mismo tiempo que sea más accesible. Ejemplos: code {font-family:\"Courier New\", Courier, monospace}.right {text-align: right;} strong.largersize {font-size: 1.5em;} .highlight {font-weight:bold; color:#990000;}",
				categoriaTecnica);
	}

	/**
	 * Verifique si las propiedades CSS se utilizan para controlar la presentación visual del texto.
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
						"Validación de las hojas de estilo: " +  atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar si las propiedades CSS se utilizan para controlar la presentación visual del texto.",
						"Controla la presentación visual del texto con CSS. Maqueta la página con CSS, en lugar de hacerlo con tablas.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}		
		return resultadoEvaluacionTecnica;
	}

}