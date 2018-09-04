package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG62 extends TecnicaGeneral {

	public TecnicaG62(CategoriaTecnica categoriaTecnica) {
		super(
				"G62", 
				"Proporcionar un glosario.", 
				"El objetivo de esta técnica es hacer que la definición de una palabra, frase o abreviatura esté disponible al proporcionar la definición en un glosario. Un glosario es una lista alfabética de palabras, frases y abreviaturas con sus definiciones. Los glosarios son más apropiados cuando las palabras, frases y abreviaturas utilizadas en el contenido se relacionan con una disciplina específica o área de tecnología. Un glosario también puede proporcionar la pronunciación de una palabra o frase.",
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que:
	 * 		El glosario está incluido en la página web, o
	 * 		Un mecanismo está disponible para ubicar el glosario.
	 * 2. Compruebe que cada palabra, frase o abreviatura que se definirá se define en el glosario
	 * 3. Verifique que el glosario contenga solo una definición para cada artículo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionGlosario = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Existencia de glosario.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el sitio cuenta con un glosario y que este contiene al definición de cada palabra, frase o abreviatura.",
				"Si el sitio posee vocabulario especifico que el común de las personas desconoce deberá tener un glosario con la definición de las palabras, frases o abreviaturas específicas.");
		comprobacionGlosario.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionGlosario);
		return resultadoEvaluacionTecnica;
	}

}