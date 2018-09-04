package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR35 extends TecnicaSCR {

	public TecnicaSCR35(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR35",
				"Haciendo que las acciones del teclado sean accesibles mediante el uso del evento onclick de links y botones.",
				"El objetivo de esta técnica es demostrar cómo invocar una función de scripting de una manera accesible mediante el teclado adjuntándola a un control accesible por teclado. Para garantizar que las acciones con guiones puedan invocarse desde el teclado, se asocian con elementos HTML \"nativamente accionables\" (enlaces y botones). El evento onclick de estos elementos es independiente del dispositivo. Si bien \"onclick\" parece estar vinculado al mouse, el evento onclick se correlaciona con la acción predeterminada de un enlace o botón. La acción predeterminada se produce cuando el usuario hace clic en el elemento con un mouse, pero también se produce cuando el usuario enfoca el elemento e ingresa enter o espacio, y cuando el elemento se activa mediante la API de accesibilidad.", 
				categoriaTecnica);
	}

	/**
	 * Para todas las acciones de script asociadas con un botón o elementos de entrada:
	 * 	1. En un agente de usuario que admite secuencias de comandos
	 * 		a. Haga clic en el control con el mouse.
	 * 		b. Compruebe que la acción de scripting se ejecuta correctamente.
	 * 		c. Si el control es un elemento link, compruebe que no se invoque el URI en el atributo href del elemento de anclaje.
	 * 		d. Compruebe que es posible navegar y enfocar el control a través del teclado.
	 * 		e. Establezca el foco del teclado en el control.
	 * 		f. Compruebe que presionar ENTER invoca la acción de creación de scripts.
	 * 		g. Si el control es un elemento de anclaje, compruebe que no se invoque el URI en el atributo href del elemento de anclaje.
	 * 	2. En un agente de usuario que no admite secuencias de comandos
	 * 		a. Haga clic en el control con el mouse.
	 * 		b. Si el control es un elemento link, verifique que se invoque el URI en el atributo href del elemento de anclaje.
	 * 		c. Compruebe que es posible navegar y enfocar el control a través del teclado.
	 * 		d. Establezca el foco del teclado en el control.
	 * 		e. Si el control es un elemento de anclaje, compruebe que presionando ENTER invoca el URI del atributo href del elemento de anclaje.
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
						"Verificar que los botones y links pueden ser invocados usando el teclado.",
						"Los elemento links y botones que tienen el evento \"onclick\" deben poder ser invocados desde el teclado a demas que con el mouse, de esta forma es mas accesible el sitio para personas con discapacidades.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}