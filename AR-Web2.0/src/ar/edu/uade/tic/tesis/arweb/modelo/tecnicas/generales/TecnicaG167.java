package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG167 extends TecnicaGeneral {

	public TecnicaG167(CategoriaTecnica categoriaTecnica) {
		super(
				"G167", 
				"El uso de un botón adyacente para etiquetar el propósito de un campo.", 
				"Cuando un botón invoca una función en un campo de entrada, tiene una etiqueta de texto claro, y se rindió al lado del campo de entrada, el botón también actúa como una etiqueta para el campo de entrada. Esta etiqueta ayuda a los usuarios a entender el propósito del campo sin introducir texto repetitivo en la página Web. Botones que etiquetan los campos de texto individuales suelen seguir el campo de entrada.",
				categoriaTecnica);
	}

	/**
	 * Para un campo y un botón de uso de esta técnica:
	 * 1. Verificar que el campo y el botón son adyacentes entre sí en la secuencia de lectura determinada mediante programación.
	 * 2. Verificar que el campo y el botón se representan visualmente una junto a otra.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionBotonAdyacenteParaEtiquetarCampo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Botón adyacente para etiquetar el propósito de un campo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para un campo y un botón de uso de esta técnica: Verificar que el campo y el botón son adyacentes entre sí en la secuencia de lectura determinada mediante programación.",
				"Si no puedes identificar el control de formulario con el atributo \"title\" ni asociarle una etiqueta al elemento, sitúa un botón adyacente para explicar el objetivo de ese campo.");
		comprobacionBotonAdyacenteParaEtiquetarCampo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionBotonAdyacenteParaEtiquetarCampo);
		return resultadoEvaluacionTecnica;
	}

}