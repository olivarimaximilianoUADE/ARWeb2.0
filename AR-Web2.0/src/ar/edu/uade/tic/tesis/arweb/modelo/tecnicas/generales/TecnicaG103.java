package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG103 extends TecnicaGeneral {

	public TecnicaG103(CategoriaTecnica categoriaTecnica) {
		super(
				"G103",
				"Proporcionar ilustraciones visuales, im�genes y s�mbolos para ayudar a explicar ideas, eventos y procesos.", 
				"El objetivo de esta t�cnica es proporcionar ilustraciones visuales que ayuden a los usuarios con discapacidades de lectura a comprender textos dif�ciles que describen conceptos o procesos. Las ilustraciones se proporcionan adem�s del texto. Los usuarios con discapacidades que dificultan la decodificaci�n de palabras y oraciones probablemente tengan problemas para leer y comprender textos complejos. Gr�ficos, diagramas, animaciones, fotograf�as, organizadores gr�ficos u otros materiales visuales a menudo ayudan a estos usuarios.",
				categoriaTecnica);
	}

	/**
	 * 1. Identifique texto que discuta ideas o procesos que deben ser comprendidos para usar el contenido.
	 * 2. Verifique si las ilustraciones visuales est�n disponibles en el contenido o a trav�s de enlaces dentro del contenido.
	 * 3. Verifique que las ilustraciones visuales muestren los conceptos o procesos discutidos en el texto.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionExplicacionMedianteIlustracionesVisuales = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Explicar ideas, eventos y procesos mediante ilustraciones visuales, imagenes y s�mbolos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que por cada texto que discuta ideas o procesos complejos o dificiles de comprender exista un contenido visual que ayude a explicar comprender mejor la idea al usuario.",
				"Cuando se tengan textos que presenten temas, ideos o procesos complejos que sean dificiles de entender por los usuarios, se debe incorporar contenido visual (imagenes, ilustraciones o simbolos) para ayudar a la comprensi�n del mismo.");
		comprobacionExplicacionMedianteIlustracionesVisuales.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionExplicacionMedianteIlustracionesVisuales);
		return resultadoEvaluacionTecnica;
	}

}