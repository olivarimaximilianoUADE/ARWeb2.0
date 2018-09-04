package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaH75 extends TecnicaHTML {

	public TecnicaH75(CategoriaTecnica categoriaTecnica) {
		super(
				"H75",
				"Asegurarse de las páginas web sean bien formadas.", 
				"El objetivo de esta técnica es evitar errores claves que se sabe que causan problemas de las tecnologías de apoyo cuando están tratando de analizar su contenido. Una buena formación se comprueba mediante el análisis del documento con un analizador XML y comprobar si el informe de validación menciona errores de buena formación. Se requiere que cada analizador XML para comprobar la buena formación y detener el procesamiento normal cuando se encuentra un error de buena formación (un analizador XML no tiene que permitir la validación).",
				categoriaTecnica);
	}

	/**
	 * 1. Cargar cada archivo en un analizador XML de validación. 
	 * 2. Verificar que no hay errores de buena formación.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDocumentoHTMLMalFormado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Documento HTML mal formado.",
				"Verificar que no hay errores de buena formación.",
				"Asegúrate que la página web puede ser procesada y que está bien formada.");
		if (!this.getParseador().esBienFormado())
			comprobacionDocumentoHTMLMalFormado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDocumentoHTMLMalFormado);
		return resultadoEvaluacionTecnica;
	}

}