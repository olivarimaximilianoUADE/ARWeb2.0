package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.generales;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;

public class TecnicaG185 extends TecnicaGeneral {

	public TecnicaG185(CategoriaTecnica categoriaTecnica) {
		super(
				"G185",
				"Vinculación a todas las páginas del sitio desde la página de inicio.",
				"El objetivo de esta técnica es hacer posible que los usuarios localicen toda la información en un sitio web pequeño al proporcionar enlaces a todas las páginas web desde la página de inicio. Cuando el número de páginas en el sitio es lo suficientemente pequeño, la página de inicio puede contener información del mapa del sitio directamente. Las otras páginas en el sitio web contienen enlaces a la página de inicio. De esta manera, la página de inicio sirve como dos mecanismos en uno. Proporciona la navegación habitual a las páginas. También es un mapa de sitio de hecho para el sitio.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que la página de inicio contiene enlaces a todas las otras páginas en el sitio web. 
	 * 2. Verifique que todas las demás páginas del sitio web contengan enlaces a la página de inicio.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPaginaInicioEnlacesTodoElSitio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Página de inicio contiene enlaces a todas las páginas del sitio web.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la página de inicio tiene todos los enlaces a las otras páginas del sitio web.",
				"En la página de inicio del sitio web deben estar los enlaces a todas las páginas que conforman el sitio funcionando así como un mapa del sitio.");
		comprobacionPaginaInicioEnlacesTodoElSitio.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPaginaInicioEnlacesTodoElSitio);
		return resultadoEvaluacionTecnica;
	}

}
