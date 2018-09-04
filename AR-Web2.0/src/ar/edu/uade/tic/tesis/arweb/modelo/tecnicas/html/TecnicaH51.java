package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH51 extends TecnicaHTML {

	public TecnicaH51(CategoriaTecnica categoriaTecnica) {
		super(
				"H51", 
				"Usar tablas para presentar información tabular.",
				"El propósito de esta técnica es presentar información tabular de una manera que preserve las relaciones dentro de la información, incluso cuando los usuarios no puedan ver la tabla o el formato de presentación es cambiado. La información se considera tabular cuando existen relaciones lógicas entre texto, números, imágenes u otros datos en dos dimensiones (vertical y horizontal). Estas relaciones son representadas en columnas y filas, y las columnas y las filas deben ser reconocibles a fin de que las relaciones lógicas puedan ser percibidas. Utilizando el elemento table con los elementos hijos tr, th y td hace que estas relaciones resulten perceptibles. Técnicas tales como el uso de tabuladores para crear columnas o usar el elemento pre son puramente visuales y las relaciones lógicas implícitas visualmente se pierden si el usuario no puede ver la tabla o se cambia la presentación visual. Aunque las WCAG no prohíben el uso de tablas para maquetar, se recomienda usar diseños basados en CSS para conservar el sentido semántica del elemento table definido en HTML y XHTML, y para cumplir con la práctica de separar la presentación del contenido.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar la presencia de información tabular.
	 * 2. Para cada ocurrencia de información tabular:
	 * 		a. Verificar que la tabla está marcada con un mínimo de elementos de la tabla, tr, th y td se utiliza.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTablaSinFilas = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Tablas sin filas (\"tr\").",
				"Verificar que la tabla está marcada con un mínimo de elementos \"tr\" de la tabla.",
				"Comunica la información y sus relaciones mediantes tabla de datos.");
		ResultadoEvaluacionTecnicaItem comprobacionTablaSinCeldasEncabezado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Tablas sin celdas de encabezado (\"th\").",
				"Verificar que la tabla está marcada con un mínimo de elementos \"th\" de la tabla.",
				"Comunica la información y sus relaciones mediantes tabla de datos.");
		ResultadoEvaluacionTecnicaItem comprobacionTablaSinCeldas = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Tablas sin celdas (\"td\").",
				"Verificar que la tabla está marcada con un mínimo de elementos \"td\" de la tabla.",
				"Comunica la información y sus relaciones mediantes tabla de datos.");
		for (Element elementoTABLE : this.getParseador().getElementos(HTMLElementName.TABLE)) {
			if (elementoTABLE.getAllElements(HTMLElementName.TR).isEmpty()) 
				comprobacionTablaSinFilas.procesar(elementoTABLE);
			if (elementoTABLE.getAllElements(HTMLElementName.TH).isEmpty()) 
				comprobacionTablaSinCeldasEncabezado.procesar(elementoTABLE);
			if (elementoTABLE.getAllElements(HTMLElementName.TD).isEmpty()) 
				comprobacionTablaSinCeldas.procesar(elementoTABLE);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTablaSinFilas); 
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTablaSinCeldasEncabezado); 
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTablaSinCeldas); 
		return resultadoEvaluacionTecnica;
	}

}