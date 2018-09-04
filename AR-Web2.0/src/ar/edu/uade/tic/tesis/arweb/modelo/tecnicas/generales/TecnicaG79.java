package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG79 extends TecnicaGeneral {

	public TecnicaG79(CategoriaTecnica categoriaTecnica) {
		super(
				"G79",
				"Proporcionar una versi�n hablada del texto.",
				"El objetivo de esta t�cnica es proporcionar, a los usuarios que tienen dificultad para pronunciar palabras en texto escrito, el audio del texto le�do en voz alta.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique si hay una versi�n hablada del contenido disponible.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionVersionHabladaDelContenido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Presencia de versi�n hablada del texto.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar la presencia de un enlace a un archivo de audio con el texto hablado.",
				"Aseg�rate que el sitio cuente con un enlace a un archivo de audio con el texto hablado.");
		comprobacionVersionHabladaDelContenido.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionVersionHabladaDelContenido);
		return resultadoEvaluacionTecnica;
	}

}