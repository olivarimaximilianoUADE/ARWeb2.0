package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH77 extends TecnicaHTML {

	public TecnicaH77(CategoriaTecnica categoriaTecnica) {
		super(
				"H77",
				"Identificar el propósito de un enlace usando su texto combinado con el elemento de lista que lo contiene.", 
				"",
				categoriaTecnica);
	}

	/**
	 * En cada enlace en el contenido que utiliza esta técnica:
	 * 1. Verificar que el enlace es parte de un elemento de lista.
	 * 2. Verificar que el texto del enlace combinado con el texto del elemento de lista que lo contiene describe el propósito del enlace.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoEnlaceYListaDescribenPropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Texto del enlace y del elemento de lista describen el propósito del enlace.", 
				TipoResultadoEvaluacion.MANUAL,
				"En cada enlace en el contenido que utiliza esta técnica: Verificar que el texto del enlace combinado con el texto del elemento de lista que lo contiene describe el propósito del enlace.",
				"Identifica el objetivo de un enlace usando un texto de enlace combinado con su contexto (la lista de elementos que lo engloba) de forma que sea determinable por software.");
		for (Element elementoLI : this.getParseador().getElementos(HTMLElementName.LI)) 
			for (Element elementoA: elementoLI.getAllElements(HTMLElementName.A)) 
				comprobacionTextoEnlaceYListaDescribenPropositoEnlace.procesar(elementoA);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoEnlaceYListaDescribenPropositoEnlace);
		return resultadoEvaluacionTecnica;
	}

}