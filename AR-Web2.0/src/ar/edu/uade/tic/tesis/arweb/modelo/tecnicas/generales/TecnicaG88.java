package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaG88 extends TecnicaGeneral {

	public TecnicaG88(CategoriaTecnica categoriaTecnica) {
		super(
				"G88", 
				"Proporcionar títulos descriptivos para las página web.", 
				"El objetivo de esta técnica es dar a cada página web un título descriptivo. Los títulos descriptivos ayudan a los usuarios a encontrar contenidos,  orientarse dentro de los mismos, y navegar a través de ellos. Un título descriptivo permite a un usuario identificar fácilmente qué página web que están utilizando y que contar cuando la página Web ha cambiado. El título se puede utilizar para identificar la página Web sin que los usuarios deban leer o interpretar el contenido de la página. Los usuarios pueden identificar más rápidamente el contenido que necesitan cuando los títulos precisos y descriptivos aparecen en los mapas de sitios o listas de resultados de búsqueda. Cuando se utilizan títulos descriptivos dentro del texto de enlace, que ayudan a los usuarios a navegar con mayor precisión al contenido que les interesa.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que la página web tiene un título.
	 * 2. Verificar que el título es relevante para el contenido de la página Web.
	 * 3. Verificar que la página web se puede identificar con el título.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPaginaConTituloDescriptivo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Página con título descriptivo.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el título es relevante para el contenido de la página Web.",
				"Ofrece un título único y descriptivo para cada página web. No identifiques la página o sus contenidos con textos como \"Documento sin título\" o similar. No utilices el mismo título para diferentes páginas.");
		for (Element elementoTITLE : this.getParseador().getElementos(HTMLElementName.TITLE))
			comprobacionPaginaConTituloDescriptivo.procesar(elementoTITLE);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPaginaConTituloDescriptivo);
		return resultadoEvaluacionTecnica;
	}

}