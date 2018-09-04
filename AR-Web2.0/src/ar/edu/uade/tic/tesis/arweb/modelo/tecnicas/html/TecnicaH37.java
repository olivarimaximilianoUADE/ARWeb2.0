package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.uade.tic.tesis.arweb.modelo.evaluacion.Tipologia;
import ar.edu.uade.tic.tesis.arweb.modelo.tecnica.CategoriaTecnica;
import ar.edu.uade.tic.tesis.arweb.util.parser.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH37 extends TecnicaHTML {

	public TecnicaH37(CategoriaTecnica categoriaTecnica) {
		super(
				"H37", 
				"Usar atributos alt en los elementos img.", 
				"Al usar el elemento img, especifique una breve alternativa textual con el atributo alt. El valor de este atributo se denomina \"texto alternativo\". Cuando una imagen contiene palabras que son importantes para la comprensión del contenido, el texto alternativo debe incluir esas palabras. Esto permitirá que el texto alternativo cumpla la misma función en la página que la imagen. Tenga en cuenta que no es necesario describir las características visuales de la imagen en sí, sino que se debe transmitir el mismo significado que la imagen.",
				categoriaTecnica);
	}

	/**
	 * 1. Examinar cada elemento 'img' en el contenido.
	 * 2. Verificar que cada elemento 'img' que transmite significado contiene un atributo 'alt'
	 * 3. Si la imagen contiene palabras que son importantes para entender el contenido, las palabras se incluyen en el texto alternativo. 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionImagenesSinAtributoAlt = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Imágenes sin atributo \"alt\".", 
				"Verificar que cada elemento \"img\" que transmite significado contiene un atributo \"alt\".", 
				"Utiliza el atributo \"alt\" en imágenes.");
		ResultadoEvaluacionTecnicaItem comprobacionImagenesNoTransmitenSignificado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Imágenes que no transmiten significado.", 
				TipoResultadoEvaluacion.MANUAL, 
				"Verificar que cada elemento \"img\" transmite significado.", 
				"No utilices una alternativa textual descriptiva para imágenes que deben ser ignoradas.");
		ResultadoEvaluacionTecnicaItem comprobacionImagenesConPalabrasSeIncluyenEnAtributoAlt = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Imágenes con palabras, se incluyen en el atributo \"alt\".", 
				TipoResultadoEvaluacion.IMPOSIBLE, 
				"Si la imagen contiene palabras que son importantes para entender el contenido, las palabras se incluyen en el texto alternativo.", 
				"Incluye en el texto alternativo las palabras que están dentro de las imágenes.");
		for (Element elementoIMG : this.getParseador().getElementos(HTMLElementName.IMG)) {
			String atributoALT = elementoIMG.getAttributeValue("alt");
			if (atributoALT == null) 
				comprobacionImagenesSinAtributoAlt.procesar(elementoIMG);
			else 
				if (atributoALT.isEmpty()) 
					comprobacionImagenesSinAtributoAlt.procesar(elementoIMG);
			comprobacionImagenesNoTransmitenSignificado.procesar(elementoIMG);
			comprobacionImagenesConPalabrasSeIncluyenEnAtributoAlt.procesar(elementoIMG);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenesSinAtributoAlt);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenesNoTransmitenSignificado);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenesConPalabrasSeIncluyenEnAtributoAlt);
		return resultadoEvaluacionTecnica;
	}

}