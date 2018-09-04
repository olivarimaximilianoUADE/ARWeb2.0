package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG59 extends TecnicaGeneral {

	public TecnicaG59(CategoriaTecnica categoriaTecnica) {
		super(
				"G59",
				"La colocación de los elementos interactivos en un orden que sigue secuencias y relaciones dentro del contenido.",
				"El objetivo de esta técnica es asegurar que los elementos interactivos reciben el foco en un orden que sigue a las secuencias y relaciones en el contenido. Al diseñar el contenido, los elementos interactivos, como los enlaces y controles de formulario se colocan en el contenido para que el orden de tabulación por defecto se ajuste a las secuencias y relaciones en el contenido. Cada tecnología define su orden de tabulación predeterminado, por lo que el mecanismo para la colocación de los controles en el contenido dependerá de la tecnología utilizada. A modo de ejemplo, en HTML, el orden de selección predeterminado sigue el orden en el que aparecen los elementos en el origen del contenido. Cuando la orden de la fuente HTML coincide con el orden visual de la página Web, la tabulación a través de los contenidos sigue el diseño visual del contenido. Cuando la orden de origen no coincide con el orden visual, el orden de tabulación a través del contenido debe reflejar las relaciones lógicas en el contenido que se muestra visualmente.", 
				categoriaTecnica);
	}

	/**
	 * 1. Determinar el orden de los elementos interactivos en el contenido.
	 * 2. Determinar el orden lógico de los elementos interactivos.
	 * 3. Verificar que el orden de los elementos interactivos en el contenido es el mismo que el orden lógico.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionOrdenLogicoNavegacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Orden lógico de navegación.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el orden de los elementos interactivos en el contenido es el mismo que el orden lógico.",
				"Sitúa los elementos interactivos en una secuencia que siga el orden y las relaciones dentro del contenido.");
		comprobacionOrdenLogicoNavegacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionOrdenLogicoNavegacion);
		return resultadoEvaluacionTecnica;
	}

}