package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG60 extends TecnicaGeneral {

	public TecnicaG60(CategoriaTecnica categoriaTecnica) {
		super(
				"G60", 
				"Reproducción de un sonido que se apague automáticamente dentro de tres segundos.", 
				"El propósito de esta técnica es permitir a los autores a reproducir sonido en su página Web pero evitar el problema de que los usuarios no puedan usar sus lectores de pantalla debido a la interferencia causada por el sonido del contenido. Esta técnica es simple. El sonido se reproduce durante 3 segundos o menos y se para automáticamente.",
				categoriaTecnica);
	}

	/**
	 * 1. Cargar la página Web.
	 * 2. Verificar que todos los sonidos que se reproduzcan automáticamente se detengan en 3 segundos o menos.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionApagadoSonido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Sonidos que se reproduzcan automáticamente se detengan en 3 segundos o menos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que todos los sonidos que se reproduzcan automáticamente se detengan en 3 segundos o menos.",
				"Si un sonido se reproduce automáticamente, apágalo también automáticamente antes de tres segundos.");
		comprobacionApagadoSonido.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionApagadoSonido);
		return resultadoEvaluacionTecnica;
	}

}