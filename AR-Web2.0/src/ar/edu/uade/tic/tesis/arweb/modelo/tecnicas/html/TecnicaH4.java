package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;

public class TecnicaH4 extends TecnicaHTML {

	public TecnicaH4(CategoriaTecnica categoriaTecnica) {
		super(
				"H4",
				"Crear un orden de tabulación lógico a través de enlaces, controles de formulario y objetos.",
				"El objetivo de esta técnica es proporcionar un orden lógico de tabulación cuando el orden de tabulación predeterminado no es suficiente.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que tabindex es usado.
	 * 2. Si tabindex es usado, verificar que el orden de tabulación especificado por los atributos tabindex siguen las relaciones en el contenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionOrdenLogicoNavegacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Orden lógico de navegación.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Si el atributo \"tabindex\" es usado, verificar que el orden de tabulación especificado por los atributos \"tabindex\" siguen las relaciones en el contenido.",
				"No utilices el atributo \"tabindex\" para crear un orden de tabulación que no preserve el significado y la operatividad de la página.");
		for (Element elemento : this.getParseador().getElementos()) {
			String atributoTabIndex = elemento.getAttributeValue("tabindex");
			if (atributoTabIndex != null) 
				comprobacionOrdenLogicoNavegacion.procesar(elemento);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionOrdenLogicoNavegacion);
		return resultadoEvaluacionTecnica;
	}

}