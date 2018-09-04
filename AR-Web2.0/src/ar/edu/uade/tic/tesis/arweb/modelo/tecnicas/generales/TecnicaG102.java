package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG102 extends TecnicaGeneral {

	public TecnicaG102(CategoriaTecnica categoriaTecnica) {
		super(
				"G102",
				"Proporcionar la expansi�n o explicaci�n de una abreviaci�n.", 
				"El objetivo de esta t�cnica es proporcionar la informaci�n necesaria para comprender una abreviatura. Una abreviatura es la forma abreviada de una palabra, frase o nombre. Para la mayor�a de las abreviaturas, proporcionar la palabra, frase o nombre completos es suficiente.",
				categoriaTecnica);
	}

	/**
	 * Para cada abreviatura en el contenido:
	 *  1. Si la abreviatura no tiene forma expandida, se proporciona una explicaci�n.
	 *  2. Si la forma expandida de la abreviatura est� en un idioma diferente al del contenido, se proporciona una explicaci�n.
	 *  3. De lo contrario, se proporciona la forma expandida.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionExpansionExplicacionAbreviacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Expansi�n o explicaci�n de una abreviaci�n.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que por cada abreviaci�n que tenga el sitio se proporciona la expansi�n o una explicaci�n para comprender la misma.",
				"Se deben indicar la expansi�n o explicaci�n de las abreviaturas que tiene el sitio web a fin que pueda ser comprendido por todos los usuarios sin importar su nivel de conocimientos.");
		comprobacionExpansionExplicacionAbreviacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionExpansionExplicacionAbreviacion);
		return resultadoEvaluacionTecnica;
	}

}