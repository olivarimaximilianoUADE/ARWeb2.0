package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR36 extends TecnicaSCR {

	public TecnicaSCR36(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR36", 
				"Proporcionar un mecanismo que permita a los usuarios mostrar texto en movimiento, desplazamiento o actualizaci�n autom�tica en una ventana o �rea est�tica.",
				"Algunas p�ginas web muestran texto desplazable porque hay espacio limitado disponible. El desplazamiento del texto en una peque�a ventana de texto hace que el contenido est� disponible para los usuarios que pueden leer lo suficientemente r�pido, pero causa problemas a los usuarios que leen m�s despacio o usan tecnolog�a de asistencia. Esta t�cnica proporciona un mecanismo para detener el movimiento y hacer que todo el bloque de texto est� disponible de forma est�tica. El texto puede estar disponible en una ventana separada o en una secci�n (m�s grande) de la p�gina. Los usuarios pueden leer el texto a su propia velocidad.\r\n" + 
				"\r\n" + 
				"Esta t�cnica no se aplica cuando el texto que se est� moviendo no se puede mostrar de una vez en la pantalla (por ejemplo, una larga conversaci�n de chat).", 
				categoriaTecnica);
	}

	/**
	 * No hay pruebas disponibles para esta t�cnica.
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
						"No hay pruebas disponibles para esta t�cnica.",
						"No hay pruebas disponibles para esta t�cnica..");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}