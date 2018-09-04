package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG186 extends TecnicaGeneral {

	public TecnicaG186(CategoriaTecnica categoriaTecnica) {
		super(
				"G186",
				"El uso de un control en la página Web que deje de moverse, parpadeando, o auto-actualización de contenidos.",
				"El objetivo de esta técnica es proporcionar al usuario un control que permite que el contenido deje de moverse o de parpadear. Dado que el control se encuentra en la página web, el propio control cumple con el nivel adecuado de conformidad WCAG por ejemplo, tiene un contraste adecuado, que tiene un nombre que lo identifica, es el teclado accesible. El control es o bien en la parte superior de la página o adyacente al movimiento de los contenidos. Un solo control puede detener todo movimiento de los contenidos o parpadeos en la página, o puede haber controles separados para partes separadas del contenido.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que hay un control de la página web para detener el movimiento.
	 * 2. Activar el control. 
	 * 3. Verificar que el movimiento, parpadeo o la actualización automática se ha detenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionContenidoEnMovimientoOParpadeante = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Contenido en movimiento o parpadeante.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el movimiento, parpadeo o la actualización automática se ha detenido cuando se activa el control de la página web para detener el movimiento.",
				"Ofrece un mecanismo que detenga el movimiento, el parpadeo o el refresco del contenido.");
		comprobacionContenidoEnMovimientoOParpadeante.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContenidoEnMovimientoOParpadeante);
		return resultadoEvaluacionTecnica;
	}

}