package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH67 extends TecnicaHTML {

	public TecnicaH67(CategoriaTecnica categoriaTecnica) {
		super(
				"H67", 
				"El uso de alt nulo y sin atributo title en los elementos img para imágenes que AT debe ignorar.",	
				"El propósito de esta técnica es mostrar cómo las imágenes se pueden marcar de modo que puedan ser ignorados por la tecnología de asistencia. Si no se utiliza un atributo title, y el texto alternativo se establece en nulo (es decir alt = \" \" ) indica que la tecnología de asistencia que la imagen puede ser ignorado.",
				categoriaTecnica);
	}

	/**
	 * Para cada imagen:
	 * 1. Verificar que el atributo title está ausente o vacío.
	 * 2. Verificar que el atributo alt está presente o vacío.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionImagenesConAltVacio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Imágenes con atributo \"alt\" vacío.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el atributo \"alt\" está presente o vacío.",
				"Si las imágenes deben ser ignoradas por los productos de apoyo deja el atributo \"alt\" vacío.");
		for (Element elementoIMG : this.getParseador().getElementos(HTMLElementName.IMG)) {
			String atributoAlt = elementoIMG.getAttributeValue("alt");
			if ((atributoAlt != null) && (atributoAlt.isEmpty())) 
				comprobacionImagenesConAltVacio.procesar(elementoIMG);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenesConAltVacio);
		return resultadoEvaluacionTecnica;
	}

}