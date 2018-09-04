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
				"Proporcionar un mecanismo que permita a los usuarios mostrar texto en movimiento, desplazamiento o actualización automática en una ventana o área estática.",
				"Algunas páginas web muestran texto desplazable porque hay espacio limitado disponible. El desplazamiento del texto en una pequeña ventana de texto hace que el contenido esté disponible para los usuarios que pueden leer lo suficientemente rápido, pero causa problemas a los usuarios que leen más despacio o usan tecnología de asistencia. Esta técnica proporciona un mecanismo para detener el movimiento y hacer que todo el bloque de texto esté disponible de forma estática. El texto puede estar disponible en una ventana separada o en una sección (más grande) de la página. Los usuarios pueden leer el texto a su propia velocidad.\r\n" + 
				"\r\n" + 
				"Esta técnica no se aplica cuando el texto que se está moviendo no se puede mostrar de una vez en la pantalla (por ejemplo, una larga conversación de chat).", 
				categoriaTecnica);
	}

	/**
	 * No hay pruebas disponibles para esta técnica.
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
						"No hay pruebas disponibles para esta técnica.",
						"No hay pruebas disponibles para esta técnica..");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}