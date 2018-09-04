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
				"Proporcionar la expansión o explicación de una abreviación.", 
				"El objetivo de esta técnica es proporcionar la información necesaria para comprender una abreviatura. Una abreviatura es la forma abreviada de una palabra, frase o nombre. Para la mayoría de las abreviaturas, proporcionar la palabra, frase o nombre completos es suficiente.",
				categoriaTecnica);
	}

	/**
	 * Para cada abreviatura en el contenido:
	 *  1. Si la abreviatura no tiene forma expandida, se proporciona una explicación.
	 *  2. Si la forma expandida de la abreviatura está en un idioma diferente al del contenido, se proporciona una explicación.
	 *  3. De lo contrario, se proporciona la forma expandida.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionExpansionExplicacionAbreviacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Expansión o explicación de una abreviación.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que por cada abreviación que tenga el sitio se proporciona la expansión o una explicación para comprender la misma.",
				"Se deben indicar la expansión o explicación de las abreviaturas que tiene el sitio web a fin que pueda ser comprendido por todos los usuarios sin importar su nivel de conocimientos.");
		comprobacionExpansionExplicacionAbreviacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionExpansionExplicacionAbreviacion);
		return resultadoEvaluacionTecnica;
	}

}