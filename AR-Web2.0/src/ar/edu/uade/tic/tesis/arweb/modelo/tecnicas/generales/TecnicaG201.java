package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG201 extends TecnicaGeneral {

	public TecnicaG201(CategoriaTecnica categoriaTecnica) {
		super(
				"G201", 
				"Dar a los usuarios avanzados de alerta cuando se abre una nueva ventana.", 
				"El objetivo de esta técnica es proporcionar una advertencia antes de abrir automáticamente una nueva ventana o pestaña. La apertura de nuevas ventanas de forma automática cuando un enlace se activa puede ser desorientador para personas que tienen dificultades para percibir el contenido visual, y para algunas personas con discapacidades cognitivas, si no son advertidas de antemano. Proporcionar una advertencia permite al usuario decidir si quieren dejar la ventana actual, y la advertencia le ayudará a encontrar su camino de regreso, si deciden que les gustaría ir a la nueva ventana. Se les ayudará a entender que el botón \"atrás\" no va a funcionar y que tienen que volver a la última ventana que tenían abierta, con el fin de encontrar su ubicación anterior.",
				categoriaTecnica);
	}

	/**
	 * Para cada enlace que se abre automáticamente en una nueva ventana o pestaña cuando un cambio de contexto es iniciado por una petición del usuario:
	 * 1. Verificar que haya una advertencia sobre que se habla en la tecnología de asistencia de este enlace que se abre en una nueva ventana.
	 * 2. Verificar que hay una advertencia visual en el texto que este enlace se abre en una nueva ventana.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlertaCuandoSeAbreNuevaVentana = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Alerta antes de abrir automáticamente una nueva ventana o pestaña.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cada enlace que se abre automáticamente en una nueva ventana o pestaña cuando un cambio de contexto es iniciado por una petición del usuario: Verificar que hay una advertencia visual en el texto que este enlace se abre en una nueva ventana.",
				"Avisa siempre a los usuarios cuando se van a abrir nuevas ventanas.");
		comprobacionAlertaCuandoSeAbreNuevaVentana.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlertaCuandoSeAbreNuevaVentana);
		return resultadoEvaluacionTecnica;
	}

}