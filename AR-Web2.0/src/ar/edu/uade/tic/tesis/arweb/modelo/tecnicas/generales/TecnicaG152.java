package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG152 extends TecnicaGeneral {

	public TecnicaG152(CategoriaTecnica categoriaTecnica) {
		super(
				"G152",
				"Ajuste de im�genes animadas del GIF para detener el parpadeo despu�s de n ciclos (a menos de 5 segundos).",
				"El objetivo de esta t�cnica es asegurar que las im�genes animadas del GIF dejen de parpadear antes de cinco segundos.", 
				categoriaTecnica);
	}

	/**
	 * Verificar que la duraci�n de la animaci�n debe ser menor que o igual a 5 segundos.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionContenidoEnMovimientoOParpadeante = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Contenido en movimiento o parpadeante.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la duraci�n de la animaci�n debe ser menor que o igual a 5 segundos.",
				"Dise�a los gif animados para que paren de parpadear despu�s de n ciclos reproducidos en 5 segundos.");
		comprobacionContenidoEnMovimientoOParpadeante.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContenidoEnMovimientoOParpadeante);
		return resultadoEvaluacionTecnica;
	}

}