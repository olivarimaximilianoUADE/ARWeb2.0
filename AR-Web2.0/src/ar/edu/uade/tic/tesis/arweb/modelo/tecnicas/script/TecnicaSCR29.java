package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR29 extends TecnicaSCR {

	public TecnicaSCR29(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR29",
				"Agregar acciones accesibles por teclado a elementos HTML estáticos.",
				"El objetivo de esta técnica es demostrar cómo proporcionar acceso de teclado a un control de interfaz de usuario que se implementa mediante acciones a elementos HTML estáticos como div o span. Esta técnica garantiza que el elemento se pueda enfocar estableciendo el atributo tabindex y garantiza que la acción se pueda desencadenar desde el teclado proporcionando un controlador onkeyup o onkeypress además de un controlador onclick. Cuando el atributo tabindex tiene el valor 0, el elemento se puede enfocar a través del teclado y se incluye en el orden de tabulación del documento. Cuando el atributo tabindex tiene el valor -1, el elemento no se puede tabular, pero el foco se puede establecer mediante programación, utilizando element.focus ().", 
				categoriaTecnica);
	}

	/**
	 * En un agente de usuario que admite secuencias de comandos:
	 *  1. Haga clic en el control con el mouse
	 *  2. Compruebe que la acción de scripting se ejecuta correctamente
	 *  3. Compruebe que es posible navegar y enfocar el control a través del teclado
	 *  4. Establecer el foco del teclado en el control
	 *  5. Compruebe que presionar ENTER invoca la acción de creación de scripts.
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
						"Verificar que los elementos del sitio que se pueden enfocar con el \"clic\" del mouse y se ejecuta un script también lo haga cuando se lo enfoca con el teclado y se presiona \"enter\".",
						"Cuando en el sitio, para bloques de contenido estáticos como el \"span\" o \"div\", se les da dinamismo con script en el evento clic del mouse, la misma funcionalidad debe mantenerse cuando se lo enfoque con el teclado y se presione \"enter\".");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}