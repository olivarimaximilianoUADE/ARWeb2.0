package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH78 extends TecnicaHTML {

	public TecnicaH78(CategoriaTecnica categoriaTecnica) {
		super(
				"H78",
				"Identificar el prop�sito de un enlace usando su texto combinado con el p�rrafo  que lo contiene.", 
				"",
				categoriaTecnica);
	}

	/**
	 * En cada enlace en el contenido que utiliza esta t�cnica:
	 * 1. Verificar que el enlace es parte de un p�rrafo.
	 * 2. Verificar que el texto del enlace combinado con el texto del p�rrafo que lo contiene describe el prop�sito del enlace.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoEnlaceYParrafoDescribenPropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Texto del enlace y del p�rrafo describen el prop�sito del enlace.", 
				TipoResultadoEvaluacion.MANUAL,
				"En cada enlace en el contenido que utiliza esta t�cnica: Verificar que el texto del enlace combinado con el texto del p�rrafo que lo contiene describe el prop�sito del enlace.",
				"Identifica el objetivo de un enlace usando un texto de enlace combinado con su contexto (el p�rrafo que lo engloba) de forma que sea determinable por software.");
		for (Element elementoP : this.getParseador().getElementos(HTMLElementName.P)) 
			for (Element elementoA: elementoP.getAllElements(HTMLElementName.A)) 
				comprobacionTextoEnlaceYParrafoDescribenPropositoEnlace.procesar(elementoA);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoEnlaceYParrafoDescribenPropositoEnlace);
		return resultadoEvaluacionTecnica;
	}

}