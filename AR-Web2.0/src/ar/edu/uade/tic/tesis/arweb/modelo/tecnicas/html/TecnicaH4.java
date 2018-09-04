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
				"Crear un orden de tabulaci�n l�gico a trav�s de enlaces, controles de formulario y objetos.",
				"El objetivo de esta t�cnica es proporcionar un orden l�gico de tabulaci�n cuando el orden de tabulaci�n predeterminado no es suficiente.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que tabindex es usado.
	 * 2. Si tabindex es usado, verificar que el orden de tabulaci�n especificado por los atributos tabindex siguen las relaciones en el contenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionOrdenLogicoNavegacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Orden l�gico de navegaci�n.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Si el atributo \"tabindex\" es usado, verificar que el orden de tabulaci�n especificado por los atributos \"tabindex\" siguen las relaciones en el contenido.",
				"No utilices el atributo \"tabindex\" para crear un orden de tabulaci�n que no preserve el significado y la operatividad de la p�gina.");
		for (Element elemento : this.getParseador().getElementos()) {
			String atributoTabIndex = elemento.getAttributeValue("tabindex");
			if (atributoTabIndex != null) 
				comprobacionOrdenLogicoNavegacion.procesar(elemento);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionOrdenLogicoNavegacion);
		return resultadoEvaluacionTecnica;
	}

}