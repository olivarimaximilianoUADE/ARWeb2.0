package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG187 extends TecnicaGeneral {

	public TecnicaG187(CategoriaTecnica categoriaTecnica) {
		super(
				"G187",
				"El uso de una tecnología para incluir el contenido parpadeante que puede ser desactivada a través del agente de usuario.",
				"El objetivo de esta técnica es la de asegurar que el contenido destellante se puede desactivar utilizando características de agente usuario. Los agentes usuario permiten a los usuarios detener la animación de contenidos en determinadas tecnologías. Cuando el usuario activa esta característica, toda la animación, incluyendo destellos, se detiene. Esta característica puede ser proporcionada ya sea a través de controles interactivos que se ajusten a las WCAG o a través de atajos de teclado documentados. La forma más común para los usuarios detener la animación es pulsar la tecla \"escape\". Mientras que no hay procesos que tienen prioridad en la cola de eventos para un uso de esa tecla, esto se toma como un comando para detener la animación de movimiento o contenido destellante. Tecnologías que se conoce que funcione generalmente incluyen: Intercambio de formato grafico (GIF), Gráficos Animados de redes portátiles (APNG)", 
				categoriaTecnica);
	}

	/**
	 * 1. Cargar una página que incluya contenido destellante.
	 * 2. Activar el comando de detención de animaciones en el navegador (usualmente la tecla “Escape”).
	 * 3. Verificar que los destellos se hayan detenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionContenidoEnMovimientoParpadeante = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Contenido en movimiento o parpadeante.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que los destellos se hayan detenido cuando se activa el comando de detención de animaciones en el navegador.",
				"Si usas una tecnología para incluir contenido parpadeante, el usuario puede apagarlo a través del agente de usuario.");
		comprobacionContenidoEnMovimientoParpadeante.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContenidoEnMovimientoParpadeante);
		return resultadoEvaluacionTecnica;
	}

}