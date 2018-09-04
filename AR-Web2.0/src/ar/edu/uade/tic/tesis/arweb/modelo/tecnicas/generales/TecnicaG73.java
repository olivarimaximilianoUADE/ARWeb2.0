package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG73 extends TecnicaGeneral {

	public TecnicaG73(CategoriaTecnica categoriaTecnica) {
		super(
				"G73",
				"Proporcionar una larga descripción en otro lugar con un enlace a la misma que se encuentra inmediatamente adyacente al contenido no textual.",
				"El objetivo de esta técnica es proporcionar una manera de enlazar a largas descripciones remotas de las tecnologías que no cuentan con una larga descripción de funciones integrada directamente en ellas (por ejemplo, longdesc) o cuando la función es conocida por no ser compatible. Con esta técnica, la descripción larga se proporciona en otro lugar que el contenido no textual. Esto podría ser en otro lugar dentro de la misma URI o en otro URI. Un enlace a la descripción larga está previsto que se encuentra inmediatamente adyacente al contenido no textual. El enlace puede ser inmediatamente antes o después de que el contenido no textual. Si la descripción se encuentra junto con otro texto a continuación, poner 'Fin de la descripción' al final para que sepan cuándo dejar de leer y volver a la página principal. Si un botón 'Volver' no va a llevar a la persona de nuevo al punto desde el que saltaron, se proporciona a continuación un enlace a la ubicación del contenido no textual. Esta técnica era utilizada comúnmente en HTML antes de la adicion de 'longdesc' a la especificación. En HTML se denominaba D-Link, porque se implementaba normalmente poniendo una D junto a las imágenes y el uso de la D como un enlace a la descripción larga. Esta técnica no es una tecnología específica y puede ser utilizado en cualquier tecnología que soporta enlaces.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar la presencia de un enlace inmediatamente antes o después que el contenido no textual.
	 * 2. Verificar que el enlace es un enlace válido que apunta directamente a la descripción larga de este contenido no textual particular.
	 * 3. Verificar que la descripción larga transmite la misma información que el contenido no textual.
	 * 4. Verificar la disponibilidad de un enlace o la funcion retornar para devolver al usuario a la ubicación original del contenido no textual.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlaceAntesDespuesContenidoNoTextual = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Presencia de enlace antes o después que el contenido no textual.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar la presencia de un enlace inmediatamente antes o después que el contenido no textual.",
				"Utiliza un archivo externo con la descripción extensa, indicando su localización con un enlace situado justo al lado del contenido no textual.");
		comprobacionEnlaceAntesDespuesContenidoNoTextual.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlaceAntesDespuesContenidoNoTextual);
		return resultadoEvaluacionTecnica;
	}

}