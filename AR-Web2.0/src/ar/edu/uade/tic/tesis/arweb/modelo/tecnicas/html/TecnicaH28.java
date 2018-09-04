package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH28 extends TecnicaHTML {

	public TecnicaH28(CategoriaTecnica categoriaTecnica) {
		super(
				"H28", 
				"Proporcionar definiciones para abreviaturas mediante el uso del elemento abreviado.",
				"El objetivo de esta t�cnica es proporcionar ampliaciones o definiciones de abreviaturas mediante el uso del elemento abreviado.",
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que se proporciona una expansi�n o definici�n para cada abreviatura a trav�s de abbr.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAbbrConTitle = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Los elementos \"abbr\" usados para expandir las abreviaturas deben tener el atributo title explicativo.",
				"Verificar que los elementos \"abbr\" tengan el atributo title.",
				"Siempre es apropiado usar el elemento abreviado para cualquier abreviatura, incluidos los acr�nimos y las iniciales. Al usar HTML 4 y XHTML, los iniciales y acr�nimos pueden marcarse usando el elemento acr�nimo. En HTML5 y las versiones m�s nuevas de HTML, el elemento acr�nimo se marc� como obsoleto a favor del elemento abbr m�s general.");
		for (Element elementoABBR : this.getParseador().getElementos(HTMLElementName.ABBR)) {
			if ((elementoABBR.getAttributeValue("title") == null) || (!elementoABBR.getAttributeValue("title").isEmpty())) { 
				comprobacionAbbrConTitle.procesar(elementoABBR);
			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAbbrConTitle);
		return resultadoEvaluacionTecnica;
	}
}