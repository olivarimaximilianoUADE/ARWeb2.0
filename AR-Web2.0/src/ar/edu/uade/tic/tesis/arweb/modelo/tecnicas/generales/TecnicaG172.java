package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG172 extends TecnicaGeneral {

	public TecnicaG172(CategoriaTecnica categoriaTecnica) {
		super(
				"G172", 
				"Proporcionar un mecanismo para eliminar la justificación completa del texto.", 
				"El objetivo de esta técnica es proporcionar una versión de la página que no tenga una justificación completa (justificada tanto a la izquierda como a la derecha). Puede haber circunstancias en las que, con fines de diseño, un autor desee que el texto esté plenamente justificado. En estos casos, es suficiente proporcionar una característica que elimine la justificación del texto. El control debe ser fácil de encontrar y acceder, y cerca del comienzo de la página.", 
				categoriaTecnica);
	}

	/**
	 * 1. Abra una página con una justificación completa.
	 * 2. Verifique que haya una función para eliminar la justificación completa.
	 * 3. Verifique que la función elimine la justificación completa.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoJustificado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"El texto no debe estar justificado o tener un mecanismo para elimiarlo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que haya un forma para que el usuario pueda eliminar la justificación del texto manualmente.",
				"Debe existir el mecanismo para poder eliminar la justificación de los textos cuando estos se presenten así.");
		comprobacionTextoJustificado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoJustificado);
		return resultadoEvaluacionTecnica;
	}

}