package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH25 extends TecnicaHTML {

	public TecnicaH25(CategoriaTecnica categoriaTecnica) {
		super(
				"H25", 
				"Proporcionar un título usando el elemento title.", 
				"Todos los documentos HTML y XHTML, incluyendo aquellos en los marcos individuales de un frameset, tienen un elemento title en la sección head que define, en una frase simple, el propósito del documento. Esto ayuda a los usuarios a orientarse dentro del sitio de forma rápida y sin tener que buscar información en el cuerpo de la página. Tenga en cuenta que el elemento title (obligatorio), que sólo aparece una vez en un documento, es diferente del atributo title, que se puede aplicar a casi todos los elemento HTML y XHTML.",
				categoriaTecnica);
	}

	/**
	 * 1.Examinar el código fuente del documento HTML o XHTML y verificar que un elemento title no-vacío aparece en la sección head.
	 * 2.Verificar que el elemento title describe el documento.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPaginaSinTitulo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Página sin título.",
				"Examinar el código fuente del documento HTML o XHTML y verificar que un elemento \"title\" no-vacío aparece en la sección head.",
				"Ofrece un título único y descriptivo para cada página web. No identifiques la página o sus contenidos con textos como \"Documento sin título\" o similar. No utilices el mismo título para diferentes páginas.");
		ResultadoEvaluacionTecnicaItem comprobacionTituloConTitleDescribiendoDocumento = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Título describe el documento.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el elemento \"title\" describe el documento.",
				"Ofrece un título único y descriptivo para cada página web. No identifiques la página o sus contenidos con textos como \"Documento sin título\" o similar. No utilices el mismo título para diferentes páginas.");
		String titulo = null;
		Element element = null;
		for (Element elementoHEAD : this.getParseador().getElementos(HTMLElementName.HEAD))
			for (Element elementTitle : elementoHEAD.getAllElements(HTMLElementName.TITLE)) {
				element = elementTitle;
				titulo = elementTitle.getTextExtractor().toString();
			}	
		if (titulo == null) 
			comprobacionPaginaSinTitulo.procesar();
		else
			if (titulo.isEmpty()) 
				comprobacionPaginaSinTitulo.procesar(element);
			else 
				comprobacionTituloConTitleDescribiendoDocumento.procesar(element);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPaginaSinTitulo);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTituloConTitleDescribiendoDocumento);
		return resultadoEvaluacionTecnica;
	}

}