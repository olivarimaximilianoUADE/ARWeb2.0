package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG183 extends TecnicaGeneral {

	public TecnicaG183(CategoriaTecnica categoriaTecnica) {
		super(
				"G183",
				"El uso de una relación de contraste de 3: 1 y la zona de texto y proporcionar señales visuales adicionales en el foco de enlaces o controles, donde se utiliza solo color para identif.",
				"La intención de esta técnica es proporcionar una señal visual redundante para usuarios que pueden no ser capaces de discernir la diferencia en el color del texto. El color se utiliza normalmente para indicar palabras que son enlaces dentro de un párrafo u otro bloque de texto. Por ejemplo, las palabras dispersas en el texto pueden ser enlaces de hipertexto que se identifican únicamente por una diferencia en el color y la zona de texto. Esta técnica se describe una forma de proporcionar señales adicionales en vuelo estacionario y se centran por lo que los usuarios que pueden tener dificultades para percibir las diferencias de color o con baja visión puedan identificarlos. Con esta técnica, una diferencia de luminancia relativa ( luminosidad) de 3:1 o mayor con el texto alrededor de ella se puede utilizar si la confirmación visual adicional está disponible cuando un usuario puntos o fichas al enlace. destacados visuales pueden, por ejemplo, tomar la forma de subrayado, un cambio en el estilo de fuente, como negrita o cursiva, o un aumento de tamaño de la fuente. Durante el uso de esta técnica es suficiente para satisfacer este criterio de éxito , no es la técnica preferida para diferenciar el texto del vínculo. Esto se debe a enlaces que utilizan la luminancia relativa del color por sí solo puede no ser evidente para las personas con ceguera al color negro / blanco. Si no hay un gran número de enlaces en el bloque de texto, se recomiendan subrayados para los enlaces.", 
				categoriaTecnica);
	}

	/**
	 * 1. Localizar todos los casos en los que solo color se utiliza para transmitir información sobre el texto.
	 * 2. Verificar que la luminancia relativa de la color del texto difiere de la luminancia relativa de texto que lo rodea por una relación de contraste de al menos 3:1.
	 * 3. Verificar que señalar (por encima del mouse) para el enlace provoca una mejora visual (como un subrayado, cambiar la fuente, etc.)
	 * 4. Verificar que mover el foco del teclado al enlace provoca una mejora visual (como un subrayado, cambiar la fuente, etc.)
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionInformacionMedianteColor = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Información mediante color.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la luminancia relativa del color del texto difiere de la luminancia relativa del texto que lo rodea por una relación de contraste de al menos 3:1.",
				"Cuando el color indica que el foco se posa en un enlace o en un control, garantiza un ratio de contraste mínimo de 3:1 con el contenido adyacente y ofrece señales visuales adicionales.");
		comprobacionInformacionMedianteColor.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionInformacionMedianteColor);
		return resultadoEvaluacionTecnica;
	}

}