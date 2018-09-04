package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG134 extends TecnicaGeneral {

	public TecnicaG134(CategoriaTecnica categoriaTecnica) {
		super(
				"G134", 
				"Validar las páginas Web.", 
				"El objetivo de esta técnica es evitar las ambigüedades en las páginas web que con frecuencia resultan de código que no es válido según las especificaciones formales. se utiliza el mecanismo de cada tecnología para especificar la versión de la tecnología y la tecnología, y la página Web se valida con la especificación formal de dicha tecnología. Si un validador para que la tecnología está disponible, el desarrollador puede usarlo. Validación por lo general eliminar ambigüedades (y más), ya que un paso esencial en la validación es comprobar el uso adecuado de marcado de que la tecnología (en un lenguaje de marcas) o el código (en otras tecnologías). La validación no significa necesariamente comprobar la plena conformidad con una especificación, pero es el mejor medio para comprobar automáticamente el contenido en contra de su especificación.", 
				categoriaTecnica);
	}

	/**
	 * Para HTML, SGML y basados en tecnologías basadas en XML:
	 * 1. Cargar cada página o documento en un analizador de validación.
	 * 2. Verificar que no hay errores de validación se encuentran.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPaginaBienFormada = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Página 'bien formada'.",
				"Verificar que no hay errores de validación.",
				"Asegúrate que la página web puede ser procesada y está bien formada.");
		if (!this.getParseador().esBienFormado())
			comprobacionPaginaBienFormada.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPaginaBienFormada);
		return resultadoEvaluacionTecnica;
	}

}