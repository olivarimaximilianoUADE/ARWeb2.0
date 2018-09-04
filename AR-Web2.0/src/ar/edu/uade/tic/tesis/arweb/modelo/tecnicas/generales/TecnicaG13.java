package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG13 extends TecnicaGeneral {

	public TecnicaG13(CategoriaTecnica categoriaTecnica) {
		super(
				"G13", 
				"Describir lo que va a pasar antes de que un cambio en un control de formulario cause una modificación en el contexto que se haya producido.", 
				"El objetivo de esta técnica es proporcionar información a los usuarios acerca de lo que sucederá cuando se produzca un cambio en un control de formulario de resultados a un cambio de contexto. Debido a que  cambiar el valor de un control de formulario no suele ocasionar en un cambio de contexto, es importante que los autores proporcionen instrucciones que hacen que el usuario esté consciente del comportamiento de antemano. Siempre que sea posible, es una buena idea para asociar mediante programación las instrucciones que describen el cambio con el propio control de formulario.", 
				categoriaTecnica);
	}

	/**
	 * 1. Localizar el contenido que al cambiar la configuración de una forma de control de resultados en un cambio de contexto.
	 * 2. Verificar que una explicación de lo que sucederá cuando se cambia el control está disponible antes de la activación de los controles.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionExplicacionSucederaCuandoCambiaControl = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Explicación de lo que sucederá cuando se cambia el control.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que una explicación de lo que sucederá cuando se cambia el control está disponible antes de la activación de los controles.",
				"Si un cambio en un control de formulario causa un cambio de contexto, describe antes qué sucederá.");
		comprobacionExplicacionSucederaCuandoCambiaControl.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionExplicacionSucederaCuandoCambiaControl);
		return resultadoEvaluacionTecnica;
	}

}