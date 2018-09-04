package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR24 extends TecnicaSCR {

	public TecnicaSCR24(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR24",
				"Usar la mejora progresiva para abrir ventanas nuevas a petición del usuario.",
				"El objetivo de esta técnica es evitar confusiones que pueden ser causadas por la aparición de nuevas ventanas que no fueron solicitadas por el usuario. De repente, la apertura de nuevas ventanas puede desorientar o perderse por completo por algunos usuarios. Si el tipo de documento no permite el atributo de destino (no existe en HTML 4.01 Strict o XHTML 1.0 Strict) o si el desarrollador prefiere no usarlo, se pueden abrir ventanas nuevas con ECMAScript.", 
				categoriaTecnica);
	}

	/**
	 * 1. Active cada enlace en el documento para verificar si abre una nueva ventana.
	 * 2. Para cada enlace que abre una nueva ventana, verifique que utiliza el script para lograr cada uno de los siguientes:
	 * 	a. indica que el enlace se abrirá en una nueva ventana,
	 * 	b. usa manejadores de eventos independientes del dispositivo, y
	 * 	c. permite que el navegador abra el contenido en la misma ventana si no se abrió una nueva ventana.
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
						"Verificar que cada enlace que tenga el sitio que habre el contenido en una nueva ventana indique al usuario de dicha acción.",
						"Cuando el sitio requiera de enlaces que se abran en una nueva ventana, dicha acción debe estar indicada, se deben usar manejadores de eventos independientes del dispositivo y permitir que el navegador abra el contenido en la misma ventana si no se abrio otra.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}