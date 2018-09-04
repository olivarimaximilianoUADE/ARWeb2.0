package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG107 extends TecnicaGeneral {

	public TecnicaG107(CategoriaTecnica categoriaTecnica) {
		super(
				"G107",
				"El uso de \"activar\" en lugar de \"enfoque\" como desencadenante de cambios de contexto.", 
				"El objetivo de esta técnica es proporcionar un método para la activación de cosas que son predecibles por el usuario. Los usuarios con discapacidades cognitivas y las personas que utilizan lectores de pantalla o ampliadores de pantalla pueden ser confundidos por un evento inesperado, como el envío de formularios automático o activación de una función que causa un cambio de contexto. Con esta técnica, todos los cambios de contexto se activarían sólo mediante una acción específica por parte del usuario. Además, que la acción sea una de las cosas que pueda causar cambios en el contexto, como hacer clic en un enlace o pulsando un botón de envío. Las acciones que simplemente sean mover el foco a un elemento no causarían un cambio de contexto.",
				categoriaTecnica);
	}

	/**
	 * 1. El uso de un teclado, haciendo foco a través de todos los contenidos.
	 * 2. Verificar que no haya cambios en el contexto que puede ocurrir cuando cualquier componente recibe el foco.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCambioContenidosConOnfocus = new ResultadoEvaluacionTecnicaItem(
				Tipologia.SCRIPTS, 
				"Cambio de contenidos con el evento \"onfocus\".", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que no haya cambios en el contexto que puede ocurrir cuando cualquier componente recibe el foco.",
				"Usa \"activate\" en lugar de \"focus\" como disparadores de cambios de contexto. Observa que se habla de cambios de contexto, no de cambios de contenido.");
		ResultadoEvaluacionTecnicaItem comprobacionAperturaVentanaAlCambiarElFoco = new ResultadoEvaluacionTecnicaItem(
				Tipologia.SCRIPTS, 
				"Apertura de ventana al cambiar el foco.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que no haya cambios en el contexto que puede ocurrir cuando cualquier componente recibe el foco.",
				"Abre ventanas nuevas sólo cuando sea la mejor alternativa y avisa siempre a los usuarios. No abras una ventana nueva tan pronto como cargue la página.");
		comprobacionCambioContenidosConOnfocus.procesar();
		comprobacionAperturaVentanaAlCambiarElFoco.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCambioContenidosConOnfocus);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAperturaVentanaAlCambiarElFoco);
		return resultadoEvaluacionTecnica;
	}

}