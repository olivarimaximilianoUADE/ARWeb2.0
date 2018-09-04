package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG133 extends TecnicaGeneral {

	public TecnicaG133(CategoriaTecnica categoriaTecnica) {
		super(
				"G133",
				"Poveer una casilla de verificación en la primer página de un formulario de múltiples partes que permita que los usuarios soliciten un tiempo límite de sesión más extenso o ningún tiempo límite de sesión.",
				"El objetivo de esta técnica es reducir al mínimo el riesgo de que los usuarios con discapacidad pierdan su trabajo, proporcionando una casilla para solicitar tiempo adicional para completar formularios de varios ejemplares. La casilla de verificación puede permitir al usuario solicitar una cantidad específica de tiempo adicional (por ejemplo 15 minutos) o una extensión indefinida. (Tenga en cuenta que lo que permite una extensión indefinida sería inapropiado si se pone en peligro la privacidad del usuario o la seguridad de la red.).", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que la página Web incluya una casilla de verificación para solicitar tiempo adicional para completar el formulario.
	 * 2. Verificar que si la casilla de verificación esta tildada, se provea tiempo adicional para completar el formulario.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionLimiteTiempoSesion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Límite de tiempo de sesión.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la página Web incluya una casilla de verificación para solicitar tiempo adicional para completar el formulario.",
				"Si hay un límite de tiempo de sesión: Ofrece un mecanismo en la primera página de un formulario que se distribuye en varias páginas que permita a los usuarios solicitar un mayor límite de tiempo o eliminarlo. Ofrece un mecanismo que permita a los usuarios anular el límite de tiempo.");
		comprobacionLimiteTiempoSesion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLimiteTiempoSesion);
		return resultadoEvaluacionTecnica;
	}

}