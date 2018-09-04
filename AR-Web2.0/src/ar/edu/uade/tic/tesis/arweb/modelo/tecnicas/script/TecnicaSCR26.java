package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR26 extends TecnicaSCR {

	public TecnicaSCR26(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR26",
				"Insertar contenido din�mico en el modelo de objetos de documento inmediatamente despu�s de su elemento desencadenante.",
				"El objetivo de esta t�cnica es colocar elementos de interfaz de usuario insertados en el Modelo de objetos de documento (DOM) de tal forma que el orden de tabulaci�n y el orden de lectura del lector de pantalla se establezcan correctamente por el comportamiento predeterminado del agente de usuario. Esta t�cnica se puede utilizar para cualquier elemento de interfaz de usuario que est� oculto y se muestre, como men�s y cuadros de di�logo.\r\n" + 
				"\r\n" + 
				"El orden de lectura en un lector de pantalla se basa en el orden de los elementos HTML o XHTML en el Modelo de objetos del documento, al igual que el orden de tabulaci�n predeterminado. Esta t�cnica inserta nuevo contenido en el DOM inmediatamente despu�s del elemento que se activ� para activar el script. El elemento desencadenante debe ser un enlace o un bot�n, y el script debe invocarse desde su evento onclick. Estos elementos son enfocables de forma nativa, y su evento onclick es independiente del dispositivo. El foco permanece en el elemento activado y el contenido nuevo, insertado despu�s, se convierte en lo siguiente tanto en el orden de tabulaci�n como en el orden de lectura del lector de pantalla.", 
				categoriaTecnica);
	}

	/**
	 * 1. Busque todas las �reas de la p�gina que activan di�logos que no son ventanas emergentes.
	 * 2. Compruebe que los cuadros de di�logo se activan desde el clic de un bot�n o un enlace.
	 * 3. Usando una herramienta que le permite inspeccionar el DOM generado por el script, verifique que el cuadro de di�logo sea el siguiente en el DOM.
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
						"Verificar que en todas las �reas de la p�gina en donde se activen do�logos que no son ventanas emergentes, es tos se activen desde el clic del bot�n o un enlace.",
						"Cuando el sitio necesite insertar contenido din�mico en el modelo de objetos de documento (DOM), este debe hacerse inmediatamente despues de su elemento desencadenante de tal forma que el orden de tabulaci�n y el orden de lectura se establezcan correctamente por el comportamiento predeterminado del navegador.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}