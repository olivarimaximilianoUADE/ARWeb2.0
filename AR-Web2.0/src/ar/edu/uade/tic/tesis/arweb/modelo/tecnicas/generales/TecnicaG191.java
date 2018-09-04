package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG191 extends TecnicaGeneral {

	public TecnicaG191(CategoriaTecnica categoriaTecnica) {
		super(
				"G191",
				"Proporcionar un enlace, botón u otro mecanismo que vuelve a cargar la página sin ningún contenido parpadeante.",
				"Esta es una técnica general para permitir que las personas que no pueden utilizar una página con contenido parpadeante puedan apagar el parpadeo. Conformidad Requisito 1 permite páginas alternativas para ser utilizadas para satisfacer conformidad. Esta técnica es un ejemplo de este enfoque se aplica a los criterios de éxito 2.2.2. Es importante que la página sin contenido parpadeante contenga toda la información que apareció en la página con contenido parpadeante.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que existe un mecanismo para recargar la página para desactivar el parpadeo.
	 * 2. Verificar que la página a cargar no tiene parpadeo.
	 * 3. Verificar que la página a cargar tiene toda la información y funcionalidad de la página original.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionContenidoEnMovimientoOParpadeante = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Contenido en movimiento o parpadeante.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la página a cargar no tiene parpadeo.",
				"Ofrece un mecanismo para recargar la página sin contenidos parpadeantes.");
		comprobacionContenidoEnMovimientoOParpadeante.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContenidoEnMovimientoOParpadeante);
		return resultadoEvaluacionTecnica;
	}

}