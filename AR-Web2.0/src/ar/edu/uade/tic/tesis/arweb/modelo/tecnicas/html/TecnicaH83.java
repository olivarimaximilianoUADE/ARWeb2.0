package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH83 extends TecnicaHTML {

	public TecnicaH83(CategoriaTecnica categoriaTecnica) {
		super(
				"H83",
				"Usar el atributo de destino para abrir una nueva ventana en la solicitud del usuario e indicar esto en el texto del enlace.",
				"El objetivo de esta t�cnica es evitar confusiones que pueden ser causadas por la aparici�n de nuevas ventanas que no fueron solicitadas por el usuario. De repente, abrir nuevas ventanas puede desorientar a los usuarios o ser extra�ado completamente por algunos. En HTML5, HTML 4.01 Transitional y XHTML 1.0 Transitional, el atributo de destino se puede utilizar para abrir una nueva ventana, en lugar de ventanas emergentes autom�ticas. (El atributo de destino se elimina de HTML 4.01 Strict y XHTML 1.0 Strict.) Tenga en cuenta que no usar el objetivo permite al usuario decidir si se debe abrir o no una nueva ventana. El uso del atributo de destino proporciona una indicaci�n inequ�vocamente legible por m�quina de que se abrir� una nueva ventana. Los agentes de usuario pueden informar al usuario y tambi�n pueden configurarse para que no abran la nueva ventana. Para aquellos que no usan tecnolog�a de asistencia, la indicaci�n tambi�n estar� disponible en el texto del enlace.",
				categoriaTecnica);
	}

	/**
	 * 1. Active cada enlace en el documento para verificar si abre una nueva ventana.
	 * 2. Para cada enlace que abre una nueva ventana, verifique que utiliza el atributo de destino.
	 * 3. Verifique que el texto del enlace contenga informaci�n que indique que el enlace se abrir� en una nueva ventana.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlaceTargetBlankYTextoExplicando = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Elementos \"a\" con atributos \"target\" _blank y texto indicando que se abre en una nueva ventana.",
				TipoResultadoEvaluacion.MANUAL,
				"Para cada elemento \"a\" con el atriburo \"target\" con el valor _blank verificar que tenga informaci�n que indique que el enlace se abrir� en una nueva ventana.",
				"Para evitar confusiones al abrir enlaces en nuevas ventanas se debe indicar en el enlace que se abrir� en una nueva ventana.");
		for (Element elementoA : this.getParseador().getElementos(HTMLElementName.A)) {
			String atributoTarget = elementoA.getAttributeValue("target");
			if (atributoTarget != null && atributoTarget.equals("_blank")) 
				comprobacionEnlaceTargetBlankYTextoExplicando.procesar(elementoA);
		}		
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlaceTargetBlankYTextoExplicando);
		return resultadoEvaluacionTecnica;
	}

}