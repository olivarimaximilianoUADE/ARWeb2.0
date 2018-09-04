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

public class TecnicaH39 extends TecnicaHTML {

	public TecnicaH39(CategoriaTecnica categoriaTecnica) {
		super(
				"H39", 
				"Usar elementos caption para asociar títulos de tabla con las tablas de datos.", 
				"El propósito de esta técnica es asociar por software los títulos de las tablas de datos cuando los títulos se proporcionan en la presentación. El título de una tabla es un identificador de la tabla y actúa como un encabezado. El elemento caption es el marcado adecuado para tal texto y se asegura de que el identificador se asocie a la tabla, incluso visualmente. Además, usar el elemento caption permite que los lectores de pantalla naveguen directamente al título de la tabla si hay uno presente. El elemento caption se puede utilizar aún si la tabla incluye un atributo summary. El elemento caption identifica la tabla mientras que el atributo summary ofrece una visión general de la finalidad o explica cómo navegar la tabla. Si se usan ambos, el título no debe duplicar la información en el resumen.",
				categoriaTecnica);
	}

	/**
	 * Para cada tabla de datos:
	 * 1. Verificar que la tabla incluye un elemento caption.
	 * 2. Verificar que el contenido del elemento caption identifica la tabla.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTablaSinCaption = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Tablas sin elemento \"caption\".",
				"Verificar que la tabla incluye un elemento \"caption\".",
				"Comunica la información y sus relaciones mediantes tabla de datos: el elemento \"caption\" para titular la tabla de datos.");
		ResultadoEvaluacionTecnicaItem comprobacionContenidoCaptionIdentificaTabla = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Contenido del elemento \"caption\" identifica la tabla.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el contenido del elemento \"caption\" identifica la tabla.",
				"Comunica la información y sus relaciones mediantes tabla de datos: el elemento \"caption\" para titular la tabla de datos.");
		for (Element elementoTABLE : this.getParseador().getElementos(HTMLElementName.TABLE)) {
			List<Element> listaElementosCaption = elementoTABLE.getAllElements(HTMLElementName.CAPTION);
			if (listaElementosCaption.isEmpty()) 
				comprobacionTablaSinCaption.procesar(elementoTABLE);
			else 
				for (Element elementoCAPTION : listaElementosCaption) 
					comprobacionContenidoCaptionIdentificaTabla.procesar(elementoCAPTION);
		}	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTablaSinCaption); 
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContenidoCaptionIdentificaTabla); 
		return resultadoEvaluacionTecnica;
	}

}