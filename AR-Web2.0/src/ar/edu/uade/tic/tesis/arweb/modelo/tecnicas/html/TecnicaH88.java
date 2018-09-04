package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.StartTagType;

public class TecnicaH88 extends TecnicaHTML {

	public TecnicaH88(CategoriaTecnica categoriaTecnica) {
		super(
				"H88",
				"Usar HTML de acuerdo con la especificación.", 
				"Existe distintos tipos de documentos HTML y todos ellos se encuentran definidos en sus respectivas especificaciones, pero también están definidos en un lenguaje comprensible por las máquinas que especifica la estructura correcta, elementos y atributos de un tipo de HTML. Tal definición se denomina \"Document Type Definition\" (Definición del Tipo de Documento) que se suele llamar, para abreviar, \"Doctype\" o \"DTD\". Las herramientas que procesan los documentos HTML como, por ejemplo, los navegadores web, necesitan conocer la DTD que utilizan los documentos. Por este motivo es que cada documento (X)HTML necesita, al principio, una declaración DTD con la cual la interpretación (y, como resultado, la representación) del documento será no sólo más rápida sino también consistente y libre de cualquier error que causaría un documento sin doctype.",
				categoriaTecnica);
	}

	/**
	 *
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPaginaSinDefinicionTipoDocumento = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Página sin definición del tipo de documento.",
				"Verificar que la página define el tipo de documento HTML.",
				"Elige el estándar que desees (HTML, XHTML, XML, ...), pero sigue su especificación.");
		if (this.getParseador().getEtiquetasInicio(StartTagType.DOCTYPE_DECLARATION).isEmpty()) 
			comprobacionPaginaSinDefinicionTipoDocumento.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPaginaSinDefinicionTipoDocumento);
		return resultadoEvaluacionTecnica;
	}

}