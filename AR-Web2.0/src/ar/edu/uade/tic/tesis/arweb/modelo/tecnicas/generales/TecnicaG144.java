package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG144 extends TecnicaGeneral {

	public TecnicaG144(CategoriaTecnica categoriaTecnica) {
		super(
				"G144",
				"Asegurarse de que la página Web contiene otro CAPTCHA para servir al mismo propósito utilizando una modalidad diferente.",
				"El propósito de esta técnica es reducir las ocasiones en las que un usuario con una discapacidad no puede completar una tarea de CAPTCHA. Debido a que hay tareas de CAPTCHA alternativos que utilizan diferentes modalidades, un usuario es más probable que sea capaz de completar una de las tareas con éxito.", 
				categoriaTecnica);
	}

	/**
	 * Por cada CAPTCHA en una página Web:
	 * 1. Verificar que la página web contiene otro CAPTCHA para el mismo propósito, pero utilizando una modalidad diferente.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionOtroCAPTCHAParaMismoProposito = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Página Web con otro CAPTCHA para el mismo propósito.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Por cada CAPTCHA en una página Web: Verificar que la página web contiene otro CAPTCHA para el mismo propósito, pero utilizando una modalidad diferente.",
				"Ofrece más de dos modalidades de CAPTCHA o acceso directo al personal de atención al cliente.");
		comprobacionOtroCAPTCHAParaMismoProposito.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionOtroCAPTCHAParaMismoProposito);
		return resultadoEvaluacionTecnica;
	}

}