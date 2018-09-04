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
				"El objetivo de esta t�cnica es hacer que la definici�n de una palabra, frase o abreviatura est� disponible al proporcionar la definici�n en un glosario. Un glosario es una lista alfab�tica de palabras, frases y abreviaturas con sus definiciones. Los glosarios son m�s apropiados cuando las palabras, frases y abreviaturas utilizadas en el contenido se relacionan con una disciplina espec�fica o �rea de tecnolog�a. Un glosario tambi�n puede proporcionar la pronunciaci�n de una palabra o frase.",
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que:
	 * 		El glosario est� incluido en la p�gina web, o
	 * 		Un mecanismo est� disponible para ubicar el glosario.
	 * 2. Compruebe que cada palabra, frase o abreviatura que se definir� se define en el glosario
	 * 3. Verifique que el glosario contenga solo una definici�n para cada art�culo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionGlosario = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Existencia de glosario.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el sitio cuenta con un glosario y que este contiene al definici�n de cada palabra, frase o abreviatura.",
				"Si el sitio posee vocabulario especifico que el com�n de las personas desconoce deber� tener un glosario con la definici�n de las palabras, frases o abreviaturas espec�ficas.");
		comprobacionGlosario.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionGlosario);
		return resultadoEvaluacionTecnica;
	}

}