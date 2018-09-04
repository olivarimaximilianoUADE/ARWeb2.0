package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG75 extends TecnicaGeneral {

	public TecnicaG75(CategoriaTecnica categoriaTecnica) {
		super(
				"G75",
				"Proporcionar un mecanismo para posponer cualquier actualización de contenido.",
				"El objetivo de esta técnica es garantizar que los usuarios puedan posponer las actualizaciones automáticas de contenido u otras interrupciones que no sean de emergencia. Esto puede lograrse a través de una preferencia o alertando a los usuarios de una actualización inminente y permitiéndoles suprimirla. Si se proporciona una preferencia, la actualización automática de contenido puede desactivarse de manera predeterminada y los usuarios pueden especificar la frecuencia de las actualizaciones automáticas de contenido si eligen habilitar la configuración.", 
				categoriaTecnica);
	}

	/**
	 * 1. Busque páginas con contenido que se actualice automáticamente.
	 * 2. Para cada actualización automática, busque un mecanismo para ajustar el tiempo de las actualizaciones.
	 * 3. Verifique que la actualización automática esté deshabilitada de manera predeterminada o que se advierta al usuario antes de que ocurra una actualización automática y se le permita suprimirla.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionActualizacionAutomaticaContenido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Actualización automática de contenido.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el sitio cuenta con un mecanismo para posponer o desactivar las actualizaciones automáticas de contenido.",
				"Asegúrate que si el sitio tiene contenido que se actualiza cada cierto período de tiempo tenga un mecanismo que permita deshabilitar las actualizaciones.");
		comprobacionActualizacionAutomaticaContenido.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionActualizacionAutomaticaContenido);
		return resultadoEvaluacionTecnica;
	}

}