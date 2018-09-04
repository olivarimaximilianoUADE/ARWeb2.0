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
				"Proporcionar un mecanismo para eliminar la justificaci�n completa del texto.", 
				"El objetivo de esta t�cnica es proporcionar una versi�n de la p�gina que no tenga una justificaci�n completa (justificada tanto a la izquierda como a la derecha). Puede haber circunstancias en las que, con fines de dise�o, un autor desee que el texto est� plenamente justificado. En estos casos, es suficiente proporcionar una caracter�stica que elimine la justificaci�n del texto. El control debe ser f�cil de encontrar y acceder, y cerca del comienzo de la p�gina.", 
				categoriaTecnica);
	}

	/**
	 * 1. Abra una p�gina con una justificaci�n completa.
	 * 2. Verifique que haya una funci�n para eliminar la justificaci�n completa.
	 * 3. Verifique que la funci�n elimine la justificaci�n completa.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoJustificado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"El texto no debe estar justificado o tener un mecanismo para elimiarlo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que haya un forma para que el usuario pueda eliminar la justificaci�n del texto manualmente.",
				"Debe existir el mecanismo para poder eliminar la justificaci�n de los textos cuando estos se presenten as�.");
		comprobacionTextoJustificado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoJustificado);
		return resultadoEvaluacionTecnica;
	}

}