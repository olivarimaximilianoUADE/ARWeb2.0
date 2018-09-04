package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH32 extends TecnicaHTML {

	public TecnicaH32(CategoriaTecnica categoriaTecnica) {
		super(
				"H32",
				"Proporcionar botones de envío",
				"El propósito de esta técnica es proporcionar un mecanismo que permita a los usuarios solicitar explícitamente cambios de contexto. El uso previsto de un botón de envío (input type=\"submit\", input type=\"image\" o button type=\"submit\") es generar una petición HTTP que envía los datos introducidos en un formulario, por lo que es un control apropiado para provocar un cambio de contexto y es una práctica que no crea confusión entre los usuarios.",
				categoriaTecnica);
	}

	/**
	 * 1. Buscar todos los formularios en el contenido.
	 * 2. Por cada formulario verificar que tiene un botón submit (input type="submit", input type="image", or button type="submit") 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFormularioSinBotonesEnvio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Formularios sin botón de envío.",
				"Por cada formulario verificar que tiene un botón submit (input type=\"submit\", input type=\"image\", or button type=\"submit\")",
				"Para iniciar un cambio de contexto, ofrece un botón que el usuario pueda pulsar. No envíes un formulario automáticamente.");
		for (Element elementoFORM : this.getParseador().getElementos(HTMLElementName.FORM)) {
			Integer contador = 0;
			for (Element elemento : elementoFORM.getAllElements()) {
				String atributoType = elemento.getAttributeValue("type");
				if (elemento.getName().equalsIgnoreCase(HTMLElementName.INPUT))
					if ((atributoType != null) && (atributoType.matches("(submit|image)")))
						contador++;
				if (elemento.getName().equalsIgnoreCase(HTMLElementName.BUTTON))
					if ((atributoType != null) && (atributoType.matches("submit")))
						contador++;
			}
			if (contador == 0) 
				comprobacionFormularioSinBotonesEnvio.procesar(elementoFORM);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFormularioSinBotonesEnvio);
		return resultadoEvaluacionTecnica;
	}

}