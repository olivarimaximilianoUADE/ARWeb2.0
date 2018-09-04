package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG121 extends TecnicaGeneral {

	public TecnicaG121(CategoriaTecnica categoriaTecnica) {
		super(
				"G121",
				"Vinculo a las pronunciaciones.",
				"El objetivo de esta t�cnica es hacer que la pronunciaci�n de una palabra est� disponible proporcionando informaci�n sobre la pronunciaci�n, ya sea dentro de la misma p�gina web o en una p�gina web diferente, y estableciendo un v�nculo entre el elemento y su pronunciaci�n.", 
				categoriaTecnica);
	}

	/**
	 * Para cada palabra que requiere informaci�n de pronunciaci�n:
	 * 	1. Verifique que al menos la primera instancia del elemento sea un enlace.
	 *  2. Verifique que cada enlace navegue hacia la informaci�n sobre la pronunciaci�n del elemento.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPronunciacionPalabraEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"La palabra es un enlace a la pronunciaci�n de la misma.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que las palabras que requieran pronunciaci�n sean un enlace a la pronunciaci�n de la misma.",
				"Cuando existan palabras con una pronunciaci�n especial o compleja las mismas deben ser un vinculo a la pronunciaci�n para que el usuario pueda leerla sin inconvenientes.");
		comprobacionPronunciacionPalabraEnlace.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPronunciacionPalabraEnlace);
		return resultadoEvaluacionTecnica;
	}

}