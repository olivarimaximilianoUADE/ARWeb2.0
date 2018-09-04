package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH73 extends TecnicaHTML {

	public TecnicaH73(CategoriaTecnica categoriaTecnica) {
		super(
				"H73",
				"Usar el atributo summary del elemento table para brindar un resumen de las tablas de datos.", 
				"El objetivo de esta técnica es proporcionar un breve resumen de cómo los datos se han organizado en una tabla o una breve explicación de cómo navegar en la tabla. El atributo summary del elemento table pone esta información a disposición de las personas que utilizan lectores de pantalla; la información no se muestra visualmente. El summary es útil cuando la tabla tiene una estructura compleja (por ejemplo, cuando hay varios conjuntos de encabezados de fila o columna, o cuando hay varios grupos de columnas o filas). El summary también puede ser útil para las tablas de datos simples que contienen muchas columnas o filas de datos. El atributo summary se puede usar o no la tabla incluye un elemento caption. Si se usan ambos, el summary no debe repetir el caption.",
				categoriaTecnica);
	}

	/**
	 * Para cada tabla de datos:
	 * 1. Si un summary está presente, verifica que el atributo summary describe la organización de la tabla o explica como usar la tabla.
	 * 2. Si ambos un atributo summary y un elemento caption están presentes para la tabla de datos, verificar que el summary no duplica el caption.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTablasSinSummary = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Tablas sin atributo \"summary\".",
				"Para cada tabla de datos: Verificar que el atributo \"summary\" esté presente.",
				"Comunica la información y sus relaciones mediantes tabla de datos: el atributo \"summary\" para resumir la tabla de datos.");
		ResultadoEvaluacionTecnicaItem comprobacionTablasConSummaryExplicandoUsoTabla = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Tablas con atributo \"summary\" explicando como usar la tabla.", 
				TipoResultadoEvaluacion.MANUAL,
				"Para cada tabla de datos: Si un atributo \"summary\" está presente, verifica que el atributo \"summary\" describe la organización de la tabla o explica como usar la tabla.",
				"Comunica la información y sus relaciones mediantes tabla de datos: el atributo \"summary\" para resumir la tabla de datos.");
		ResultadoEvaluacionTecnicaItem comprobacionTablasConSummaryDuplicaCaption = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Tablas con atributo \"summary\" que duplica elemento \"caption\".",
				"Para cada tabla de datos: Si ambos, un atributo \"summary\" y un elemento \"caption\" están presentes para la tabla de datos, verificar que el atributo \"summary\" no duplica el \"caption\".",
				"Comunica la información y sus relaciones mediantes tabla de datos: el atributo \"summary\" para resumir la tabla de datos.");
		for (Element elementoTABLE : this.getParseador().getElementos(HTMLElementName.TABLE)) {
			String atributoSummary = elementoTABLE.getAttributeValue("summary");
			if (atributoSummary == null) 
				comprobacionTablasSinSummary.procesar(elementoTABLE);
			else
				if (atributoSummary.isEmpty())
					comprobacionTablasSinSummary.procesar(elementoTABLE);
			List<Element> listaCaption = elementoTABLE.getAllElements(HTMLElementName.CAPTION);
			if ((atributoSummary != null) && (!listaCaption.isEmpty())) {
				if (atributoSummary.equals(listaCaption.get(0).getTextExtractor().toString()))
					comprobacionTablasConSummaryDuplicaCaption.procesar(elementoTABLE);
			}
			if (atributoSummary != null) 
				comprobacionTablasConSummaryExplicandoUsoTabla.procesar(elementoTABLE);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTablasSinSummary); 
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTablasConSummaryExplicandoUsoTabla); 
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTablasConSummaryDuplicaCaption); 
		return resultadoEvaluacionTecnica;
	}

}