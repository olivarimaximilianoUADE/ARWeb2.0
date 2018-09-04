package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG57 extends TecnicaGeneral {

	public TecnicaG57(CategoriaTecnica categoriaTecnica) {
		super(
				"G57", 
				"Ordenar el contenido de una secuencia significativa.", 
				"El objetivo de esta técnica es asegurar que el orden del contenido que se presenta para las ayudas técnicas permite al usuario tener sentido del contenido. Algunas técnicas permiten que el contenido que pasarán a ser visualmente en una secuencia significativa incluso si esta es diferente del orden en el que el contenido está codificado en el archivo de origen subyacente. Por ejemplo, cuando se mezclan idiomas con direccionalidad diferente en HTML, el algoritmo bidireccional puede posicionar puntuación en el lugar equivocado en la prestación visual. El problema de representación visual podría corregirse moviendo la puntuación en el flujo de contenido para que el algoritmo bidireccional lo posiciona como se desee, pero esto podría exponer el contenido incorrecto fin a la tecnología de asistencia . El contenido se vuelve tanto en el orden correcto visualmente y se expone a la tecnología de asistencia en el orden correcto mediante el uso de marcadores para anular el algoritmo bidireccional. Cuando se representa visualmente, los espacios en blanco como espacio o ficha no pueden aparecer como parte del contenido. Sin embargo, cuando se inserta en el contenido para controlar el formato visual, que pueden interferir con el significado del contenido. En una granularidad más grande, el control de la colocación de bloques de contenido en un documento HTML utilizando tablas de diseño puede producir una representación en la que la información relacionada está posicionado junto visualmente , pero separado en el flujo de contenido. Dado que las tablas de diseño se leen fila por fila, si el título de una ilustración se coloca en la fila siguiente a la ilustración , puede que sea imposible asociar el título con la imagen.", 
				categoriaTecnica);
	}

	/**
	 * 1. Linealizar el contenido con un enfoque estándar para la tecnología (por ejemplo, la eliminación de estilos de diseño o ejecutar una herramienta de linealización)
	 * 2. Verificar  si el orden del contenido da el mismo significado que el original.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionContenidoSecuenciaSignificativaOrdenado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Contenido de una secuencia significativa ordenado.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar  si el orden del contenido da el mismo significado que el original.",
				"Ordena todos los contenidos de la página web en un orden que tenga sentido y maquétalos asegurándote si el orden del contenido da el mismo significado que el original.");
		comprobacionContenidoSecuenciaSignificativaOrdenado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContenidoSecuenciaSignificativaOrdenado);
		return resultadoEvaluacionTecnica;
	}

}