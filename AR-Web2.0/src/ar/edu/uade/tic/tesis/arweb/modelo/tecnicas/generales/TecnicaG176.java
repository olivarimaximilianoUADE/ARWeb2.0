package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG176 extends TecnicaGeneral {

	public TecnicaG176(CategoriaTecnica categoriaTecnica) {
		super(
				"G176", 
				"Mantener el área intermitente suficientemente pequeño.", 
				"El propósito de esta técnica es proporcionar una manera fácil de superar el criterio de éxito para las cosas que se encienden pero son pequeñas. Si usted tiene algo que parpadea más de 3 veces en un segundo período de un (por lo tanto G19 no se puede utilizar), pero el área que está parpadeando es inferior al 25% de los 10 grados de campo visual (que representa el área central de la visión en el ojo), entonces pasaría automáticamente. El décimo grado de campo visual representa el área central de la visión en el ojo. Esta zona está muy llena de sensores visuales. El parpadeo en esta área se transmiten a la corteza visual. Para aquellos con fotosensibilidad, la intermitencia de la actividad en la corteza visual puede causar convulsiones. Parpadeando en otras áreas del ojo (que tienen un número mucho menor sensores) tiene un efecto mucho menor en la corteza. Por lo tanto, el foco únicamente en los 10 grados de la visión central.", 
				categoriaTecnica);
	}

	/**
	 * 1.  Verificar que sólo un área de la pantalla parpadea en cualquier momento.
	 * 2.  Verificar que el contenido de parpadear encajaría en un contenedor contiguo cuya área es menor que la pequeña zona segura.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDestellosPorDebajoUmbralLimite = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Destellos por debajo del umbral límite", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que sólo un área de la pantalla parpadea en cualquier momento.",
				"Haz que el contenido destelleante ocupe un espacio pequeño. El mayor tamaño aceptable es de 21 píxeles cuadrados en una pantalla de 1024 por 768.");
		comprobacionDestellosPorDebajoUmbralLimite.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDestellosPorDebajoUmbralLimite);
		return resultadoEvaluacionTecnica;
	}

}