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
				"Proporcionar un mecanismo para posponer cualquier actualizaci�n de contenido.",
				"El objetivo de esta t�cnica es garantizar que los usuarios puedan posponer las actualizaciones autom�ticas de contenido u otras interrupciones que no sean de emergencia. Esto puede lograrse a trav�s de una preferencia o alertando a los usuarios de una actualizaci�n inminente y permiti�ndoles suprimirla. Si se proporciona una preferencia, la actualizaci�n autom�tica de contenido puede desactivarse de manera predeterminada y los usuarios pueden especificar la frecuencia de las actualizaciones autom�ticas de contenido si eligen habilitar la configuraci�n.", 
				categoriaTecnica);
	}

	/**
	 * 1. Busque p�ginas con contenido que se actualice autom�ticamente.
	 * 2. Para cada actualizaci�n autom�tica, busque un mecanismo para ajustar el tiempo de las actualizaciones.
	 * 3. Verifique que la actualizaci�n autom�tica est� deshabilitada de manera predeterminada o que se advierta al usuario antes de que ocurra una actualizaci�n autom�tica y se le permita suprimirla.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionActualizacionAutomaticaContenido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Actualizaci�n autom�tica de contenido.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el sitio cuenta con un mecanismo para posponer o desactivar las actualizaciones autom�ticas de contenido.",
				"Aseg�rate que si el sitio tiene contenido que se actualiza cada cierto per�odo de tiempo tenga un mecanismo que permita deshabilitar las actualizaciones.");
		comprobacionActualizacionAutomaticaContenido.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionActualizacionAutomaticaContenido);
		return resultadoEvaluacionTecnica;
	}

}