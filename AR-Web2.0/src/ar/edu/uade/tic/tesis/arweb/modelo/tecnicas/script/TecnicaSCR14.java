package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR14 extends TecnicaSCR {

	public TecnicaSCR14(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR14",
				"Usar scripts para hacer que las alertas no esenciales sean opcionales.",
				"El objetivo de esta t�cnica es mostrar un di�logo que contenga un mensaje (alerta) para el usuario. Cuando se muestra la alerta, recibe el foco y el usuario debe activar el bot�n Aceptar en el cuadro de di�logo para descartarlo. Dado que estas alertas causan que el enfoque cambie, pueden distraer al usuario, especialmente cuando se utiliza para informaci�n que no es de emergencia. Las alertas para fines que no son de emergencia, como mostrar una cotizaci�n del d�a, un consejo de uso �til o realizar una cuenta atr�s para un evento en particular, no se presentan a menos que el usuario las habilite a trav�s de una opci�n provista en la p�gina web..", 
				categoriaTecnica);
	}

	/**
	 * Para una p�gina web que admite interrupciones que no son de emergencia mediante una alerta de JavaScript:
	 * 	1. Cargue la p�gina web y verifique que no se muestren alertas que no sean de emergencia.
	 *  2. Verifique que haya un mecanismo para activar las alertas que no son de emergencia.
	 *  3. Active las alertas que no son de emergencia y verifique que se muestren las alertas.
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
						"Verificar que el haya un control que permita activar las alertas que no son emergencia.",
						"Dado que estas alertas causan que el enfoque cambie, pueden distraer al usuario, especialmente cuando se utiliza para informaci�n que no es de emergencia.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}