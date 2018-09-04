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
				"Incorporaci�n de un servicio de subtitulado de audio en vivo en una p�gina web.",
				"El objetivo de esta t�cnica es utilizar un servicio de subt�tulos en tiempo real para proporcionar una versi�n de texto del contenido de audio en vivo. Dichos servicios usan un operador humano capacitado que escucha lo que se dice y usa un teclado especial para ingresar el texto con solo un peque�o retraso. Pueden capturar un evento en vivo con un alto grado de fidelidad y tambi�n insertar notas en cualquier audio no hablado que sea esencial para comprender el evento. La ventana gr�fica que contiene el texto de subt�tulos est� disponible en la misma p�gina web que el contenido de audio en vivo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que la p�gina web contenga una ventana gr�fica asociada con el contenido de audio en vivo.
	 * 2. Compruebe que el texto del contenido de audio en vivo aparezca en la ventana gr�fica con menos de 30 segundos de retraso.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSubtitulosEnVivo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Subtitulo de audio en vivo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el video tiene subtitulos con menos de 30 segundos de retraso.",
				"Si el v�deo tiene audio hablado, ofrece una alternativa que presente la misma informaci�n en tiempo real.");
		comprobacionSubtitulosEnVivo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSubtitulosEnVivo);
		return resultadoEvaluacionTecnica;
	}
	
}
