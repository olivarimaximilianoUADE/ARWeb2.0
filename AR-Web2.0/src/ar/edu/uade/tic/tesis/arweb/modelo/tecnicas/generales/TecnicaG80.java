package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaG80 extends TecnicaGeneral {

	public TecnicaG80(CategoriaTecnica categoriaTecnica) {
		super(
				"G80", 
				"Proporcionar un botón de envío para iniciar un cambio de contexto.", 
				"El objetivo de esta técnica es proporcionar un mecanismo que permita a los usuarios solicitar explícitamente cambios de contexto. Dado que el uso previsto de un botón de envío es generar una petición HTTP que envía los datos introducidos en un formulario, este es un control apropiado para provocar un cambio de contexto y es una práctica para no dar lugar a confusión a los usuarios.",
				categoriaTecnica);
	}

	/**
	 * 1. Buscar todas los formularios en el contenido.
	 * 2. Para cada formulario, verificar que dispone de un botón de envío.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFormularioSinBotonEnvio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Formulario sin botón de envío.",
				"Para cada formulario, verificar que dispone de un botón de envío.",
				"Para iniciar un cambio de contexto, ofrece un botón que el usuario pueda pulsar.");
		for (Element elementoFORM : this.getParseador().getElementos(HTMLElementName.FORM)) {
			Integer contador = 0;
			for (Element elementoINPUT : elementoFORM.getAllElements(HTMLElementName.INPUT)) {
				String atributoType = elementoINPUT.getAttributeValue("type");
				if ((atributoType != null) && (atributoType.equals("submit")))
					contador++;
			}
			if (contador == 0)
				comprobacionFormularioSinBotonEnvio.procesar(elementoFORM);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFormularioSinBotonEnvio);
		return resultadoEvaluacionTecnica;
	}

}