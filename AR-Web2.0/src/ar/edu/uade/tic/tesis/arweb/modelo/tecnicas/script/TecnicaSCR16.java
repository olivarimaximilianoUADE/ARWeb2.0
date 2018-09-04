package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.script;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaSCR16 extends TecnicaSCR {

	public TecnicaSCR16(CategoriaTecnica categoriaTecnica) {
		super(
				"SCR16",
				"Proporcionar un script que advierta al usuario que un límite de tiempo está a punto de caducar.",
				"El objetivo de esta técnica es notificar a los usuarios que están casi fuera de tiempo para completar una interacción. Cuando las secuencias de comandos proporcionan una funcionalidad que tiene límites de tiempo, la secuencia de comandos puede incluir funciones para advertir al usuario de los límites de tiempo inminentes y proporcionar un mecanismo para solicitar más tiempo. 20 segundos o más antes de que se cumpla el límite de tiempo, la secuencia de comandos proporciona un diálogo de confirmación que establece que un límite de tiempo es inminente y pregunta si el usuario necesita más tiempo. Si el usuario responde \"sí\", se restablece el límite de tiempo. Si el usuario responde \"no\" o no responde, se permite que expire el límite de tiempo.", 
				categoriaTecnica);
	}

	/**
	 * En una página web que tiene un límite de tiempo controlado por una secuencia de comandos:
	 *  1. cargue la página e inicie un temporizador que es 20 segundos menos que el límite de tiempo.
	 *  2. cuando el temporizador expira, verifique que se muestre un cuadro de diálogo de confirmación que advierta el límite de tiempo inminente.
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
						"Verificar que 20 segunos antes de que se llegue al límite de tiempo se muestra un cuadro de diálogo avisando y cuando expira completamente el tiempo muestra otro cuadro de diálogo que advierta que se cumplio el tiempo.",
						"Cuando el sitio posea una funcionalidad que tiene límites de tiempo, el mismo debe incluir funciones para advertir al usuario de los límites de tiempo inminentes y proporcionar un mecanismo para solicitar más tiempo.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}