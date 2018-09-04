package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG76 extends TecnicaGeneral {

	public TecnicaG76(CategoriaTecnica categoriaTecnica) {
		super(
				"G76",
				"Proporcionar un mecanismo para solicitar una actualización del contenido en lugar de actualizar automáticamente.",
				"El objetivo de esta técnica es permitir que el usuario controle si se actualiza el contenido, para evitar confusión o desorientación causada por actualizaciones automáticas que causan un cambio de contexto. Los usuarios de lectores de pantalla pueden encontrar las actualizaciones automáticas confusas porque no siempre está claro lo que está sucediendo. Cuando se actualiza una página, el \"cursor virtual\" del lector de pantalla, que marca la ubicación actual del usuario en la página, se mueve a la parte superior de la página. Las personas que usan software de aumento de pantalla y las personas con discapacidades de lectura también pueden desorientarse cuando las páginas se actualizan automáticamente.", 
				categoriaTecnica);
	}

	/**
	 * 1. Encuentre mecanismos para actualizar el contenido (si tal mecanismo está presente).
	 * 2. Para cada mecanismo, verifique si le permite al usuario solicitar una actualización.
	 * 3. Para cada mecanismo, verifique si puede causar una actualización automática.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionMecanismoActualizacionContenido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Mecanismo para actualizar el contenido.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el sitio cuanta con un mecanismo que permita actualizar el contenido bajo demanda.",
				"Asegúrate que el sitio tenga algún mecanismo que permita actualizar el contenido del sitio bajo demanda del usuario.");
		comprobacionMecanismoActualizacionContenido.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMecanismoActualizacionContenido);
		return resultadoEvaluacionTecnica;
	}

}