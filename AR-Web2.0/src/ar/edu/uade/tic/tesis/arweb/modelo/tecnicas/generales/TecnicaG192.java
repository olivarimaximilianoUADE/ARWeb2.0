package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG192 extends TecnicaGeneral {

	public TecnicaG192(CategoriaTecnica categoriaTecnica) {
		super(
				"G192", 
				"Totalmente conforme a las especificaciones.", 
				"Cuando se utilizan lenguajes de marcado de una manera que se ajuste plenamente a sus especificaciones, todos los requisitos en 4.1.1 se cumplen. Por lo tanto, mientras plenamente conforme a las especificaciones no está obligado a cumplir con las WCAG 2.0, es una buena práctica y es suficiente para cumplir con los Criterios 4.1.1.", 
				categoriaTecnica);
	}

	/**
	 * 1 . Verificar que todas las tecnologías se utilizan de acuerdo con las especificaciones.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionUsoTecnologiasDeAcuerdoConEspecificaciones = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Todas las tecnologías se utilizan de acuerdo con las especificaciones.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que todas las tecnologías se utilizan de acuerdo con las especificaciones.",
				"Valida la página web y asegúrate que cumplen completamente las especificaciones.");
		comprobacionUsoTecnologiasDeAcuerdoConEspecificaciones.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionUsoTecnologiasDeAcuerdoConEspecificaciones);
		return resultadoEvaluacionTecnica;
	}

}