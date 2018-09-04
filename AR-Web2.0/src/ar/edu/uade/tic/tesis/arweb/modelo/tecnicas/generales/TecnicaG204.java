package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG204 extends TecnicaGeneral {

	public TecnicaG204(CategoriaTecnica categoriaTecnica) {
		super(
				"G204", 
				"No interferir con el reflujo de texto del agente de usuario a medida que se reduce la ventana de visualización.",
				"Esta técnica ayuda a evitar situaciones en las que se puede producir desplazamiento horizontal. Muchas personas con discapacidades cognitivas y usuarios con baja visión que no usan tecnología de asistencia tienen un gran problema con bloques de texto que requieren desplazamiento horizontal. Implica no interferir con el reflujo del texto si la ventana se reduce. Una de las mejores formas de hacerlo es definir el ancho de los contenedores de texto en porcentajes.", 
				categoriaTecnica);
	}

	/**
	 * 1. Abra el contenido que contiene un bloque de texto en un agente de usuario común.
	 * 2. Compruebe si el agente de usuario tiene una configuración que debe habilitarse para permitir el reflujo y, de ser así, habilítelo.
	 * 3. Reduzca la ventana de visualización a 1/4 del ancho de la pantalla.
	 * 4. Verifique que el contenido no requiera desplazamiento horizontal para leer una línea de texto.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionReflujoTextoSinDesplazamientoHorizontal = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"No aparecen barras de desplazamiento horizontal al reducir la pantalla", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que al reducir el tamaño del navegador no aparecen las barras de desplamiento horizontal.",
				"Garantizar que el contenido no requiera desplazamiento horizontal para leer una línea de texto si cambia el tamaño del navegador.");
		comprobacionReflujoTextoSinDesplazamientoHorizontal.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionReflujoTextoSinDesplazamientoHorizontal);
		return resultadoEvaluacionTecnica;
	}

}