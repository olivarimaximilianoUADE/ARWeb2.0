package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG115 extends TecnicaGeneral {

	public TecnicaG115(CategoriaTecnica categoriaTecnica) {
		super(
				"G115", 
				"Usar elementos semánticos para marcar la estructura.", 
				"El objetivo de esta técnica es para marcar la estructura del contenido de la Web utilizando los elementos semánticos apropiados. En otras palabras, los elementos se utilizan según su significado, no por la forma en que aparecen visualmente. El uso de los elementos semánticos apropiados se asegurará de que la estructura está disponible para el agente de usuario. Esto implica que indique explícitamente el papel que tienen diferentes unidades para comprender el significado del contenido. La naturaleza de un fragmento de contenido como un párrafo, encabezado, texto subrayado, cuadros, etc. todo puede ser indicado de esta manera. En algunos casos, las relaciones entre las unidades de contenido también se deben indicar, por ejemplo, entre los títulos y subtítulos, o entre las celdas de una tabla. El agente de usuario puede entonces hacer la perceptible estructura para el usuario, por ejemplo, utilizando una presentación visual diferente para diferentes tipos de estructuras o mediante el uso de una voz o tono diferente en una presentación auditiva. En HTML, por ejemplo, los elementos a nivel de frase, como EM, ABBR, y CITE añade información semántica dentro de las sentencias, el marcado de texto para el énfasis y la identificación de las abreviaturas y las citas, respectivamente. MathML, un lenguaje de marcas diseñado para mantener las distinciones importantes entre la estructura y la presentación en matemáticas, incluye especial marcado \"presentación\" de los complejos notaciones usadas para representar las ideas matemáticas, así como el marcado \"contenido\" (semántica) para las propias ideas matemáticas.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar si hay partes del contenido que tienen una función semántica.
	 * 2. Para cada parte que tiene una función semántica, si el correspondiente marcado semántico existe en la tecnología, verificar que el contenido ha sido marcado usando el lenguaje de formato semántico.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionElementosSemanticos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Uso de elementos semánticos para marcar la estructura", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cada parte que tiene una función semántica, si el correspondiente marcado semántico existe en la tecnología, verificar que el contenido ha sido marcado usando el lenguaje de formato semántico.",
				"Si la tecnología ofrece una estructura semántica para comunicar la información y las relaciones (por ejemplo, HTML), formatea la estructura y el texto con elementos semánticos.");
		comprobacionElementosSemanticos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionElementosSemanticos);
		return resultadoEvaluacionTecnica;
	}

}