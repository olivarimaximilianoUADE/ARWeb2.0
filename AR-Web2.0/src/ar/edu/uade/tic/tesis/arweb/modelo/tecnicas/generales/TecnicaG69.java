package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG69 extends TecnicaGeneral {

	public TecnicaG69(CategoriaTecnica categoriaTecnica) {
		super(
				"G69", 
				"Proporcionar una alternativa para los medios basados en tiempo.", 
				"El propósito de esta técnica es proporcionar una forma alternativa accesible de presentar la información en una presentación de medios sincronizados. En una presentación de medios sincronizados, la información es presentada en una variedad de maneras, incluyendo: diálogo, sonidos (naturales y artificiales), el ajuste y el fondo, las acciones y expresiones de las personas, animales, etc., texto o gráficos, y más.", 
				categoriaTecnica);
	}

	/**
	 * 1. Ver la presentación multimedia sincronizada mientras se hace referencia a la alternativa de la media basada en el tiempo.
	 * 2. Verificar que el diálogo en los medios alternativos para basados en el tiempo coincide con el diálogo en la presentación multimedia sincronizada.
	 * 3. Verificar que los medios alternativos basados en el tiempo tienen descripciones de sonidos.
	 * 4. Verificar que los medios alternativos basados en el tiempo tienen descripciones del entorno y los cambios de configuración.
	 * 5. Verificar que medios alternativos basados en el tiempo tienen descripciones de acciones y expresiones de los 'actores' (personas, animales, etc.).
	 * 6. Si las versiones alternativas están en una página separada, verificar la disponibilidad de links para permitir al usuario llegar a las otras versiones.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaMediosBasadosEnTiempo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa para los medios basados en tiempo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que los medios alternativos basados en el tiempo tienen descripciones de sonidos, del entorno y cambios de configuración, descripciones de acciones y expresiones de los \"actores\".",
				"Ofrece alternativas para los medios tempodependientes.");
		comprobacionAlternativaMediosBasadosEnTiempo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaMediosBasadosEnTiempo);
		return resultadoEvaluacionTecnica;
	}

}