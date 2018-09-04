package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG130 extends TecnicaGeneral {

	public TecnicaG130(CategoriaTecnica categoriaTecnica) {
		super(
				"G130", 
				"Proporcionar encabezados descriptivos.", 
				"El objetivo de esta técnica es hacer descriptivos los títulos de las secciones dentro del contenido web. Los títulos y títulos descriptivos trabajan juntos para brindar a los usuarios una visión general del contenido y su organización. Los títulos descriptivos identifican secciones del contenido en relación con la página web como un todo y con otras secciones de la misma página web. Los títulos descriptivos ayudan a los usuarios a encontrar contenido específico y orientarse dentro de la página web", 
				categoriaTecnica);
	}

	/**
	 * 1. Determine si la página web contiene encabezados.
	 * 2. Verifique que cada encabezado identifique su sección del contenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEncabezadosDescriptivos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Títulos y subtítulos con encabezados descriptivos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Cada título y subtítulo presente en el sitio web: Verificar que cada uno sea descriptivo a la sección que representa.",
				"Ofrece títulos y subtítulos (h1, h2, h3, h4) descriptivas a las secciones dentro del contenido de la web.");
		comprobacionEncabezadosDescriptivos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEncabezadosDescriptivos);
		return resultadoEvaluacionTecnica;
	}
	
}
