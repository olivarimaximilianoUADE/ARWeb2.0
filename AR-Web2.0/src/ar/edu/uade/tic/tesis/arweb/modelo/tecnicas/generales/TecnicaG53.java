package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG53 extends TecnicaGeneral {

	public TecnicaG53(CategoriaTecnica categoriaTecnica) {
		super(
				"G53",
				"Identificar el propósito de un enlace usando el texto de enlaces combinado con el texto de la sentencia de encerramiento.",
				"El objetivo de esta técnica es identificar el propósito de un enlace desde el enlace y su sentencia. La sentencia que encierra el enlace proporciona el contexto para un enlace de otra manera poco clara. La descripción permite a un usuario a distinguir este enlace siguiendo los enlaces de la página Web que conducen a otros destinos y ayuda al usuario a determinar si seguir o no el enlace. Tener en cuenta que simplemente proporcionar el URL del destino en general no es suficientemente descriptivo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que el enlace es parte de una sentencia.
	 * 2. Verificar que el texto del enlace combinada con el texto de su sentencia de cierre describe el propósito del enlace.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoEnlaceConTextoSentenciaDescribePropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Texto del enlace con el texto de la oración que lo engloba describe el propósito del enlace.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el texto en el enlace combinado con el texto de la oración que lo engloba describe el propósito del enlace.",
				"Identifica el objetivo de un enlace usando un texto en el enlace combinado con el texto de la oración que lo engloba.");
		comprobacionTextoEnlaceConTextoSentenciaDescribePropositoEnlace.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoEnlaceConTextoSentenciaDescribePropositoEnlace);
		return resultadoEvaluacionTecnica;
	}

}