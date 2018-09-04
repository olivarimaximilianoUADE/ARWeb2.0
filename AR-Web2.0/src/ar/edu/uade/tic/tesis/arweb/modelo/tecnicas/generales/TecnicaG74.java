package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG74 extends TecnicaGeneral {

	public TecnicaG74(CategoriaTecnica categoriaTecnica) {
		super(
				"G74",
				"Proporcionar una larga descripción en texto cerca del contenido no textual, con una referencia a la ubicación de la descripción larga en la descripción breve.",
				"El objetivo de esta técnica es proporcionar una descripción larga sin que el usuario requiera saltar a otra ubicación de la descripción. También permite que todos los usuarios puedan ver la descripción que puede ser útil para cualquier persona que pudiera perderse algunas características en el contenido no textual. Con esta técnica, la descripción larga se proporciona como parte de la presentación estándar (es decir, todo el mundo lo recibe). La descripción está situada cerca del contenido no textual, pero no tiene que ser el siguiente artículo. Por ejemplo, puede haber una leyenda bajo un gráfico con la larga descripción proporcionada en el párrafo siguiente. La ubicación de esta descripción larga es luego proporcionada dentro de la alternativa de texto corto asi el usuario sabe dónde buscarla por si no pueden ver el contenido no textual.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que la alternativa de texto corto incluye la ubicación de la descripción larga.
	 * 2. Verificar que la descripción larga se encuentra cerca del contenido no textual tanto visual como en el orden de lectura lineal.
	 * 3. Verificar que la descripción larga transmite la misma información que el contenido no textual.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualCercaContenidoNoTextual = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa textual cerca del contenido no textual.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la descripción larga se encuentra cerca del contenido no textual tanto visual como en el orden de lectura lineal.",
				"Asegúrate que la descripción larga se encuentra cerca del contenido no textual tanto visual como en el orden de lectura lineal.");
		comprobacionAlternativaTextualCercaContenidoNoTextual.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualCercaContenidoNoTextual);
		return resultadoEvaluacionTecnica;
	}

}