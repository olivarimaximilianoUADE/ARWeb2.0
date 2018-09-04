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
				"El objetivo de esta t�cnica es hacer descriptivos los t�tulos de las secciones dentro del contenido web. Los t�tulos y t�tulos descriptivos trabajan juntos para brindar a los usuarios una visi�n general del contenido y su organizaci�n. Los t�tulos descriptivos identifican secciones del contenido en relaci�n con la p�gina web como un todo y con otras secciones de la misma p�gina web. Los t�tulos descriptivos ayudan a los usuarios a encontrar contenido espec�fico y orientarse dentro de la p�gina web", 
				categoriaTecnica);
	}

	/**
	 * 1. Determine si la p�gina web contiene encabezados.
	 * 2. Verifique que cada encabezado identifique su secci�n del contenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEncabezadosDescriptivos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"T�tulos y subt�tulos con encabezados descriptivos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Cada t�tulo y subt�tulo presente en el sitio web: Verificar que cada uno sea descriptivo a la secci�n que representa.",
				"Ofrece t�tulos y subt�tulos (h1, h2, h3, h4) descriptivas a las secciones dentro del contenido de la web.");
		comprobacionEncabezadosDescriptivos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEncabezadosDescriptivos);
		return resultadoEvaluacionTecnica;
	}
	
}
