package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG87 extends TecnicaGeneral {

	public TecnicaG87(CategoriaTecnica categoriaTecnica) {
		super(
				"G87", 
				"Proporcionar subtítulos.", 
				"El objetivo de esta técnica es proporcionar una manera para que las personas que tienen problemas de audición o de otra manera tendrían problemas para escuchar el diálogo en el material multimedia sincronizado para poder ver el material y ver el diálogo y sonidos - sin personas que requieren que no son sordos para ver las capturas. Con esta técnica, todo el diálogo y sonidos importantes están incrustados como texto de una manera que hace que el texto no sea visible a menos que el usuario lo solicita. Como resultado son visibles sólo cuando sea necesario. Se requiere un apoyo especial para las capturas en el agente de usuario.", 
				categoriaTecnica);
	}

	/**
	 * 1. Activar la función de subtítulos del reproductor multimedia.
	 * 2. Ver el contenido multimedia sincronizado.
	 * 3. Verificar que los subtítulos (de todos los diálogos y sonidos importantes) son visibles.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSubtitulos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Subtítulos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que los subtítulos (de todos los diálogos y sonidos importantes) son visibles.",
				"Ofrece subítulos para sordos de forma cerrada  (disponibles en un archivo externo, un programa auxiliar los presenta junto al vídeo).");
		comprobacionSubtitulos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSubtitulos);
		return resultadoEvaluacionTecnica;
	}

}