package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG143 extends TecnicaGeneral {

	public TecnicaG143(CategoriaTecnica categoriaTecnica) {
		super(
				"G143", 
				"Proporcionar un texto alternativo que describe el propósito de la prueba CAPTCHA.",
				"El propósito de esta técnica es proporcionar información a través de la alternativa textual que identifica el contenido no textual como de CAPTCHA. Tales pruebas implican a menudo pidiendo al usuario que escriba el texto que se presenta en una imagen oscurecida o archivo de audio. A partir de la alternativa de texto, el usuario puede decir que el CAPTCHA requiere completar una tarea y qué tipo de tarea que es. Cuando una versión alternativa de un CAPTCHA esta disponible, el texto alternativo debe incluir instrucciones sobre cómo encontrar la versión alternativa.", 
				categoriaTecnica);
	}

	/**
	 * 1. Eliminar, ocultar o enmascarar el CAPTCHA.
	 * 2. Reemplazarlo con el texto alternativo.
	 * 3. Verificar que la alternativa de texto describe el propósito del CAPTCHA.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualDescribePropositoCAPTCHA = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa textual describe el propósito del CAPTCHA.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la alternativa de texto describe el propósito del CAPTCHA.",
				"Si el contenido no textual es un CAPTCHA describe el objetivo del CAPTCHA.");
		comprobacionAlternativaTextualDescribePropositoCAPTCHA.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualDescribePropositoCAPTCHA);
		return resultadoEvaluacionTecnica;
	}

}