package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR2 extends TecnicaSCR {

	public TecnicaSCR2(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR2",
				"Uso de controladores de eventos de teclado y mouse redundantes.",
				"El objetivo de esta técnica es demostrar el uso de eventos independientes del dispositivo para cambiar una imagen decorativa en respuesta a un evento de mouse o foco. Use los eventos onmouseover y onmouseout para cambiar una imagen decorativa cuando el mouse se mueve encima o lejos de un elemento en la página. Además, use los eventos onfocus y onblur para cambiar la imagen cuando el elemento recibe y pierde el foco.", 
				categoriaTecnica);
	}

	/**
	 * Cargue la página web y pruebe los eventos con un mouse y mediante el teclado.
	 * 	1. Compruebe que la imagen "estándar" se muestra como se esperaba cuando se carga la página web.
	 * 	2. Usando el mouse
	 * 		a. Mueva el mouse sobre el elemento que contiene los manejadores de eventos (en este ejemplo, es un elemento de anclaje). Verifique que la imagen cambie a la imagen esperada.
	 * 		b. Mueve el mouse fuera del elemento. Verifique que la imagen cambie a la imagen "estándar".
	 * 	3. Usando el teclado
	 * 		a. Use el teclado para establecer el foco en el elemento que contiene los manejadores de eventos. Verifique que la imagen cambie a la imagen esperada.
	 * 		b. Use el teclado para quitar el foco del elemento (generalmente moviendo el foco a otro elemento). Verifique que la imagen cambie a la imagen "estándar".
	 * 	4. Verifique que el diseño de otros elementos en la página no se vea afectado cuando se cambie la imagen.
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
						"Verificar cambio de imagenes mediante los eventos del teclado y mouse sobre el elemento.",
						"Cuando se tenga un elemento en el sitio que mediante los eventos del teclado y el mouse cambian la imagen que este muestra, esta función debe mantenerse en cualquier dispositivo mediante el cual se navege el sitio");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}