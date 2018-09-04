package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaH86 extends TecnicaHTML {

	public TecnicaH86(CategoriaTecnica categoriaTecnica) {
		super(
				"H86",
				"Proporcionar alternativas textuales para el arte ASCII, los emoticones y la escritura leet.", 
				"",
				categoriaTecnica);
	}

	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAltEnArteASCII = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Atributo \"alt\" en arte ASCII.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que hay un texto alternativo inmediatamente antes o después de todo arte ASCII.",
				"No utilices arte ASCII sin ofrecer una alternativa textual.");
		ResultadoEvaluacionTecnicaItem comprobacionAltEnEmoticones = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Atributo \"alt\" en emoticones.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que hay un texto alternativo inmediatamente antes o después de todo emoticones.",
				"No utilices emoticones sin ofrecer una alternativa textual.");
		ResultadoEvaluacionTecnicaItem comprobacionAltEnEscrituraLeet = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Atributo \"alt\" en texto en formato \"leet\".", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que hay un texto alternativo inmediatamente antes o después de todo texto en formato \"leet\".",
				"No utilices texto en formato \"leet\" sin ofrecer una alternativa textual.");
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAltEnArteASCII);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAltEnEmoticones);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAltEnEscrituraLeet);
		return resultadoEvaluacionTecnica;
	}

}