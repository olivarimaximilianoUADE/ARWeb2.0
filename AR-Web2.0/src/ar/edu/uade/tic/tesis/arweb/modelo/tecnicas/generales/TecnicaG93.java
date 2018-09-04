package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG93 extends TecnicaGeneral {

	public TecnicaG93(CategoriaTecnica categoriaTecnica) {
		super(
				"G93", 
				"Proporcionar los subtítulos abiertos (siempre visible).", 
				"El objetivo de esta técnica es proporcionar una manera para que las personas sordas o que de otra manera tendrían problemas para escuchar el diálogo en el material audiovisual para poder ver el material. Con esta técnica, todos los diálogos y sonidos importantes están incrustadas como texto en la pista de vídeo. Como el resultado siempre es visible y no hay soporte especial para la capturacion, es requerido por el agente de usuario.", 
				categoriaTecnica);
	}

	/**
	 * 1. Ver la sincronización multimedia cuando los subtítulos se apagan.
	 * 2. Verificar que los subtítulos (de todos los diálogos y sonidos importantes) son visibles.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSubtitulos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Subtítulos visibles.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que los subtítulos (de todos los diálogos y sonidos importantes) son visibles.",
				"Ofrece subítulos para sordos de forma abierta (están incrustados en la propia imagen del vídeo, por lo que no se pueden alterar ni ocultar, salvo ubicando encima otros subtítulos).");
		comprobacionSubtitulos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSubtitulos);
		return resultadoEvaluacionTecnica;
	}

}