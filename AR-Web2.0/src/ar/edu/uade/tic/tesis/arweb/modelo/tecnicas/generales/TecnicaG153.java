package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG153 extends TecnicaGeneral {

	public TecnicaG153(CategoriaTecnica categoriaTecnica) {
		super(
				"G153",
				"Hacer el texto m�s f�cil de leer.",
				"El objetivo de esta t�cnica es garantizar que el texto de la p�gina web no sea dif�cil de leer. Los usuarios con discapacidades que dificultan la decodificaci�n de palabras y oraciones probablemente tengan problemas para leer y comprender textos complejos. Si el texto no requiere capacidad de lectura m�s avanzada que el nivel de educaci�n secundaria inferior, no se necesitan suplementos o versiones alternativas..", 
				categoriaTecnica);
	}

	/**
	 * 1. Mida la legibilidad del texto.
	 * 2. Verifique que el texto requiere una capacidad de lectura menos avanzada que el nivel de educaci�n secundaria inferior.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextosFacilesDeLeer = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Hacer el texto m�s f�cil de leer.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el texto requiere una capacidad de lectura poco avanzada, simple.",
				"Escriba los textos de forma tal que puedan ser comprendidos por todos los usuarios independientemente de su nivel educativo.");
		comprobacionTextosFacilesDeLeer.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextosFacilesDeLeer);
		return resultadoEvaluacionTecnica;
	}
	
}
