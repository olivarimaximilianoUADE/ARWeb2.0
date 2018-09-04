package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH89 extends TecnicaHTML {

	public TecnicaH89(CategoriaTecnica categoriaTecnica) {
		super(
				"H89",
				"Usar el atributo de título para proporcionar ayuda contextual.",
				"El objetivo de esta técnica es proporcionar ayuda sensible al contexto para los usuarios a medida que ingresan datos en formularios al proporcionar la información de ayuda en un atributo de título. La ayuda puede incluir información de formato o ejemplos de entrada.",
				categoriaTecnica);
	}

	/**
	 * 1. Identificar controles de formulario que requieren entrada de texto.
	 * 2. Compruebe que cada control de formulario tenga una etiqueta explícitamente asociada
	 * 3. Compruebe que cada control de formulario tenga ayuda contextual proporcionada en el atributo de título.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTituloEnInputsDelForm = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Elementos \"input\" sin atributos \"title\".",
				"Para cada elemento input del formulario, verificar que todos los elementos tengan un atributo \"title\".",
				"Proporcionar ayuda sensible al contexto para los usuarios a medida que ingresan datos en formularios al proporcionar la información de ayuda en un atributo de título.");
		ResultadoEvaluacionTecnicaItem comprobacionLabelParaInputsDelForm = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Elementos \"input\" sin elemento \"label\" asociado.",
				"Para cada elemento input del formulario, verificar que hay un elemento \"label\" asociado.",
				"Proporcionar una etiqueta a cada control de ingreso de información que haya en el formulario del sitio para que el usuario tenga una mejor noción sobre que información ingresar.");
		for (Element elementoFORM : this.getParseador().getElementos(HTMLElementName.FORM)) {
			for (Element elementoINPUT : elementoFORM.getAllElements(HTMLElementName.INPUT)) {
				String atributoTitle = elementoINPUT.getAttributeValue("title");
				if (atributoTitle == null) 
					comprobacionTituloEnInputsDelForm.procesar(elementoINPUT);
				String atributoId = elementoINPUT.getAttributeValue("id	");
				Boolean flagLabel = Boolean.FALSE;
				for (Element elementoLabel : elementoFORM.getAllElements(HTMLElementName.LABEL)) {
					if(elementoLabel.getAttributeValue("for") == atributoId)
						flagLabel = Boolean.TRUE;
				}
				if(!flagLabel)
					comprobacionLabelParaInputsDelForm.procesar(elementoINPUT);
			}
		}		
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTituloEnInputsDelForm);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLabelParaInputsDelForm);
		return resultadoEvaluacionTecnica;
	}

}