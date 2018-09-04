package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG188 extends TecnicaGeneral {

	public TecnicaG188(CategoriaTecnica categoriaTecnica) {
		super(
				"G188",
				"Proporcionar un botón en la página para aumentar espacios de línea y espacios de párrafo.",
				"Muchas personas con discapacidades cognitivas tienen problemas para leer textos separados por espacios simples. Un botón que aumenta la altura de la línea les ayudará a leer el contenido. Para mantener la separación de los párrafos, el espacio entre los párrafos también debe aumentar, de modo que sea al menos 1,5 veces más alto que el espaciado entre líneas.", 
				categoriaTecnica);
	}

	/**
	 * 1. Compruebe que haya un botón o enlace en la página que aumente el tamaño de la altura de la línea y el espaciado entre párrafos, que está etiquetado como tal.
	 * 2. Activa el botón o enlace.
	 * 3. Compruebe que el botón o enlace aumenta la altura de la línea a al menos 1,5 (150%)
	 * 4. Compruebe que el botón o enlace aumenta el espaciado entre párrafos al menos 1,5 veces mayor que el espaciado entre líneas.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAumentoEspacioLineasYEntreParrafos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Botón que aumente el espacio de lineas y de párrafos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el sitio cuenta con un botón o enlace que aumente el tamaño de la altura de la línea y el espacio entre los párrafos.",
				"El sitio debe tener una opción para aumentar la altura de la línea al menos en 1,5 (150%) y el espacio entre párrados al menos 1,5 veces mayor al espacio entre líneas.");
		comprobacionAumentoEspacioLineasYEntreParrafos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAumentoEspacioLineasYEntreParrafos);
		return resultadoEvaluacionTecnica;
	}

}