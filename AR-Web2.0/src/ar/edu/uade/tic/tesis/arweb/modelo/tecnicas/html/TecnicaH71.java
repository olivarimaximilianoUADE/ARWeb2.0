package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH71 extends TecnicaHTML {

	public TecnicaH71(CategoriaTecnica categoriaTecnica) {
		super(
				"H71",
				"Proporcionar una descripción de los grupos de controles de formulario usando los elementos fieldset y legend.",
				"El propósito de esta técnica es proporcionar una agrupación semántica para los controles de formulario relacionados. Esto permite a los usuarios entender la relación de los controles e interactúar con el formulario más rápida y eficazmente. Los controles de formulario se pueden agrupar encerrándolos en el elemento fieldset. Todos los controles dentro de un fieldset quedan entonces relacionados. El primer elemento dentro de fieldset debe ser un elemento legend, que proporciona una etiqueta o descripción del grupo. La agrupación de los controles es más importante para los botones radio y checkbox cuando los botones representan los valores de un mismo campo de envío. También puede ser útil para agrupar otros conjuntos de controles menos estrechamente relacionados que los botones radio y checkbox. Como regla general, se puede decir que, cuando un grupo de controles dentro de un formulario, requiere un encabezado adicional para proporcionar una descripción específica de ese grupo, el uso de fieldset y legend es apropiado.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que el grupo de elementos input o select relacionados logicamente están contenidos dentro de elementos fieldset.
	 * 2. Verificar que cada fieldset tiene un elemento legend que incluye una descripción de ese grupo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionGrupoElementosInputSelectRelacionadosLogicamente = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Grupo de elementos \"input\" o \"select\" no relacionados logicamente.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el grupo de elementos \"input\" o \"select\" relacionados logicamente están contenidos dentro de elementos \"fieldset\".",
				"Describe los grupos de campos usando los elementos \"fieldset\" y \"legend\".");
		ResultadoEvaluacionTecnicaItem comprobacionFieldsetSinLegend = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Elementos \"fieldset\" sin elementos \"legend\".",
				"Verificar que cada elemento \"fieldset\" tiene un elemento \"legend\" que incluye una descripción de ese grupo.",
				"Describe los grupos de campos usando los elementos \"fieldset\" y \"legend\".");
		for (Element elementoFIELDSET : this.getParseador().getElementos(HTMLElementName.FIELDSET)) { 
			Element elementoLEGEND = Parseador.getElemento(elementoFIELDSET.getChildElements(), HTMLElementName.LEGEND);
			if (elementoLEGEND == null) 
				comprobacionFieldsetSinLegend.procesar(elementoFIELDSET);
			else
				if (elementoLEGEND.getTextExtractor().toString().isEmpty())
					comprobacionFieldsetSinLegend.procesar(elementoFIELDSET);
			comprobacionGrupoElementosInputSelectRelacionadosLogicamente.procesar(elementoFIELDSET);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionGrupoElementosInputSelectRelacionadosLogicamente);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFieldsetSinLegend);
		return resultadoEvaluacionTecnica;
	}

}