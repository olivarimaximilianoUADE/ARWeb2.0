package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.css;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC27 extends TecnicaCSS {

	public TecnicaC27(CategoriaTecnica categoriaTecnica) {
		super(
				"C27", 
				"Hacer que el orden en el DOM sea igual al orden visual.",
				"El objetivo de esta técnica es para asegurar que el orden del contenido en el código fuente es la misma que la presentación visual del contenido. El orden de los contenidos en el código fuente puede ser cambiado por el autor para cualquier número de presentaciones visuales con CSS. Cada orden puede ser significativo en sí mismo, pero puede causar confusión entre los usuarios de tecnología de asistencia. Esto podría ser debido a que el usuario desconecte la presentación especificados por el autor, mediante el acceso al contenido directamente a partir del código fuente (como con un lector de pantalla), o mediante la interacción con el contenido con un teclado. Si un usuario ciego, que lee la página con un lector de pantalla que sigue el orden de las fuentes, está trabajando con un usuario vidente que lee la página en orden visual, puede confundirse cuando se encuentran con información en diferentes órdenes. Un usuario con baja visión que utiliza un amplificador de pantalla en combinación con un lector de pantalla puede ser confundido cuando el orden de lectura parece saltar de un lado de la pantalla. Un usuario del teclado puede tener problemas para predecir dónde irá enfoque siguiente, cuando la orden de origen no coincide con el orden visual.", 
				categoriaTecnica);
	}

	/**
	 * 1. Inspeccionar visualmente el orden del contenido en la página web tal y como se lo presenta al usuario final. 
	 * 2. Inspeccionar los elementos del DOM utilizando una herramienta que permite visualizar el DOM. 
	 * 3. Asegurar que el orden del contenido en las secciones del código fuente concuerda con la presentacion visual del contenido en la página web (ej., en una página en idioma español el orden es de arriba hacia abajo y de izquierda a derecha). 
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
						"Verificar que el orden del contenido en las secciones del código fuente concuerda con la presentación visual del contenido en la página web (por ejemplo: en una página en idioma español el orden es de arriba hacia abajo y de izquierda a derecha).",
						"Ajusta el orden del DOM al orden visual.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}