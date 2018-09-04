package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG170 extends TecnicaGeneral {

	public TecnicaG170(CategoriaTecnica categoriaTecnica) {
		super(
				"G170",
				"Proporcionar un control casi al principio de la página Web que se apaga sonidos que se reproducen de forma automática.",
				"La intención de esta técnica es permitir que un usuario pueda anular los sonidos que se inician automáticamente cuando se carga una página. El control para apagar los sonidos debe estar situado cerca del comienzo de la página para permitir el control a sea fácilmente y rápidamente descubierto por los usuarios. Esto es útil para aquellos que utilizan tecnologías de apoyo (tales como lectores de pantalla, magnificadores de pantalla, dispositivos de conmutación, etc.) y los que no (como los que tienen discapacidad cognitiva, el aprendizaje y lenguaje). En esta técnica, un autor incluye un control que hace posible que los usuarios puedan desactivar los sonidos que se reproducen automáticamente. El control debe ser operable por teclado, que se encuentra al principio del orden de tabulación y la lectura, y claramente etiquetado para indicar que se va a desactivar los sonidos que se están reproduciendo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Cargar la página Web.
	 * 2. Identificar música o sonido que inicie automáticamente.
	 * 3. Verificar que el control que permite al usuario apagar el sonido sea provisto cerca del inicio de la página.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionControlApagadoSonidoReproduccionAutomatica = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Control que apaga sonidos que se reproducen de forma automática.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Identificar música o sonido que inicie automáticamente: Verificar que el control que permite al usuario apagar el sonido sea provisto cerca del inicio de la página.",
				"Ofrece un control al usuario en el inicio de la página web para que pueda apagar los sonidos que suenan automáticamente.");
		comprobacionControlApagadoSonidoReproduccionAutomatica.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionControlApagadoSonidoReproduccionAutomatica);
		return resultadoEvaluacionTecnica;
	}

}