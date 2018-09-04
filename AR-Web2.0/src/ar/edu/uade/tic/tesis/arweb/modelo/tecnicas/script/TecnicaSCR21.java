package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR21 extends TecnicaSCR {

	public TecnicaSCR21(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR21",
				"Usar funciones del Modelo de objetos de documento (DOM) para agregar contenido a una página.",
				"El objetivo de esta técnica es demostrar cómo usar las funciones del Modelo de Objetos de Documento (DOM) para agregar contenido a una página en lugar de usar document.write u object.innerHTML. El método document.write () no funciona con XHTML cuando se sirve con el tipo MIME correcto (application / xhtml + xml), y la propiedad innerHTML no es parte de la especificación DOM, por lo que debe evitarse. Si las funciones DOM se utilizan para agregar el contenido, los agentes de usuario pueden acceder al DOM para recuperar el contenido. La función createElement () se puede usar para crear elementos dentro del DOM. El createTextNode () se usa para crear texto asociado a elementos. Las funciones appendChild (), removeChild (), insertBefore () y replaceChild () se utilizan para agregar y eliminar elementos y nodos. Otras funciones DOM se utilizan para asignar atributos a los elementos creados.", 
				categoriaTecnica);
	}

	/**
	 * Para páginas que crean dinámicamente contenido nuevo:
	 *  1. Examine el código fuente y verifique que el nuevo contenido no se haya creado utilizando document.write (), innerHTML, outerHTML, innerText o outerText.
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
						"Verificar que si el sitio genera nuevo contenido dinamicamente, el nuevo contenido no se haya creado utilizando \"document.write ()\", \"innerHTML\", \"outerHTML\", \"innerText\" o \"outerText\".",
						"Cuando el sitio posea la funcionalidad de generar contenido dinamicamente, este contenido no puede ser creado utilizando las funciones del Modelo de Objetos de Documento (DOM) \"document.write ()\", \"innerHTML\", \"outerHTML\", \"innerText\" o \"outerText\", se deben utilizar las funciones \"appendChild()\", \"removeChild()\", \"insertBefore()\" y \"replaceChild()\".");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}