package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG5 extends TecnicaGeneral {

	public TecnicaG5(CategoriaTecnica categoriaTecnica) {
		super(
				"G5", 
				"Permitir a los usuarios completar una actividad sin límite de tiempo.", 
				"El objetivo de esta técnica es proporcionar a los usuarios todo el tiempo que necesiten para completar una actividad. Esta técnica implica proporcionar una actividad específica que no requiere interacción temporizada. Los usuarios tienen permitido tanto tiempo como necesiten para interactuar con la actividad.", 
				categoriaTecnica);
	}

	/**
	 * 1. Determine si hay interacciones cronometradas presentes (lado del cliente y / o servidor).
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionActividadSinTiempo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Actividades sin límite de tiempo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que no esten cronometradas las actividades del lado del cliente y/o servidor.",
				"Se deben hacer actividades que no esten cronometradas para evitar que personas con dificultades para hacerla se queden sin tiempo.");
		comprobacionActividadSinTiempo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionActividadSinTiempo);
		return resultadoEvaluacionTecnica;
	}
	
}