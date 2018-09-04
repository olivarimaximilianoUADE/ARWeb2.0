package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG175 extends TecnicaGeneral {

	public TecnicaG175(CategoriaTecnica categoriaTecnica) {
		super(
				"G175", 
				"Proporcionar una herramienta de selección de múltiples colores en la página para colores de primer plano y fondo.", 
				"El objetivo de esta técnica es incluir un control en una página web o un conjunto de páginas web que permita a los usuarios especificar los colores preferidos de primer plano y de fondo para el contenido. Esta técnica puede implementarse utilizando cualquier tecnología que permita a los usuarios almacenar preferencias que puedan usarse en todas las páginas. Usando esta técnica, un autor incluye un control de selección de color en el sitio que permite a los usuarios seleccionar y guardar las preferencias de color de primer plano y de fondo para usar en otras páginas de un sitio. Las páginas están diseñadas para buscar estas preferencias y adaptarse en consecuencia cuando se encuentran las configuraciones guardadas.", 
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que haya un control en la página que se identifica como una herramienta de selección de color.
	 * 2. Compruebe que la herramienta de selección de color ofrece una variedad de opciones de colores para el texto y el fondo.
	 * 3. Seleccione nuevos colores para el texto y el fondo con la herramienta.
	 * 4. Verifique que el contenido esté actualizado para usar las combinaciones de colores seleccionadas.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionControlSeleccionColores = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"La página debe tener una herramienta de selección de múltiples colores de primer plano y fondo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el sitio cuenta con una herramienta de selección de colores de primer plano y fondo.",
				"Debe existir un control que permita a los usuarios seleccionar los colores de primer plano y fondo para el contenido.");
		comprobacionControlSeleccionColores.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionControlSeleccionColores);
		return resultadoEvaluacionTecnica;
	}

}