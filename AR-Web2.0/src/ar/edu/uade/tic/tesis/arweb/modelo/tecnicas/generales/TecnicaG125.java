package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG125 extends TecnicaGeneral {

	public TecnicaG125(CategoriaTecnica categoriaTecnica) {
		super(
				"G125",
				"Proporcionar enlaces para navegar a p�ginas web relacionadas.",
				"El objetivo de esta t�cnica es hacer posible que los usuarios localicen informaci�n adicional al proporcionar enlaces a p�ginas web relacionadas.", 
				categoriaTecnica);
	}

	/**
	 * Para cada enlace en la p�gina web:
	 *  1. Verifique si el enlace lleva a informaci�n relacionada.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlaceInformacionRelacionada = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Enlaces conducen a informaci�n relacionada.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que los enlaces llevan a sitios webs con informaci�n relacionada.",
				"Cuando exista la posibilidad de enlazar la informaci�n del sitio con otros externos se lo debe hacer mediante la utilizaci�n de vinculos para que de esta forma el usuario pueda obtener informaci�n adicional.");
		comprobacionEnlaceInformacionRelacionada.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlaceInformacionRelacionada);
		return resultadoEvaluacionTecnica;
	}

}