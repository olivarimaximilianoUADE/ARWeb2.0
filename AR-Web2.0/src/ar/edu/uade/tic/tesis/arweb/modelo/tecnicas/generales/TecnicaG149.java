package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG149 extends TecnicaGeneral {

	public TecnicaG149(CategoriaTecnica categoriaTecnica) {
		super(
				"G149",
				"Uso de los componentes de la interfaz de usuario que el agente de usuario resalta cuando reciben el foco.",
				"El objetivo de esta técnica es garantizar que el componente enfocado pueda ser identificado visualmente por el usuario al confiar en el soporte del agente de usuario. Es común que los agentes de usuario resalten los controles estándar de alguna manera cuando reciben el foco. Los agentes de usuario que cumplen con UAAG lo hacen cuando satisfacen el punto de control 10.2 \"Selección de resaltado, enfoque de contenido, elementos habilitados, enlaces visitados\". Cuando los autores utilizan controles estándar para los cuales el agente de usuario proporciona este soporte, los usuarios son informados de la ubicación de enfoque de una manera estándar y predecible.", 
				categoriaTecnica);
	}

	/**
	 * Para cada componente enfocable en la página web:
	 * 1. Establecer el foco para el control.
	 * 2. Compruebe si el agente de usuario ha resaltado el control de alguna manera.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFocoNavegadorDelControl = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Foco sobre control por parte del agente de usuario.", 
				TipoResultadoEvaluacion.MANUAL,
				"Al hacer foco sobre un control del sitio el agente de usuario debe resaltar el control de alguna manera.",
				"Utilice los controles de usuario estándares.");
		comprobacionFocoNavegadorDelControl.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFocoNavegadorDelControl);
		return resultadoEvaluacionTecnica;
	}

}