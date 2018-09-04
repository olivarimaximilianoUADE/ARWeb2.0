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
				"Vinculaci�n a todas las p�ginas del sitio desde la p�gina de inicio.",
				"El objetivo de esta t�cnica es hacer posible que los usuarios localicen toda la informaci�n en un sitio web peque�o al proporcionar enlaces a todas las p�ginas web desde la p�gina de inicio. Cuando el n�mero de p�ginas en el sitio es lo suficientemente peque�o, la p�gina de inicio puede contener informaci�n del mapa del sitio directamente. Las otras p�ginas en el sitio web contienen enlaces a la p�gina de inicio. De esta manera, la p�gina de inicio sirve como dos mecanismos en uno. Proporciona la navegaci�n habitual a las p�ginas. Tambi�n es un mapa de sitio de hecho para el sitio.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verifique que la p�gina de inicio contiene enlaces a todas las otras p�ginas en el sitio web. 
	 * 2. Verifique que todas las dem�s p�ginas del sitio web contengan enlaces a la p�gina de inicio.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPaginaInicioEnlacesTodoElSitio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"P�gina de inicio contiene enlaces a todas las p�ginas del sitio web.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la p�gina de inicio tiene todos los enlaces a las otras p�ginas del sitio web.",
				"En la p�gina de inicio del sitio web deben estar los enlaces a todas las p�ginas que conforman el sitio funcionando as� como un mapa del sitio.");
		comprobacionPaginaInicioEnlacesTodoElSitio.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPaginaInicioEnlacesTodoElSitio);
		return resultadoEvaluacionTecnica;
	}

}
