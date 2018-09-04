package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG189 extends TecnicaGeneral {

	public TecnicaG189(CategoriaTecnica categoriaTecnica) {
		super(
				"G189",
				"Proporcionar un control casi al principio de la página Web que cambia el texto del enlace.", 
				"El objetivo de esta técnica es proporcionar al usuario un control cerca del comienzo de la página que lleva al usuario a una versión alternativa conforme a la página Web en el que el texto del enlace solo es suficiente para determinar su propósito fuera del contexto. Algunos usuarios prefieren tener enlaces que son autónomos, donde no hay necesidad de explorar el contexto del enlace. Otros usuarios encuentran incluída la información del contexto en cada enlace para evitar repeticiones y reducir su capacidad de utilizar un sitio. Entre los usuarios de la tecnología se encuentran la retroalimentación al grupo de trabajo sobre la que es preferible que sea dividida. Esta técnica permite a los usuarios elegir el método que funciona mejor para ellos. Los usuarios que necesitan o prefieren más largo y completo el texto del enlace utilizan esta versión. Si el control para cambiar a la versión alternativa es un enlace, debe ser siempre posible entender el propósito del control directamente de su texto de enlace. Esta técnica ofrece la versión alternativa de la vista de la página actual. También es posible, y en algunos casos sería aconsejable, guardar esta preferencia en un perfil de cookies o del lado del servidor del usuario, de modo que sólo los usuarios tendrían que hacer la selección una vez por sitio y serán automáticamente llevados a su versión preferida.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que hay un control casi al principio de la página Web para cambiar el texto del vínculo.
	 * 2. Activar el control.
	 * 3. Verificar que todos los enlaces en la página Web resultante tienen texto del enlace que describe su propósito.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionControlCambiaTextoDelEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Control que cambia el texto del enlace.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que todos los enlaces en la página Web resultante tienen texto del enlace que describe su propósito cuando se activa el control para cambiar el texto del vínculo.",
				"Permite al usuario elegir enlaces cortos o largos mediante un control junto al inicio de la página web que cambie el texto de los enlaces o una programación que cambie el texto de los enlaces.");
		comprobacionControlCambiaTextoDelEnlace.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionControlCambiaTextoDelEnlace);
		return resultadoEvaluacionTecnica;
	}

}