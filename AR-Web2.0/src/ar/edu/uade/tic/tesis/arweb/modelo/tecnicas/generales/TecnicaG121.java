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
				"El objetivo de esta técnica es hacer que la pronunciación de una palabra esté disponible proporcionando información sobre la pronunciación, ya sea dentro de la misma página web o en una página web diferente, y estableciendo un vínculo entre el elemento y su pronunciación.", 
				categoriaTecnica);
	}

	/**
	 * Para cada palabra que requiere información de pronunciación:
	 * 	1. Verifique que al menos la primera instancia del elemento sea un enlace.
	 *  2. Verifique que cada enlace navegue hacia la información sobre la pronunciación del elemento.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPronunciacionPalabraEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"La palabra es un enlace a la pronunciación de la misma.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que las palabras que requieran pronunciación sean un enlace a la pronunciación de la misma.",
				"Cuando existan palabras con una pronunciación especial o compleja las mismas deben ser un vinculo a la pronunciación para que el usuario pueda leerla sin inconvenientes.");
		comprobacionPronunciacionPalabraEnlace.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPronunciacionPalabraEnlace);
		return resultadoEvaluacionTecnica;
	}

}