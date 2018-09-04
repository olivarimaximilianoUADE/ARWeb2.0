package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG92 extends TecnicaGeneral {

	public TecnicaG92(CategoriaTecnica categoriaTecnica) {
		super(
				"G92",
				"Proporcionar descripción larga de contenido no textual que sirve al mismo propósito y presenta la misma información.",
				"El objetivo de esta técnica es proporcionar una alternativa textual larga que sirve al mismo propósito y presenta la misma información que el contenido no textual original cuando una alternativa textual corta no es suficiente. Combinada con la alternativa textual corta, la descripción larga debe ser capaz de sustituir el contenido no textual. La alternativa textual corta identifica el contenido no textual; la alternativa textual larga proporciona la información. Si el contenido no textual fuera eliminado de la página y se sustituyese por las descripciones cortas y largas, la página todavía proporcionaría la misma función y la información. Al decidir lo que debería ir en las alternativas de texto, las siguientes preguntas son útiles: ¿Por qué esta este contenido no textual aquí? ¿Qué información presenta? ¿Qué propósito tiene que cumplir? Si no podria utilizar el contenido no textual, ¿qué palabras usaria para transmitir la misma función y/o información?.", 
				categoriaTecnica);
	}

	/**
	 * 1. Eliminar, ocultar o enmascarar el contenido no textual.
	 * 2. Mostrar la descripción larga.
	 * 3. Verificar que la descripción larga transmite la misma información que se transmite por el contenido no textual.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualTransmiteMismaInformacionContenidoNoTextual = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa textual larga transmite misma información que se se transmite por el contenido no textual.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la descripción larga transmite la misma información que se transmite por el contenido no textual.",
				"Enlaza la información en texto que ofrezca la misma información que el contenido no textual.");
		comprobacionAlternativaTextualTransmiteMismaInformacionContenidoNoTextual.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualTransmiteMismaInformacionContenidoNoTextual);
		return resultadoEvaluacionTecnica;
	}

}