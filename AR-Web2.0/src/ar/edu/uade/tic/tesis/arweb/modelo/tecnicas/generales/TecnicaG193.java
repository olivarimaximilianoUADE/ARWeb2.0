package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG193 extends TecnicaGeneral {

	public TecnicaG193(CategoriaTecnica categoriaTecnica) {
		super(
				"G193", 
				"Proporcionar ayuda de un asistente en la p�gina web.", 
				"El prop�sito de esta t�cnica es proporcionar ayuda con un avatar multimedia que brinda asistencia para usar la p�gina web. Un avatar puede ser particularmente �til para las personas con discapacidades cognitivas que pueden tener problemas para leer textos. El uso de elementos visuales ayudar� a algunas personas a enfocarse en el material presentado..", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que haya un asistente en la p�gina web.
	 * 2. Verifique que el asistente proporcione informaci�n para ayudar a comprender el contenido de la p�gina.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAsistenteMultimedia = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Asistente multimedia virtual en el sitio web.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el sitio cuenta con un asistente multimedia virtual del tipo avatar para brindar asistencia a los usuarios.",
				"Valida la p�gina web tenga un avatar multimedia como asistente virtual.");
		comprobacionAsistenteMultimedia.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAsistenteMultimedia);
		return resultadoEvaluacionTecnica;
	}

}