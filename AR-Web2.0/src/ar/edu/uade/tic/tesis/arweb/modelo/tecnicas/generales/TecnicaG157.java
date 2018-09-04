package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG157 extends TecnicaGeneral {

	public TecnicaG157(CategoriaTecnica categoriaTecnica) {
		super(
				"G157",
				"Incorporación de un servicio de subtitulado de audio en vivo en una página web.",
				"El objetivo de esta técnica es utilizar un servicio de subtítulos en tiempo real para proporcionar una versión de texto del contenido de audio en vivo. Dichos servicios usan un operador humano capacitado que escucha lo que se dice y usa un teclado especial para ingresar el texto con solo un pequeño retraso. Pueden capturar un evento en vivo con un alto grado de fidelidad y también insertar notas en cualquier audio no hablado que sea esencial para comprender el evento. La ventana gráfica que contiene el texto de subtítulos está disponible en la misma página web que el contenido de audio en vivo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que la página web contenga una ventana gráfica asociada con el contenido de audio en vivo.
	 * 2. Compruebe que el texto del contenido de audio en vivo aparezca en la ventana gráfica con menos de 30 segundos de retraso.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSubtitulosEnVivo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Subtitulo de audio en vivo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el video tiene subtitulos con menos de 30 segundos de retraso.",
				"Si el vídeo tiene audio hablado, ofrece una alternativa que presente la misma información en tiempo real.");
		comprobacionSubtitulosEnVivo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSubtitulosEnVivo);
		return resultadoEvaluacionTecnica;
	}
	
}
