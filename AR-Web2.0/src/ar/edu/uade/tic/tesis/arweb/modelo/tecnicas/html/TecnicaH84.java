package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH84 extends TecnicaHTML {

	public TecnicaH84(CategoriaTecnica categoriaTecnica) {
		super(
				"H84",
				"Usar un botón con un elemento select para realizar una acción.", 
				"El objetivo de esta técnica es permitir al usuario controlar cuando se realiza una acción, en lugar que la acción ocurra como un efecto secundario de la elección de un valor para el elemento select. El usuario puede inspeccionar los diferentes valores del elemento select, o puede optar por error el valor incorrecto, sin causar la acción que se produzca. Cuando el usuario está satisfecho con su elección, seleccionan el botón para realizar la acción. Esto es particularmente importante para los usuarios que están eligiendo el valor del elemento select a través del teclado, ya que navegar por las opciones del elemento select cambia el valor del control.",
				categoriaTecnica);
	}

	/**
	 * Por cada combinación de elemento select / elemento button:
	 * 1. Verificar que el foco en una opción en el elemento select no da lugar a ninguna acción.
	 * 2. Verificar que la selección del botón realiza la acción asociada con el valor actual del select.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCambiosCausadosPorElEventoOnChangeEnSelector = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Cambios causados por el evento \"onChange\" en un selector.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Por cada combinación de elemento \"select\" / elemento \"button\": Verificar que el foco en una opción en el elemento \"select\" no da lugar a ninguna acción.",
				"Si un cambio en un control de formulario causa un cambio de contexto, describe antes qué sucederá. No abras una vetana nueva -sin antes avisar- cuando cambia el estado de un botón de radio, una casilla de verificación o una lista de selección.");
		for (Element elementoSELECT : this.getParseador().getElementos(HTMLElementName.SELECT)) {
			String atributoOnchange = elementoSELECT.getAttributeValue("onchange");
			if ((atributoOnchange != null) && (!atributoOnchange.isEmpty())) 
				comprobacionCambiosCausadosPorElEventoOnChangeEnSelector.procesar(elementoSELECT);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCambiosCausadosPorElEventoOnChangeEnSelector);
		return resultadoEvaluacionTecnica;
	}

}