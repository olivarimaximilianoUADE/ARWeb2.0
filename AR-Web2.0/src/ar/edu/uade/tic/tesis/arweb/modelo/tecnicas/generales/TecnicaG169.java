package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG169 extends TecnicaGeneral {

	public TecnicaG169(CategoriaTecnica categoriaTecnica) {
		super(
				"G169", 
				"Alineaci�n de texto en un solo lado.", 
				"Muchas personas con discapacidades cognitivas tienen una gran cantidad de problemas con bloques de texto que est�n justificados (alineados con los m�rgenes izquierdo y derecho). Los espacios entre las palabras crean \"r�os de blanco\" que corren por la p�gina, lo que puede dificultar el texto para que algunas personas lo lean. Este error describe situaciones en las que se produce este dise�o de texto confuso. La mejor manera de evitar este problema es no crear un dise�o de texto que est� completamente justificado.",
				categoriaTecnica);
	}

	/**
	 * 1. Abra la p�gina en un navegador com�n.
	 * 2. Verifique que el contenido no est� justificado (alineado tanto con los m�rgenes izquierdo como derecho).
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoJustificado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Texto alineado a un solo margen, no justificado.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"El texto del sitio debe esta alineado a un solo margen (derecho o izquierdo), no justificado para evitar que no pueda ser le�do por personas con descapacidades cognitivas.",
				"Todos los textos del sitio deben estar alineados a un solo margen, no deben estar justificados.");
		comprobacionTextoJustificado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoJustificado);
		return resultadoEvaluacionTecnica;
	}

}