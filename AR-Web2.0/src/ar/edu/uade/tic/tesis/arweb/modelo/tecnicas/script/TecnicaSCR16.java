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
				"Proporcionar un script que advierta al usuario que un l�mite de tiempo est� a punto de caducar.",
				"El objetivo de esta t�cnica es notificar a los usuarios que est�n casi fuera de tiempo para completar una interacci�n. Cuando las secuencias de comandos proporcionan una funcionalidad que tiene l�mites de tiempo, la secuencia de comandos puede incluir funciones para advertir al usuario de los l�mites de tiempo inminentes y proporcionar un mecanismo para solicitar m�s tiempo. 20 segundos o m�s antes de que se cumpla el l�mite de tiempo, la secuencia de comandos proporciona un di�logo de confirmaci�n que establece que un l�mite de tiempo es inminente y pregunta si el usuario necesita m�s tiempo. Si el usuario responde \"s�\", se restablece el l�mite de tiempo. Si el usuario responde \"no\" o no responde, se permite que expire el l�mite de tiempo.", 
				categoriaTecnica);
	}

	/**
	 * En una p�gina web que tiene un l�mite de tiempo controlado por una secuencia de comandos:
	 *  1. cargue la p�gina e inicie un temporizador que es 20 segundos menos que el l�mite de tiempo.
	 *  2. cuando el temporizador expira, verifique que se muestre un cuadro de di�logo de confirmaci�n que advierta el l�mite de tiempo inminente.
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
						"Verificar que 20 segunos antes de que se llegue al l�mite de tiempo se muestra un cuadro de di�logo avisando y cuando expira completamente el tiempo muestra otro cuadro de di�logo que advierta que se cumplio el tiempo.",
						"Cuando el sitio posea una funcionalidad que tiene l�mites de tiempo, el mismo debe incluir funciones para advertir al usuario de los l�mites de tiempo inminentes y proporcionar un mecanismo para solicitar m�s tiempo.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}
}