package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH79 extends TecnicaHTML {

	public TecnicaH79(CategoriaTecnica categoriaTecnica) {
		super(
				"H79",
				"Identificar el próposito de un enlace usando su texto combinado con la celda que lo contiene y los encabezados de tabla asociados.", 
				"",
				categoriaTecnica);
	}

	/**
	 * En cada enlace en el contenido que utiliza esta técnica:
	 * 1. Verificar que el enlace se encuentra en una celda de la tabla.
	 * 2. Verificar que el texto del enlace combinado con el texto de los encabezados de tabla asociados describe el propósito del enlace.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoEnlaceYEncabezadoTablaDescribenPropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Texto del enlace y del encabezado de tabla describen el propósito del enlace.", 
				TipoResultadoEvaluacion.MANUAL,
				"En cada enlace en el contenido que utiliza esta técnica: Verificar que el texto del enlace combinado con el texto de los encabezados de tabla asociados describe el propósito del enlace.",
				"Identifica el objetivo de un enlace usando un texto de enlace combinado con su contexto (la celda de tabla que lo engloba y su encabezado asociado) de forma que sea determinable por software.");
		for (Element elementoTD : this.getParseador().getElementos(HTMLElementName.TD)) 
			for (Element elementoA: elementoTD.getAllElements(HTMLElementName.A)) 
				comprobacionTextoEnlaceYEncabezadoTablaDescribenPropositoEnlace.procesar(elementoA);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoEnlaceYEncabezadoTablaDescribenPropositoEnlace);
		return resultadoEvaluacionTecnica;
	}

}