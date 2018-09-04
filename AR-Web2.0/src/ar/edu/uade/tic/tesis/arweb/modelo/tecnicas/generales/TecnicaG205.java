package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG205 extends TecnicaGeneral {

	public TecnicaG205(CategoriaTecnica categoriaTecnica) {
		super(
				"G205",
				"La inclusión de una entrada de texto para las etiquetas de control de formulario de colores.",
				"El objetivo de esta técnica es combinar color y de texto o de caracteres señales para transmitir información. La mayoría de los usuarios pueden escanear rápidamente el contenido para localizar la información facilitada mediante el uso de las diferencias de color. Los usuarios que no pueden ver el color puede mirar o escuchar a las señales de texto; personas que utilizan pantallas braille o en otras interfaces táctiles pueden detectar señales de texto a través del tacto. La entrada de texto debe ser incluido como parte del nombre determinable por software para el control.", 
				categoriaTecnica);
	}

	/**
	 * Para cualquier contenido que se utilizan diferencias de color para transmitir información:
	 * 1. Verificar que la misma información está disponible a través de texto o caracteres señales.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Información transmitida con color también en texto.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cualquier contenido que se utilizan diferencias de color para transmitir información: Verificar que la misma información está disponible a través de texto o caracteres señales.",
				"Si se comunica información mediante el color en palabras, fondos u otros contenidos: Incluye una señal de texto para etiquetas de controles de formulario coloreadas.");
		comprobacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
		return resultadoEvaluacionTecnica;
	}

}