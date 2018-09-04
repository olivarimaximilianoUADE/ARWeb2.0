package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG198 extends TecnicaGeneral {

	public TecnicaG198(CategoriaTecnica categoriaTecnica) {
		super(
				"G198", 
				"Proporcionar una forma para que el usuario active el límite de tiempo libre.", 
				"El objetivo de esta técnica es proveer un mecanismo para personas que no pueden completar las tareas dentro de un plazo determinado para desactivar el límite de tiempo. Es esencial que el mecanismo para desactivar el límite de tiempo pueda completarse sin un límite de tiempo en sí mismo y antes de que el tiempo límite de la página expire. Para ello - el mecanismo debe estar disponible en o cerca de la parte superior de la página de modo que se puede encontrar de forma rápida y activado por personas con una diversidad de discapacidades.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que existe un mecanismo para desactivar cualquier límite de tiempo cerca de la parte superior de la página.
	 * 2. Verificar que el límite de tiempo para la página es lo suficientemente largo para que un usuario pueda navegar fácilmente al mecanismo, incluso si son 10 veces más lentos que la mayoría de los usuarios.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionLimiteTiempoSesion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Límite de tiempo de sesión.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que existe un mecanismo para desactivar cualquier límite de tiempo cerca de la parte superior de la página.",
				"Si hay un límite de tiempo de sesión: Ofrece un mecanismo en la primera página de un formulario que se distribuye en varias páginas que permita a los usuarios solicitar un mayor límite de tiempo o eliminarlo. Ofrece un mecanismo que permita a los usuarios");
		ResultadoEvaluacionTecnicaItem comprobacionLimiteTiempoControladoPorScript = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Límite de tiempo controlado mediante un script.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que existe un mecanismo para desactivar cualquier límite de tiempo cerca de la parte superior de la página.",
				"Si el límite de tiempo es controlado por la programación de la página: Ofrece un mecanismo que permita a los usuarios anular el límite de tiempo.");
		ResultadoEvaluacionTecnicaItem comprobacionLecturaTextosEnMovimiento = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Lectura de textos en movimiento.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que existe un mecanismo para desactivar cualquier límite de tiempo cerca de la parte superior de la página.",
				"Si hay un límite de tiempo para leer los contenidos: Permite al usuario pausar el contenido y volver a reproducirlo desde donde fue parado.");
		comprobacionLimiteTiempoSesion.procesar();
		comprobacionLimiteTiempoControladoPorScript.procesar();
		comprobacionLecturaTextosEnMovimiento.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLimiteTiempoSesion);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLimiteTiempoControladoPorScript);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLecturaTextosEnMovimiento);
		return resultadoEvaluacionTecnica;
	}

}