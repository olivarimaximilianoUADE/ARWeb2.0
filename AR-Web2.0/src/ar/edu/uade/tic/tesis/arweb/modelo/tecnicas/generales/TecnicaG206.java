package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG206 extends TecnicaGeneral {

	public TecnicaG206(CategoriaTecnica categoriaTecnica) {
		super(
				"G206",
				"Proporcionar opciones dentro del contenido para cambiar a un diseño que no requiera que el usuario se desplace horizontalmente para leer una línea de texto.",
				"Puede haber situaciones en las que un autor necesite usar un diseño que requiera desplazamiento horizontal. En ese caso, es suficiente proporcionar opciones dentro del contenido que cambien a un diseño que no requiera que el usuario se desplace horizontalmente para leer una línea de texto. Esto se puede lograr usando tecnología de conmutación de estilo estándar. Cabe señalar que también es suficiente diseñar el contenido de tal forma que se requiera el desplazamiento horizontal para acceder al contenido, pero que no sea necesario desplazarse horizontalmente para leer una línea de texto.", 
				categoriaTecnica);
	}

	/**
	 * 1. Abra el contenido que requiere desplazamiento horizontal en una ventana de pantalla completa.
	 * 2. Compruebe que haya una opción dentro del contenido para cambiar a un diseño que no requiera que el usuario se desplace horizontalmente para leer una línea de texto.
	 * 3. Activa la opción.
	 * 4. Compruebe para asegurarse de que no se requiera el desplazamiento horizontal para leer cualquier línea de texto.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAnulacionDesplazamientoHorizontal = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Posibilidad de anular el desplazamiento horizontal cambiando el diseño.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Cuando el sitio tenga contenido que requiera al usuario desplazarse horizontalmente debe existir la opción de cambiar el diseño a uno que elimine el desplazamiento horizontal.",
				"Si el sitio requiere en su versión normal barras de desplazamiento horizontales se debe brindar una alternativa que visualice el mismo contenido pero sin el uso de ellas.");
		comprobacionAnulacionDesplazamientoHorizontal.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAnulacionDesplazamientoHorizontal);
		return resultadoEvaluacionTecnica;
	}

}